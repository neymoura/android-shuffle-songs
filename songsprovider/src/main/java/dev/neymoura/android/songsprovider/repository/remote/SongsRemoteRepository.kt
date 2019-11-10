package dev.neymoura.android.songsprovider.repository.remote

import dev.neymoura.android.songsprovider.api.LookupApi
import dev.neymoura.android.songsprovider.commons.Resource
import dev.neymoura.android.songsprovider.exception.ApiException
import dev.neymoura.android.songsprovider.model.MusicalData
import retrofit2.Retrofit

class SongsRemoteRepository(retrofit: Retrofit) {

    private val api = retrofit.create(LookupApi::class.java)

    suspend fun fetchSongs(artists: List<Long>, songsLimit: Int): Resource<List<MusicalData>> {
        return try {
            val response = api.lookup(parseArtistIdList(artists), songsLimit)
            if (response.isSuccessful && response.body()?.results != null) {
                Resource.success(response.body()?.results!!)
            } else {
                Resource.failure(ApiException("Remote API Failure!"))
            }
        } catch (_: Exception) {
            Resource.failure(ApiException("Remote API Failure!"))
        }
    }

    private fun parseArtistIdList(artists: List<Long>) =
        artists.joinToString(",")

}