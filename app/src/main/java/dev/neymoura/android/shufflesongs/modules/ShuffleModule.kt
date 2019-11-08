package dev.neymoura.android.shufflesongs.modules

import dev.neymoura.android.shufflesongs.viewModel.ShuffleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val shuffleModule = module {
    viewModel { ShuffleViewModel(get(), get()) }
}

