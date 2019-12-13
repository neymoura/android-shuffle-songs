package dev.neymoura.android.shufflesongs.modules

import dev.neymoura.android.songsprovider.repository.ISongRepository
import dev.neymoura.android.songsprovider.repository.SongsRepository
import dev.neymoura.android.songsprovider.repository.remote.FakeSongsProvider
import dev.neymoura.android.songsprovider.repository.remote.SongsRemoteRepository
import dev.neymoura.android.songsprovider.support.retrofit.SongsProviderRetrofitFactory
import dev.neymoura.android.songsprovider.usecase.SongsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val songsProviderModule = module {
    single { SongsProviderRetrofitFactory.build() }
    single(named("songsProvider")) { SongsRemoteRepository(get()) }
    single { SongsRepository(get(named("songsProvider"))) }
    single { SongsUseCase(get()) }
}

val songsProviderTestModule = module {
    single(named("fakeSongsProvider")) { FakeSongsProvider() as ISongRepository }
    single { SongsRepository(get(named("fakeSongsProvider"))) }
    single { SongsUseCase(get()) }
}