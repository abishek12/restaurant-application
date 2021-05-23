package com.example.resturantapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

//        hide app bar
        supportActionBar?.hide()

//        splash screen will displayed only for 2.5 sec after that MainActivity
        Handler()
            .postDelayed({
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }, 2500)
    }
}