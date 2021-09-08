package com.example.fstsignin.ADMIN

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.fstsignin.HOMEPAGE.HOMEPAGE
import com.example.fstsignin.R
import com.example.fstsignin.SIGN_UP.FSTSignUp
import com.example.fstsignin.SIGN_UP.FST_Vendor_Signup
import com.example.fstsignin.Vendor_Dish.Vendor_Dish_Show_Data
import com.example.fstsignin.Vendor_Resturant.Vendor_Restaurant_Show_Data

class AdminPanel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_panel)


        supportActionBar?.hide()

        val admin_show_dish : Button = findViewById(R.id.admin_show_dish)
        val admin_show_resaurant : Button = findViewById(R.id.admin_show_resaurant)
        val admin_show_home : Button = findViewById(R.id.admin_show_home)



        admin_show_dish.setOnClickListener(View.OnClickListener {

            intent = Intent(this, Vendor_Dish_Show_Data::class.java)
            startActivity(intent)
        })


        admin_show_resaurant.setOnClickListener(View.OnClickListener {

            intent = Intent(this, Vendor_Restaurant_Show_Data::class.java)
            startActivity(intent)
        })


        admin_show_home.setOnClickListener(View.OnClickListener {

            intent = Intent(this, HOMEPAGE::class.java)
            startActivity(intent)
        })


    }
}