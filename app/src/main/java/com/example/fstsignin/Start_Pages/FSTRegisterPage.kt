package com.example.fstsignin.Start_Pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.fstsignin.HOMEPAGE.HOMEPAGE
import com.example.fstsignin.R
import com.example.fstsignin.SIGN_IN.FSTSignIn
import com.example.fstsignin.SIGN_UP.FSTSignUp
import com.example.fstsignin.SIGN_UP.FST_Vendor_Signup

class FSTRegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fstregister_page)

        supportActionBar?.hide()

        val continue_user : Button = findViewById(R.id.continue_user)
        val continue_vendor : Button = findViewById(R.id.continue_vendor)
        val next : Button = findViewById(R.id.next)



        continue_user.setOnClickListener(View.OnClickListener {

            intent = Intent(this, FSTSignUp::class.java)
            startActivity(intent)
        })


        continue_vendor.setOnClickListener(View.OnClickListener {

            intent = Intent(this, FST_Vendor_Signup::class.java)
            startActivity(intent)
        })

        next.setOnClickListener(View.OnClickListener {

            intent = Intent(this, HOMEPAGE::class.java)
            startActivity(intent)
        })
    }
}