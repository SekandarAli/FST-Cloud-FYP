package com.example.fstsignin.Start_Pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.fstsignin.R
import com.example.fstsignin.SIGN_IN.FSTSignIn

class FSTForgetpage2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fstforgetpage2)


        supportActionBar?.hide()

        var btn = findViewById<Button>(R.id.button)


        btn.setOnClickListener(View.OnClickListener {

            var intent = Intent(this, FSTSignIn::class.java)
            startActivity(intent)

        })
    }
}