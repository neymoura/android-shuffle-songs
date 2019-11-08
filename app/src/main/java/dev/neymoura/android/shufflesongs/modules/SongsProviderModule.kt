package dev.neymoura.android.shufflesongs.modules

import dev.neymoura.android.songsprovider.repository.SongsRepository
import dev.neymoura.android.songsprovider.repository.remote.SongsRemoteRepository
import dev.neymoura.android.songsprovider.support.retrofit.SongsProviderRetrofitFactory
import dev.neymoura.android.songsprovider.usecase.SongsUseCase
import org.koin.dsl.module

val songsProviderModule = module {
    single { SongsProviderRetrofitFactory.build() }
    single { SongsRemoteRepository(get()) }
    single { SongsRepository(get()) }
    single { SongsUseCase(get()) }
}