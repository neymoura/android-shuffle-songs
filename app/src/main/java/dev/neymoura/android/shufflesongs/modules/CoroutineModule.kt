package dev.neymoura.android.shufflesongs.modules

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val coroutineModule = module {
    single { CoroutineScope(Dispatchers.IO) }
}

val coroutineTestModule = module {
    single { CoroutineScope(Dispatchers.Unconfined) }
}