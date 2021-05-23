package com.example.resturantapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class PaymentActivity : AppCompatActivity() {

    private var quantity: String? = null
    private var price: String? = null

    private lateinit var paymentName: EditText
    private lateinit var paymentQuality: TextView
    private lateinit var paymentPrice: TextView
    private lateinit var paymentButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        supportActionBar?.hide()

        paymentQuality = findViewById(R.id.paymentQuality)
        paymentPrice = findViewById(R.id.paymentPrice)
        paymentName = findViewById(R.id.paymentName)
        paymentButton = findViewById(R.id.paymentButton)

        quantity = intent.getStringExtra("quantity").toString()
        price = intent.getStringExtra("price").toString()


        paymentName.setText("Abishek Khanal")
        paymentQuality.text = quantity
        paymentPrice.text = price

        paymentButton.setOnClickListener {
            val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
            dialog.setMessage("Payment Completed")
            dialog.create()
            dialog.show()
        }


    }
}