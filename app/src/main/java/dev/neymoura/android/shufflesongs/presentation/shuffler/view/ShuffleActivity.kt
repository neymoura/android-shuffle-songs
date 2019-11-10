package dev.neymoura.android.shufflesongs.presentation.shuffler.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dev.neymoura.android.shufflesongs.R
import dev.neymoura.android.shufflesongs.presentation.shuffler.adapter.TracksAdapter
import dev.neymoura.android.shufflesongs.presentation.shuffler.viewModel.ShuffleViewModel
import dev.neymoura.android.songsprovider.model.MusicalData
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShuffleActivity : AppCompatActivity() {

    private val viewModel: ShuffleViewModel by viewModel()
    private val tracksAdapter = TracksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initViews()
    }

    private fun initViews() {
        tracksList.adapter = tracksAdapter
    }

    private fun initData() {
        with(viewModel) {
            loading.observe(this@ShuffleActivity, Observer(::showLoading))
            tracks.observe(this@ShuffleActivity, Observer(::setTracks))
        }
    }

    private fun showLoading(show: Boolean) {
        // TODO: Loading ui
    }

    private fun setTracks(items: List<MusicalData>) {
        tracksAdapter.items = items
    }
}
