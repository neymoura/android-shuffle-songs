package dev.neymoura.android.shufflesongs.presentation.shuffler.view

import android.os.Bundle
import android.view.View
import android.view.View.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dev.neymoura.android.shufflesongs.R
import dev.neymoura.android.shufflesongs.presentation.shuffler.adapter.TracksAdapter
import dev.neymoura.android.shufflesongs.presentation.shuffler.viewModel.ShuffleViewModel
import dev.neymoura.android.songsprovider.model.MusicalData
import kotlinx.android.synthetic.main.activity_shuffle.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShuffleActivity : AppCompatActivity() {

    private val viewModel: ShuffleViewModel by viewModel()
    private val tracksAdapter = TracksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shuffle)
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

    private fun showLoading(showLoading: Boolean) {
        loadingView.visibility = if (showLoading) VISIBLE else GONE
        tracksList.visibility = if (showLoading) GONE else VISIBLE
    }

    private fun setTracks(items: List<MusicalData>) {
        tracksAdapter.items = items
    }
}
