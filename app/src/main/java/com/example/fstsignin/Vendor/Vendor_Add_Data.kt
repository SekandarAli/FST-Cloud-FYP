package com.example.fstsignin.Vendor

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.fstsignin.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.HashMap

class Vendor_Add_Data : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_add_data)


        val add_data : Button = findViewById(R.id.vendor_add_data)
        val show_data : Button = findViewById(R.id.vendor_show_data)
        val upload_picture : Button = findViewById(R.id.vendor_upload_pic)
        val name : EditText = findViewById(R.id.vendor_food_name)
        val description : EditText = findViewById(R.id.vendor_food_description)

        add_data.setOnClickListener {

            if (name.text.isNullOrEmpty()) {
                name?.error = "Food name is empty."
                name.isFocusable
            }

            else if (description?.text.isNullOrEmpty()) {
                description?.error = "Description is empty."
                description.isFocusable
            }

            else {
                var pd = ProgressDialog(this)
                pd.setTitle("Data adding in progress...")
                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
                pd.setProgress(0)
                pd.setMax(100)

                val db = Firebase.firestore
                //val db = FirebaseFirestore.getInstance()
                val users: MutableMap<String, Any> = HashMap()

                users["Foodname"] = name.text.toString()
                users["Description"] = description.text.toString()

                db.collection("Showdata")
                    .add(users)
                    .addOnSuccessListener {
                        Toast.makeText(
                            this,
                            "Successfully added in DB",
                            Toast.LENGTH_SHORT
                        ).show()

                        pd.dismiss()

                        name.setText("")
                        description.setText("")

                    }.addOnFailureListener {
                        Toast.makeText(
                            this,
                            "FAILED unable to add data to database",
                            Toast.LENGTH_SHORT
                        )
                            .show()

                    }


//            intent = Intent(this, Showdata::class.java)
//            startActivity(intent)

            }
        }

        show_data.setOnClickListener {

            intent = Intent(this,Vendor_Show_Data::class.java)
            startActivity(intent)

        }

        upload_picture.setOnClickListener {


            intent = Intent(this,Vendor_Add_picture::class.java)
            startActivity(intent)
        }
    }
}