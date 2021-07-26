package com.example.fstsignin.Vendor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.fstsignin.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Vendor_Show_Data : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_show_data)


        val back_show_data: Button = findViewById(R.id.vendor_add_back)
        val show_tv_data: TextView = findViewById(R.id.show_tv_data)

        back_show_data.setOnClickListener {

            intent = Intent(this,Vendor_Add_Data::class.java)
            startActivity(intent)

        }

        val db = Firebase.firestore
        val resultName: StringBuffer = StringBuffer()
        val resultDescription: StringBuffer = StringBuffer()
        db.collection("Showdata")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    for (document in it.result!!) {

                        resultName.append(document.data.getValue("Foodname")).append("\n\n")
                        resultDescription.append(document.data.getValue("Description"))
                            .append("\n\n")
                    }

                    show_tv_data.setText("Food name is : \n\n" + resultName + "\n" + "Description is : \n\n" + resultDescription)


                }
            }
    }
}
