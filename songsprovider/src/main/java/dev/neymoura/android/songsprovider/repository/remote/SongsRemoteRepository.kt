package dev.neymoura.android.songsprovider.repository.remote

import dev.neymoura.android.songsprovider.api.LookupApi
import dev.neymoura.android.songsprovider.exception.ApiException
import dev.neymoura.android.songsprovider.model.Wrapper
import retrofit2.Retrofit
import java.lang.Exception

class SongsRemoteRepository(retrofit: Retrofit) {

    private val api = retrofit.create(LookupApi::class.java)

    suspend fun fetchSongs(artists: List<Long>, songsLimit: Int): Result<List<Wrapper>> {
        return try {
            val response = api.lookup(parseArtistIdList(artists), songsLimit)
            if (response.isSuccessful && response.body()?.results != null) {
                Result.success(response.body()?.results!!)
            } else {
                Result.failure(ApiException("Remote API Failure!"))
            }
        } catch (_: Exception) {
            Result.failure(ApiException("Remote API Failure!"))
        }
    }

    private fun parseArtistIdList(artists: List<Long>) =
        artists.joinToString(",")

}