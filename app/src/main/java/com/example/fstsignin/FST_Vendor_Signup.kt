package com.example.fstsignin

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FST_Vendor_Signup : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fst_vendor_signup)


        auth = Firebase.auth

        supportActionBar?.hide()

        val vendor_signup : Button = findViewById(R.id.vendor_Signup)
        val vendor_Location : Button = findViewById(R.id.vendor_Location)
        val vendor_Email : EditText = findViewById(R.id.vendor_Email)
        val vendor_Restaurant : EditText = findViewById(R.id.vendorRestaurant)
        val vendorUsername : EditText = findViewById(R.id.vendorUsername)
        val vendor_Phoneno : EditText = findViewById(R.id.vendor_Phoneno)
        val vendor_Password : EditText = findViewById(R.id.vendor_Password)
        val vendor_Repassword : EditText = findViewById(R.id.vendor_Repassword)
        val s2 : Switch = findViewById(R.id.switch2)

        s2.isChecked

        s2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

                s2.text = "Vendor"
                intent = Intent(this, FSTSignUp::class.java)
                startActivity(intent)


            }

            //s.solidColor(from("#FFFFF"))
        }

        vendor_Location.setOnClickListener {

            intent = Intent(this,Map_location::class.java)
            startActivity(intent)
        }




        vendor_Password.setOnClickListener {
            vendor_Password.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }


        vendor_Repassword.setOnClickListener {
            vendor_Repassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }





        vendor_signup.setOnClickListener {

            var pd = ProgressDialog(this)
            pd.setTitle("SignUp in progress...")
            pd.setMessage("Please wait your data is fetching")
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            pd.setProgress(0)
            pd.setMax(100)


//            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)


            if (vendor_Email.text.isNullOrEmpty()) {
                vendor_Email?.error = "Email cannot be empty."
                vendor_Email.isFocusable
            }
                if (vendor_Restaurant.text.isNullOrEmpty()) {
                vendor_Restaurant?.error = "Email cannot be empty."
                vendor_Restaurant.isFocusable

            } else if (vendor_Password?.text.isNullOrEmpty()) {
                vendor_Password?.error = "Password cannot be empty."
                vendor_Password.isFocusable

            } else if (vendor_Password?.text.length < 2) {
                vendor_Password?.error = "Password must contain more than 3 words."
                vendor_Password.isFocusable

            } else if (vendorUsername?.text.isNullOrEmpty()) {
                vendorUsername?.error = "Username Cannot be empty"
                vendorUsername.isFocusable

            } else if (vendor_Repassword?.text.isNullOrEmpty()) {
                vendor_Repassword?.error = "Confirm Password cannot be empty."
                vendor_Repassword.isFocusable

            } else if (vendor_Password.text.toString() != vendor_Repassword.text.toString()) {
                vendor_Repassword?.error = "Password doesnot match."
                vendor_Password.isFocusable

            } else if (vendor_Email.text.isEmpty() && vendor_Password.text.isEmpty() &&
                vendor_Repassword.text.isEmpty() && vendorUsername.text.isEmpty() &&
                vendor_Phoneno.text.isEmpty()&& vendor_Restaurant.text.isEmpty()

            ) {
                vendorUsername?.error = "Empty"
                vendor_Restaurant?.error = "Empty"
                vendor_Email?.error = "Empty"
                vendor_Password?.error = "Empty"
                vendor_Repassword?.error = "Empty"
                vendorUsername.isFocusable

            }
                else

                {
                pd.show()

                auth.createUserWithEmailAndPassword(
                    vendor_Email.text.toString(),
                    vendor_Password.text.toString()
                )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {

// Below three lines added for sending the authentication link to the user's email
                            auth.currentUser?.sendEmailVerification()
                                ?.addOnCompleteListener { task ->
                                    if (task.isSuccessful) {


                                        val user = auth.currentUser

// below message changed and user is navigated to Sign In activity
//                                        textViewResponse.text =
//                                            "Sign Up successful. Verification link sent to the Email address"


                                        //Firestore Databse


                                        val db = Firebase.firestore
                                        //val db = FirebaseFirestore.getInstance()
                                        val vendor_users: MutableMap<String, Any> = HashMap()

                                        vendor_users["UserName"] = vendorUsername.text.toString()
                                        vendor_users["RestaurantName"] = vendor_Restaurant.text.toString()
                                        vendor_users["Email"] = vendor_Email.text.toString()
                                        vendor_users["PhoneNo"] = vendor_Phoneno.text.toString()
                                        vendor_users["Password"] = vendor_Password.text.toString()
                                        vendor_users["ConfirmPassword"] = vendor_Repassword.text.toString()

                                        db.collection("Vendor")
                                            .add(vendor_users)
                                            .addOnSuccessListener {
                                                Toast.makeText(
                                                    this,
                                                    "Successfully added in DB",
                                                    Toast.LENGTH_SHORT
                                                ).show()

                                                pd.dismiss()

                                            }.addOnFailureListener {
                                                Toast.makeText(this, "FAILED unable to add data to database", Toast.LENGTH_SHORT)
                                                    .show()

                                            }


                                        intent = Intent(this, FST_Vendor_Signin::class.java)
                                        startActivity(intent)
                                    }
                                }
                        }
                    }.addOnFailureListener {
                        Toast.makeText(
                            this,
                            "Sign Up failed, something went wrong OR Account may already exist",
                            Toast.LENGTH_SHORT
                        ).show()

                        pd.dismiss()

                    }

            }

        }
    }
}

