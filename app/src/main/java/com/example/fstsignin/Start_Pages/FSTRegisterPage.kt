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

class FSTRegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fstregister_page)

        supportActionBar?.hide()

        val signup : Button = findViewById(R.id.signup)
        val signin : Button = findViewById(R.id.signin)
        val next : ImageView = findViewById(R.id.next)



        signup.setOnClickListener(View.OnClickListener {

            intent = Intent(this, FSTSignUp::class.java)
            startActivity(intent)
        })


        signin.setOnClickListener(View.OnClickListener {

            intent = Intent(this, FSTSignIn::class.java)
            startActivity(intent)
        })

        next.setOnClickListener(View.OnClickListener {

            intent = Intent(this, HOMEPAGE::class.java)
            startActivity(intent)
        })
    }
}