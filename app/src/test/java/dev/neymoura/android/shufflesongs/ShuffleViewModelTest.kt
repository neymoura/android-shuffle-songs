package dev.neymoura.android.shufflesongs

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.verify
import dev.neymoura.android.shufflesongs.application.ShuffleApplication
import dev.neymoura.android.shufflesongs.modules.shuffleModule
import dev.neymoura.android.shufflesongs.modules.songsProviderModule
import dev.neymoura.android.shufflesongs.presentation.shuffler.viewModel.ShuffleViewModel
import dev.neymoura.android.songsprovider.commons.Resource
import dev.neymoura.android.songsprovider.model.MusicalData
import dev.neymoura.android.songsprovider.repository.SongsRepository
import dev.neymoura.android.songsprovider.usecase.SongsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class ShuffleViewModelTest : KoinTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var context: Application
    @Mock
    lateinit var repository: SongsRepository
    @Mock
    lateinit var useCase: SongsUseCase
    @Mock
    private lateinit var viewModel: ShuffleViewModel

    @Mock
    lateinit var loadingObserver: Observer<Boolean>
    @Mock
    lateinit var tracksObserver: Observer<List<MusicalData>>

    @Before
    fun beforeKoin() {
        startKoin {
            modules(
                listOf(songsProviderModule, shuffleModule)
            )
        }
    }

    @After
    fun afterKoin() {
        stopKoin()
    }

    @Suppress("UNCHECKED_CAST")
    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        context = mock(ShuffleApplication::class.java)
        loadingObserver = mock(Observer::class.java) as Observer<Boolean>
        tracksObserver = mock(Observer::class.java) as Observer<List<MusicalData>>

        repository = mock(SongsRepository::class.java)
        useCase = spy(SongsUseCase(repository))
        viewModel = ShuffleViewModel(context, useCase)

        with(viewModel) {
            loading.observeForever(loadingObserver)
            tracks.observeForever(tracksObserver)
        }
    }

    @Test
    fun fetchSongs_SUCCESS() = runBlocking {

        // Given
        `when`(repository.fetchSongs(any(), any())).thenReturn(
            Resource.success(
                listOf(
                    MusicalData(
                        id = 1,
                        wrapperType = "artist",
                        artistId = 1,
                        artistName = "Samus Aran",
                        artworkUrl = "https://lgbtqgamearchive.files.wordpress.com/2015/09/metroid_ending_fin.jpg",
                        trackName = "Zebes",
                        primaryGenreName = "Space Hunter Tracks"
                    ),
                    MusicalData(
                        id = 2,
                        wrapperType = "artist",
                        artistId = 2,
                        artistName = "Pelé Arantes",
                        artworkUrl = "https://lgbtqgamearchive.files.wordpress.com/2015/09/metroid_ending_fin.jpg",
                        trackName = "Origem do Aran",
                        primaryGenreName = "Space Hunter Origins"
                    )
                )
            )
        )

        // When
        viewModel.fetchSongs()

        // Then
        verify(loadingObserver, atLeastOnce()).onChanged(true)
        verify(useCase, atLeastOnce()).fetchSongs()
        verify(useCase, atLeastOnce()).shuffleSongs(any())

        Unit

    }

}

