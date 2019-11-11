package dev.neymoura.android.shufflesongs.application

import android.app.Application
import dev.neymoura.android.shufflesongs.modules.shuffleModule
import dev.neymoura.android.shufflesongs.modules.songsProviderModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class ShuffleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ShuffleApplication)
            modules(
                listOf(songsProviderModule, shuffleModule)
            )
        }

    }

}