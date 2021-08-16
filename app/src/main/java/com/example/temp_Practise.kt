package com.example

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fstsignin.R
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.IOException
import java.util.*


class temp_Practise : AppCompatActivity() {
  lateinit  var db : FirebaseStorage
  lateinit var Storageref : StorageReference
  lateinit var filepath : Uri
  lateinit var image : ImageView
  var  PICK_IMAGE_REQUEST = 22
    lateinit var upload : Button
    lateinit var choose : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_practise)

         db = FirebaseStorage.getInstance()
         Storageref = db.getReference()
         upload = findViewById<Button>(R.id.btn_upload_practise)
         choose = findViewById<Button>(R.id.btn_choose_practise)
         image = findViewById<ImageView>(R.id.imageview_practise)

        //ON Click listeners

        upload.setOnClickListener {uploadImage()}
        choose.setOnClickListener {selectImage()}




    }

    private fun selectImage() {
        // Defining Implicit Intent to mobile gallery
        // Defining Implicit Intent to mobile gallery
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(
                intent,
                "Select Image from here..."
            ),
            PICK_IMAGE_REQUEST
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST
            && resultCode == RESULT_OK
            && data != null
            && data.getData() != null) {

            // Get the Uri of data
            filepath = data.getData()!!;
            try {

                // Setting image on image view using Bitmap
                var bitmap : Bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                image.setImageBitmap(bitmap);
    } catch ( e : IOException) {
                // Log the exception
                e.printStackTrace();
            }


}}
    private fun uploadImage() {

        if(filepath != null) {
            val ref: StorageReference = Storageref.child("images/" + UUID.randomUUID().toString())
            ref.putFile(filepath).addOnSuccessListener {
                Toast.makeText(this, "Image Uploaded", Toast.LENGTH_SHORT).show() }.addOnFailureListener {
                Toast.makeText(
                    this,
                    "Image Upload Failed",
                    Toast.LENGTH_SHORT
                ).show()}
        }
}

}