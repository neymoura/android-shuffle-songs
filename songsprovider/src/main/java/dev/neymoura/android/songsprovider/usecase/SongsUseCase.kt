package dev.neymoura.android.songsprovider.usecase

import dev.neymoura.android.songsprovider.model.Track
import dev.neymoura.android.songsprovider.model.Wrapper
import dev.neymoura.android.songsprovider.repository.SongsRepository

class SongsUseCase(private val songsRepository: SongsRepository) {

    suspend fun fetchSongs(artists: List<Long>, songsLimit: Int): Result<List<Wrapper>> {
        return songsRepository.fetchSongs(artists, songsLimit)
    }

    suspend fun shuffleTracks(songs: List<Track>) {
        // TODO: Shuffle songs
    }

}