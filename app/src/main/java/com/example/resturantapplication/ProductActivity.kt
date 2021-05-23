package com.example.resturantapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resturantapplication.adapter.CategoryAdapter
import com.example.resturantapplication.adapter.CategoryClass
import com.example.resturantapplication.adapter.ProductAdapter
import com.example.resturantapplication.adapter.ProductClass
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.card.MaterialCardView

class ProductActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerviewCategory: RecyclerView
    private var userData: ArrayList<ProductClass> = ArrayList()
    private var categoryData: ArrayList<CategoryClass> = ArrayList()

    private lateinit var contactUs: MaterialCardView
    private lateinit var aboutUs: MaterialCardView

    private lateinit var topAppBar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        supportActionBar?.hide()

        recyclerView = findViewById(R.id.recyclerview)
        recyclerviewCategory = findViewById(R.id.recyclerviewCategory)
        topAppBar = findViewById(R.id.topAppBar)

        contactUs = findViewById(R.id.contactUs)
        aboutUs = findViewById(R.id.aboutUs)

//        list of product data or array
        productDataMethod()

//        list of category data
        categoryDataMethod()

//        contact us method
        contactUsMethod()

//        about us method
        aboutUsMethod()

//        initialization of product adapter
        val productAdapter = ProductAdapter(userData)
        recyclerView.adapter = productAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

//        initialization of category adapter
        val categoryAdapter = CategoryAdapter(categoryData)
        recyclerviewCategory.adapter = categoryAdapter
        recyclerviewCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

//        toolbar
        toolbarLayout()

    }

    //    about us
    private fun aboutUsMethod() {
        aboutUs.setOnClickListener {
            val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.dialog_about, null)
            dialog.setView(view)
            dialog.create()
            dialog.show()
        }
    }

    //    contactUs
    private fun contactUsMethod() {
        contactUs.setOnClickListener {
            val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.dialog_contact, null)
            dialog.setView(view)
            dialog.create()
            dialog.show()
        }
    }

    //    toolbar
    private fun toolbarLayout() {
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.cart -> {
                    startActivity(Intent(applicationContext, CartActivity::class.java))
                    true
                }

                else -> false
            }
        }
    }

    private fun productDataMethod() {
        userData.add(ProductClass("Cake", "Rs. 50", R.drawable.cake))
        userData.add(ProductClass("Pizza", "Rs. 550", R.drawable.pizza))
        userData.add(ProductClass("Sausage", "Rs. 15", R.drawable.sausage))
        userData.add(ProductClass("HamBurger", "Rs. 150", R.drawable.hamburger))
        userData.add(ProductClass("Cupcake", "Rs. 70", R.drawable.cupcake))
        userData.add(ProductClass("French Fries", "Rs. 250", R.drawable.french_fries))
        userData.add(ProductClass("Salami", "Rs. 150", R.drawable.salami))
        userData.add(ProductClass("Soup", "Rs. 90", R.drawable.soup))
        userData.add(ProductClass("Cake", "Rs. 50", R.drawable.cake))
        userData.add(ProductClass("Pizza", "Rs. 550", R.drawable.pizza))
    }

    private fun categoryDataMethod() {
        categoryData.add(CategoryClass("Cold Drinks", R.drawable.cold_drinks))
        categoryData.add(CategoryClass("Hot Drinks", R.drawable.wine))
        categoryData.add(CategoryClass("Spicy Food", R.drawable.pizza))
        categoryData.add(CategoryClass("Cold Drinks", R.drawable.cold_drinks))
        categoryData.add(CategoryClass("Hot Drinks", R.drawable.wine))
        categoryData.add(CategoryClass("Spicy Food", R.drawable.pizza))
    }
}