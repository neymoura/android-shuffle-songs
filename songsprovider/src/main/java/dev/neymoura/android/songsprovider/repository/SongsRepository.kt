package dev.neymoura.android.songsprovider.repository

import dev.neymoura.android.songsprovider.model.Wrapper
import dev.neymoura.android.songsprovider.repository.remote.SongsRemoteRepository

class SongsRepository(private val remoteRepository: SongsRemoteRepository) {

    suspend fun fetchSongs(artists: List<Long>, songsLimit: Int): Result<List<Wrapper>> =
        remoteRepository.fetchSongs(artists, songsLimit)
}