package dev.neymoura.android.songsprovider.repository

import dev.neymoura.android.songsprovider.commons.Resource
import dev.neymoura.android.songsprovider.model.MusicalData

interface ISongRepository {
    suspend fun fetchSongs(artists: List<Long>, songsLimit: Int): Resource<List<MusicalData>>
}

