package com.example.fstsignin

import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class FoodDetailsFST : AppCompatActivity() {
    lateinit var ratingBar: RatingBar
    val con = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details_fst)

        supportActionBar?.hide()


        val back : ImageView = findViewById(R.id.back)

        back.setOnClickListener{
            intent = Intent(this,FoodMainPageFST::class.java)
            startActivity(intent)
        }


        val detailimage : ImageView = findViewById(R.id.detailimage)
        val detailname : TextView = findViewById(R.id.detailname)

        //val description : TextView = findViewById(R.id.descdescription)

        val name=intent.getStringExtra("name")
        //val description=intent.getStringExtra("description")
        val image = intent.getIntExtra("image",1)

        detailname.text = name
        //descdescription.text = description
        detailimage.setImageResource(image)

    }
}
