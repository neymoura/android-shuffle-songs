package dev.neymoura.android.shufflesongs

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.verify
import dev.neymoura.android.shufflesongs.application.ShuffleApplication
import dev.neymoura.android.shufflesongs.modules.coroutineTestModule
import dev.neymoura.android.shufflesongs.modules.shuffleModule
import dev.neymoura.android.shufflesongs.modules.songsProviderTestModule
import dev.neymoura.android.shufflesongs.presentation.shuffler.viewModel.ShuffleViewModel
import dev.neymoura.android.songsprovider.model.MusicalData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class ShuffleViewModelTest : AutoCloseKoinTest() {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val viewModel: ShuffleViewModel by inject()

    @Mock
    lateinit var loadingObserver: Observer<Boolean>
    @Mock
    lateinit var tracksObserver: Observer<List<MusicalData>>

    @Before
    fun beforeKoin() {
        startKoin {
            androidContext(ShuffleApplication())
            modules(listOf(coroutineTestModule, songsProviderTestModule, shuffleModule))
        }
    }

    @Suppress("UNCHECKED_CAST")
    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        loadingObserver = mock(Observer::class.java) as Observer<Boolean>
        tracksObserver = mock(Observer::class.java) as Observer<List<MusicalData>>

        with(viewModel) {
            loading.observeForever(loadingObserver)
            tracks.observeForever(tracksObserver)
        }
    }

    @Test
    fun fetchSongs_SUCCESS() = runBlocking {

        // When
        viewModel.fetchSongs()

        // Then
        verify(loadingObserver, atLeastOnce()).onChanged(true)
        verify(tracksObserver, atLeastOnce()).onChanged(any())

        Unit

    }

}

