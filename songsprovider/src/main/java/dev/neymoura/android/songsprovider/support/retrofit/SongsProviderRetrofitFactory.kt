package dev.neymoura.android.songsprovider.support.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val host = "https://us-central1-tw-exercicio-mobile.cloudfunctions.net"

object SongsProviderRetrofitFactory {

    fun build(): Retrofit {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(host)
            .build()
    }
}