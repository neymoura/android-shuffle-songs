package dev.neymoura.android.songsprovider.usecase

import androidx.annotation.VisibleForTesting
import dev.neymoura.android.songsprovider.commons.Resource
import dev.neymoura.android.songsprovider.model.MusicalData
import dev.neymoura.android.songsprovider.repository.SongsRepository
import java.lang.reflect.Modifier.PRIVATE
import kotlin.random.Random

private const val RANDOM_SEED = 571989L

private const val WRAPPER_TRACK_KEY = "track"

private const val DEFAULT_TRACKS_LIMIT = 5
private val default_artists: List<Long> = listOf(909253, 1171421960, 358714030, 1419227, 264111789)


open class SongsUseCase(private val songsRepository: SongsRepository) {

    /**
     * Recovers the shuffled songs list
     */
    suspend fun fetchSongs(
        artists: List<Long> = default_artists,
        tracksLimit: Int = DEFAULT_TRACKS_LIMIT
    ): Resource<List<MusicalData>> {
        val result = songsRepository.fetchSongs(artists, tracksLimit)
        return result.flowTo(::shuffleSongs)
    }

    /**
     * Shuffles the songs list without consecutive songs from same artist
     */
    @VisibleForTesting(otherwise = PRIVATE)
    fun shuffleSongs(musicalData: Resource<List<MusicalData>>): Resource<List<MusicalData>> {

        return if (musicalData.isSuccess) {
            musicalData.data?.let { validMusicalData ->

                val tracks = validMusicalData
                    .filter { it.wrapperType == WRAPPER_TRACK_KEY }
                    .toMutableList()

                val random = Random(RANDOM_SEED)
                val shuffledTracks = mutableListOf<MusicalData>()

                // Initiates the shuffledTracks with a random track
                shuffledTracks.add(tracks.shuffled(random).first())

                do {

                    // Select a track which has a different artist id from the last track in shuffledTracks
                    val selectedTrack = tracks.shuffled(random)
                        .firstOrNull { it.artistId != shuffledTracks.last().artistId
                                || it.artistId != shuffledTracks.first().artistId }
                        ?: continue

                    tracks.remove(selectedTrack)

                    // Remove the selected track and add it to the shuffledList
                    if (selectedTrack.artistId != shuffledTracks.last().artistId) {
                        shuffledTracks.add(selectedTrack)
                    } else {
                        shuffledTracks.add(0, selectedTrack)
                    }

                } while (tracks.isNotEmpty())

                return Resource.success(shuffledTracks)

            } ?: musicalData

        } else {
            musicalData
        }

    }

    // TODO: Move flowTo function to a future existing commons module
    /**
     * Utility function to stream Result<T> to a function if is success, or return it's own value if
     * it's a failure
     *
     * @param to function to invoked if Result.isSuccess
     * @return `this` if Result.isFailure or result of `to` if Result.isSuccess
     */
    @VisibleForTesting(otherwise = PRIVATE)
    fun <T> Resource<T>.flowTo(to: (Resource<T>) -> Resource<T>): Resource<T> {
        return when {
            this.isSuccess -> to.invoke(this)
            else -> this
        }
    }

}