package com.example.notesapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notesapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash_screen)

        CoroutineScope(Dispatchers.Default).launch {

            delay(5000)

            startActivity(Intent(this@SplashScreen, MainActivity::class.java))

            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left)

            finish()

        }


    }
}