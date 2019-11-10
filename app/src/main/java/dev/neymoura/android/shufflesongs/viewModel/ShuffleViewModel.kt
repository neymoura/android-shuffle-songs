package dev.neymoura.android.shufflesongs.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.neymoura.android.songsprovider.commons.Resource
import dev.neymoura.android.songsprovider.model.MusicalData
import dev.neymoura.android.songsprovider.usecase.SongsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShuffleViewModel(
    context: Application,
    private val songsUseCase: SongsUseCase
) : AndroidViewModel(context) {

    // Loading live data, with backing property
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    // Songs live data, with backing property
    private val _songs = MutableLiveData<Any>()
    val songs: LiveData<Any> = _songs

    // TODO: Bind something =)
    fun fetchSongs() {
        CoroutineScope(Dispatchers.IO).launch {
            _loading.postValue(true)
            fetchSongsCallback(songsUseCase.fetchSongs())
        }
    }

    private fun fetchSongsCallback(songsResult: Resource<List<MusicalData>>) {
        when {
            songsResult.isSuccess -> {
                // TODO: Create UI Model
                // TODO: Post UI Model on its live data
                songsResult.data
            }
            songsResult.isFailure -> {
                // TODO: Bind a error message?
            }
        }
        _loading.postValue(false)
    }

}