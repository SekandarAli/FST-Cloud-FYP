package com.example.fstsignin.SIGN_UP

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.method.HideReturnsTransformationMethod
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fstsignin.HOMEPAGE.HOMEPAGE
import com.example.fstsignin.MAPS.Map_User
import com.example.fstsignin.MAPS.Map_Vendor
import com.example.fstsignin.PROFILE.Profile_Model
import com.example.fstsignin.R
import com.example.fstsignin.SIGN_IN.FST_Vendor_Signin
import com.example.fstsignin.Vendor_Resturant.Vendor_Resturant_Add_Data
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import es.dmoral.toasty.Toasty
import java.io.IOException
import java.util.*

class FST_Vendor_Signup : AppCompatActivity() {


    lateinit var vendor_signup_imageView: ImageView
    lateinit var vendor_Email: EditText
    lateinit var vendor_resturant_name: EditText
    lateinit var vendorUsername: EditText

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fst_vendor_signup)

        supportActionBar?.hide()

        auth = Firebase.auth

        val vendor_signup: Button = findViewById(R.id.vendor_Signup)
        //val vendor_location: Button = findViewById(R.id.vendor_Location)
        val vendor_restaurant_add_data: Button = findViewById(R.id.vendor_choose_image)
        vendor_Email = findViewById(R.id.vendor_Email)
        //vendor_resturant_name = findViewById(R.id.vendor_resturant_name)
        vendorUsername = findViewById(R.id.vendorUsername)
        val vendor_Phoneno: EditText = findViewById(R.id.vendor_Phoneno)
        val vendor_Password: EditText = findViewById(R.id.vendor_Password)

        val vendor_Repassword: EditText = findViewById(R.id.vendor_Repassword)
        vendor_signup_imageView = findViewById(R.id.vendor_signup_imageView)

        val vendor_signin: TextView = findViewById(R.id.vendor_signin)



        vendor_signin.setOnClickListener(View.OnClickListener {

            intent = Intent(this, FST_Vendor_Signin::class.java)
            startActivity(intent)
        })

//
//        vendor_location.setOnClickListener(View.OnClickListener {
//
//            intent = Intent(this, Map_Vendor::class.java)
//            startActivity(intent)
//        })


        vendor_restaurant_add_data.setOnClickListener(View.OnClickListener {

            intent = Intent(this, Vendor_Resturant_Add_Data::class.java)
            startActivity(intent)

        })


        val s2: Switch = findViewById(R.id.switch2)

        s2.isChecked

        s2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

                s2.text = "Vendor"
                intent = Intent(this, FSTSignUp::class.java)
                startActivity(intent)


            }

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



            if (vendor_Email.text.isNullOrEmpty()) {
                vendor_Email?.error = "Email cannot be empty."
                vendor_Email.isFocusable
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

            } else if (vendor_resturant_name.text.isNullOrBlank()) {
                vendor_resturant_name?.error = "Resturant name cannot be empty."
                vendor_resturant_name.isFocusable

            } else if (vendor_Email.text.isEmpty() && vendor_Password.text.isEmpty() &&
                vendor_Repassword.text.isEmpty() && vendorUsername.text.isEmpty() &&
                vendor_Phoneno.text.isEmpty()

            ) {
                vendorUsername?.error = "Empty"
                vendor_Email?.error = "Empty"
                vendor_Password?.error = "Empty"
                vendor_Repassword?.error = "Empty"
                vendor_resturant_name?.error = "Empty"
                vendorUsername.isFocusable

            } else {
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
                                        vendor_users["Email"] = vendor_Email.text.toString()
                                        vendor_users["PhoneNo"] = vendor_Phoneno.text.toString()
                                        vendor_users["Password"] = vendor_Password.text.toString()
                                        vendor_users["ConfirmPassword"] =
                                            vendor_Repassword.text.toString()

                                        db.collection("Vendor")
                                            .add(vendor_users)
                                            .addOnSuccessListener {
                                                Toasty.success(
                                                    this,
                                                    "Successfully added in DB",
                                                    Toast.LENGTH_SHORT
                                                ).show()

                                                pd.dismiss()

                                            }.addOnFailureListener {
                                                Toasty.error(
                                                    this,
                                                    "FAILED unable to add data to database",
                                                    Toast.LENGTH_SHORT
                                                )
                                                    .show()

                                            }


                                        intent = Intent(this, FST_Vendor_Signin::class.java)
                                        startActivity(intent)
                                    }
                                }
                        }
                    }.addOnFailureListener {
                        Toasty.warning(
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

