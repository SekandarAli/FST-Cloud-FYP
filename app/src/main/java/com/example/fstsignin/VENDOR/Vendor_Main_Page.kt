package com.example.fstsignin.VENDOR

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.fstsignin.R
import com.example.fstsignin.Vendor_Dish.Vendor_Dish_Add_Data
import com.example.fstsignin.Vendor_Resturant.Vendor_Resturant_Add_Data

class Vendor_Main_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_main_page)

        //val vendor_add_resturant : Button = findViewById(R.id.vendor_add_resturant)
        val vendor_add_dish : Button = findViewById(R.id.vendor_add_dish)
        //val next : ImageView = findViewById(R.id.next)



//        vendor_add_resturant.setOnClickListener(View.OnClickListener {
//
//            intent = Intent(this, Vendor_Resturant_Add_Data::class.java)
//            startActivity(intent)
//        })


        vendor_add_dish.setOnClickListener(View.OnClickListener {

            intent = Intent(this,Vendor_Dish_Add_Data ::class.java)
            startActivity(intent)
        })



    }

    fun addmore(view: View) {

        Toast.makeText(this, "Comming Soon!", Toast.LENGTH_SHORT).show()

    }
}