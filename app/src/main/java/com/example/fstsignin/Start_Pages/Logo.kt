package com.example.fstsignin.Start_Pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.fstsignin.R

class Logo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this, FSTRegisterPage::class.java)
            startActivity(intent)
            finish()
        }, 30)




//        val next : Button = findViewById(R.id.next)
//
//        next.setOnClickListener(View.OnClickListener {
//
//
//            //intent = Intent(this,HOMEPAGE::class.java)
//            intent = Intent(this,FSTRegisterPage::class.java)
//            startActivity(intent)
//        })

    }


}