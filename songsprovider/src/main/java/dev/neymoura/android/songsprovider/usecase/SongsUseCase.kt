package dev.neymoura.android.songsprovider.usecase

import dev.neymoura.android.songsprovider.model.MusicalData
import dev.neymoura.android.songsprovider.repository.SongsRepository

class SongsUseCase(private val songsRepository: SongsRepository) {

    suspend fun fetchSongs(artists: List<Long>, songsLimit: Int): Result<List<MusicalData>> {
        return songsRepository.fetchSongs(artists, songsLimit)
    }

}