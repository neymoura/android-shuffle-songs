package dev.neymoura.android.shufflesongs.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.neymoura.android.shufflesongs.R
import dev.neymoura.android.shufflesongs.viewModel.ShuffleViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShuffleActivity : AppCompatActivity() {

    private val viewModel: ShuffleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {
        helloThing.setOnClickListener {
            viewModel.fetchSongs()
        }
    }
}
