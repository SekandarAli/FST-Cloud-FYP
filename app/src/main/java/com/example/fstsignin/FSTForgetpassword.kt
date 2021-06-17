package com.example.fstsignin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FSTForgetpassword : AppCompatActivity() {

    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fstforgetpassword)

        supportActionBar?.hide()

        auth = Firebase.auth

        val btn = findViewById<Button>(R.id.button)
        val forgetEditText = findViewById<EditText>(R.id.forgetEditText)

        btn.setOnClickListener(View.OnClickListener {

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            if (forgetEditText.text.toString().isNullOrEmpty())
                Toast.makeText(this,"Email Address is not provided", Toast.LENGTH_LONG).show()
            else {
                auth.sendPasswordResetEmail(
                    forgetEditText.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            Toast.makeText(this, "Reset Password Link is mailed", Toast.LENGTH_LONG).show()
                        } else
                            Toast.makeText(this, "Password Reset mail could not be sent", Toast.LENGTH_LONG).show()
                    }
            }

        })

    }
}