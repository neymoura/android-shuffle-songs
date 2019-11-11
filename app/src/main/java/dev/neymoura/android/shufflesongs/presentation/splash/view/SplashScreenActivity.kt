package dev.neymoura.android.shufflesongs.presentation.splash.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import dev.neymoura.android.shufflesongs.R
import dev.neymoura.android.shufflesongs.presentation.shuffler.view.ShuffleActivity

private const val SPLASH_SCREEN_DELAY = 2000L

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        delayToShuffler()
    }

    private fun delayToShuffler() {
        Handler().postDelayed(::goToShuffler, SPLASH_SCREEN_DELAY)
    }

    private fun goToShuffler() {
        val intent = Intent(this, ShuffleActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        }
        startActivity(intent)
        finish()
    }

}