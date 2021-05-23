package com.example.resturantapplication.authActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.example.resturantapplication.ProductActivity
import com.example.resturantapplication.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var edtLoginUsername: TextInputEditText
    private lateinit var edtLoginPassword: TextInputEditText
    private lateinit var btnUserLogin: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

//        find view from xml
        viewFindViewById()

//        when login button is clicked
        userLogin()
    }

    //    find view from xml
    private fun viewFindViewById() {
        edtLoginUsername = findViewById(R.id.edtLoginUsername)
        edtLoginPassword = findViewById(R.id.edtLoginPassword)
        btnUserLogin = findViewById(R.id.btnLoginUser)
    }

    //    when login button is clicked
    private fun userLogin() {
        btnUserLogin.setOnClickListener {
            val name: String = edtLoginUsername.text.toString()
            val password: String = edtLoginPassword.text.toString()

            if (name == "abishek" && password == "abishek") {
                startActivity(Intent(applicationContext, ProductActivity::class.java))
                finish()
            } else {
                Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_LONG).show()
            }
        }
    }
}