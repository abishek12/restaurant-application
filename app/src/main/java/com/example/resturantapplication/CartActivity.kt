package com.example.resturantapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class CartActivity : AppCompatActivity() {

    private lateinit var txtQuantity: TextView
    private lateinit var pp: TextView
    private lateinit var incQuantity: ImageButton
    private lateinit var decQuantity: ImageButton

    private lateinit var buttonPay: Button

    private var quantity: Int = 1
    private var price: Int = 50

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        supportActionBar?.hide()

        txtQuantity = findViewById(R.id.txtQuantity)
        pp = findViewById(R.id.pp)
        incQuantity = findViewById(R.id.incQuantity)
        decQuantity = findViewById(R.id.decQuantity)
        buttonPay = findViewById(R.id.buttonPay)

//        on click pay method
        payOnMethod()

        increaseQuantity()
        decreaseQuantity()

    }

    //    on click pay method
    private fun payOnMethod() {
        buttonPay.setOnClickListener {
            val intent = Intent(applicationContext, PaymentActivity::class.java)
            intent.putExtra("quantity", txtQuantity.text.toString())
            intent.putExtra("price", pp.text.toString())

            startActivity(intent)
        }
    }

    private fun increaseQuantity() {
        incQuantity.setOnClickListener {
            quantity += 1
            price = 50 * quantity
            txtQuantity.text = quantity.toString()
            pp.text = "Rs. ${price}"
            return@setOnClickListener
        }
    }

    private fun decreaseQuantity() {
        if (quantity == 0) {
            decQuantity.isEnabled = false
        }
        decQuantity.setOnClickListener {
            quantity -= 1
            price = 50 * quantity
            txtQuantity.text = quantity.toString()
            pp.text = "Rs. ${price}"
            return@setOnClickListener
        }
    }
}