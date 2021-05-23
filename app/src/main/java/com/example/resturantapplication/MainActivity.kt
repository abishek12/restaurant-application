package com.example.resturantapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.resturantapplication.authActivity.LoginActivity
import com.example.resturantapplication.authActivity.RegisterActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnLogin: MaterialButton
    private lateinit var btnRegister: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

//        get id from xml
        viewFindViewById()

//        onclick button login
        btnOnClickLogin()

//        onclick button register
        btnOnClickRegister()
    }

    //    get id from xml
    private fun viewFindViewById() {
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)
    }

    //    onclick button login
    private fun btnOnClickLogin() {
        btnLogin.setOnClickListener {
            startActivity(Intent(applicationContext, LoginActivity::class.java))
        }
    }

    //    onclick button register
    private fun btnOnClickRegister() {
        btnRegister.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }
    }
}