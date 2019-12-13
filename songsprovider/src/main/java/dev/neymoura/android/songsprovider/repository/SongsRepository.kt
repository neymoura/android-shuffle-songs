package dev.neymoura.android.songsprovider.repository

import dev.neymoura.android.songsprovider.commons.Resource
import dev.neymoura.android.songsprovider.model.MusicalData

open class SongsRepository(private val remoteRepository: ISongRepository) {

    suspend fun fetchSongs(artists: List<Long>, songsLimit: Int): Resource<List<MusicalData>> =
        remoteRepository.fetchSongs(artists, songsLimit)
}