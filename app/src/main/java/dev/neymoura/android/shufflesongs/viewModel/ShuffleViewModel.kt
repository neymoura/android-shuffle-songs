package dev.neymoura.android.shufflesongs.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.neymoura.android.songsprovider.usecase.SongsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val DEFAULT_LIMIT = 5
private val artists: List<Long> = listOf(909253, 1171421960, 358714030, 1419227, 264111789)

class ShuffleViewModel(
    private val context: Application,
    private val songsUseCase: SongsUseCase
) : AndroidViewModel(context) {

    // TODO: Bind something =)
    fun fetchSongs() {
        CoroutineScope(Dispatchers.IO).launch {
            val fetchSongs = songsUseCase.fetchSongs(artists, DEFAULT_LIMIT)
            fetchSongs
        }
    }

}