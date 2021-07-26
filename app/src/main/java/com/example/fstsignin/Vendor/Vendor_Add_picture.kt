package com.example.fstsignin.Vendor

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.fstsignin.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.text.SimpleDateFormat
import java.util.*

class Vendor_Add_picture : AppCompatActivity() {


    //lateinit var binding: ActivityStorageFirebaseBinding

    lateinit var imageUrl: Uri
    lateinit var imageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_upload_picture)


        val choose_image : Button = findViewById(R.id.chooseImage)
        val upload_image : Button = findViewById(R.id.uploadimage)
        val show_image : Button = findViewById(R.id.showimages)
        val back_upload: Button = findViewById(R.id.back_upload)
        imageView = findViewById(R.id.imageViewUpload)


        choose_image.setOnClickListener(View.OnClickListener {

            var intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(intent, 111)

        })


        upload_image.setOnClickListener(View.OnClickListener {

            var pd = ProgressDialog(this)
            pd.setTitle("Uploading")
            pd.setMessage("Please wait your file is uploading")
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            pd.show()

            var formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_SS", Locale.getDefault())
            var now = Date()

            var filename = formatter.format(now)

            val storageReference = FirebaseStorage.getInstance().getReference("images/$filename")

            storageReference.putFile(imageUrl).addOnSuccessListener {

                imageView.setImageURI(null)

                if (pd.isShowing) pd.dismiss()
                Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {

                if (pd.isShowing) pd.dismiss()

                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }

        })

        back_upload.setOnClickListener {


            intent = Intent(this,Vendor_Add_Data::class.java)
            startActivity(intent)

        }

        show_image.setOnClickListener {


            intent = Intent(this,Vendor_Show_Image::class.java)
            startActivity(intent)

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 111 && resultCode == Activity.RESULT_OK
            && data != null
        ) {


            imageUrl = data.data!!
            imageView.setImageURI(imageUrl)


        }


    }
}


