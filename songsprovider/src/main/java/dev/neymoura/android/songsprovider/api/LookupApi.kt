package dev.neymoura.android.songsprovider.api

import dev.neymoura.android.songsprovider.model.MusicalData
import dev.neymoura.android.songsprovider.support.model.ResultWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val PATH = "/lookup"

interface LookupApi {

    @GET(PATH)
    suspend fun lookup(
        @Query("id", encoded = true) id: String,
        @Query("limit") pageNumber: Int
    ): Response<ResultWrapper<MusicalData>>

}