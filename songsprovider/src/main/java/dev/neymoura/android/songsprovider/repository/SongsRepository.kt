package dev.neymoura.android.songsprovider.repository

import dev.neymoura.android.songsprovider.commons.Resource
import dev.neymoura.android.songsprovider.model.MusicalData
import dev.neymoura.android.songsprovider.repository.remote.SongsRemoteRepository

class SongsRepository(private val remoteRepository: SongsRemoteRepository) {

    suspend fun fetchSongs(artists: List<Long>, songsLimit: Int): Resource<List<MusicalData>> =
        remoteRepository.fetchSongs(artists, songsLimit)
}