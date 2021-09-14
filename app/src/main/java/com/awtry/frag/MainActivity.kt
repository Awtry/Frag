package com.awtry.frag

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private val KEY = "STATE_KEY"
    private var Go_Menu: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Go_Menu = savedInstanceState?.getBoolean(KEY, true) ?: true
        if (Go_Menu)
            supportFragmentManager.beginTransaction().add(R.id.Padre, Frag_Menu())
                .commit()
    }



    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putBoolean(KEY, false)
        }

        super.onSaveInstanceState(outState)
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            replace(R.id.Padre, fragment)
            addToBackStack(fragment.tag)
            commit()
        }
    }

    fun Sonidito(sound: Int) = MediaPlayer.create(this, sound).start()
}