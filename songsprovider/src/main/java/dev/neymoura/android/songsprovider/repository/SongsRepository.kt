package dev.neymoura.android.songsprovider.repository

import dev.neymoura.android.songsprovider.model.MusicalData
import dev.neymoura.android.songsprovider.repository.remote.SongsRemoteRepository

class SongsRepository(private val remoteRepository: SongsRemoteRepository) {

    suspend fun fetchSongs(artists: List<Long>, songsLimit: Int): Result<List<MusicalData>> =
        remoteRepository.fetchSongs(artists, songsLimit)
}