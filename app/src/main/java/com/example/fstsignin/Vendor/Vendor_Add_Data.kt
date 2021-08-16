package com.example.fstsignin.Vendor

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import com.example.fstsignin.R
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import java.io.IOException
import java.util.*

class Vendor_Add_Data : AppCompatActivity() {
    var root_Node  : FirebaseDatabase? = null
    var reference : DatabaseReference? = null
    lateinit var imageView : ImageView
    lateinit var mAuth : FirebaseAuth
    lateinit var Restaurant_name : EditText
    lateinit var Restaurant_contact : EditText
    lateinit  var btn_chooseImage : Button

//Strings and constant
    var image : String = ""
    var  location : String = ""
    var  PICK_IMAGE_REQUEST = 22

    //Database storage variables

    lateinit  var db : FirebaseStorage
    lateinit var Storageref : StorageReference
    lateinit var filepath : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_add_data)


        val add_data : Button = findViewById(R.id.btn_vendor_add_data)
        val show_data : Button = findViewById(R.id.vendor_show_data)
         btn_chooseImage = findViewById(R.id.btn_vendor_addData_chooseimaeg)
       Restaurant_name = findViewById(R.id.ed_vendorAddData_Restaurant_name)
       Restaurant_contact = findViewById(R.id.ed_vendorAddData_restaurant_contact)
        imageView = findViewById(R.id.img_vendorAddData_imageview)

        //Firebase Storage Initialization
        db = FirebaseStorage.getInstance()
        Storageref = db.reference


mAuth = FirebaseAuth.getInstance()
btn_chooseImage.setOnClickListener {chooseImage()}

        show_data.setOnClickListener {}

        add_data.setOnClickListener { Add_Data() }
    }



    fun Add_Data() {

        //Real Time data base Initialization code
        root_Node = FirebaseDatabase.getInstance()
        reference = root_Node!!.getReference("Restaurant")

        var name = Restaurant_name.text.toString()
        var contact = Restaurant_contact.text.toString()
        Restaurant_name.setText("")
        Restaurant_contact.setText("")
        imageView


        // Only Image Uploading to cloud storage Code
        val ref: StorageReference = Storageref.child("Restaurant/" + UUID.randomUUID().toString())
        var uploadTask =  ref.putFile(filepath)
        val urlTask = uploadTask?.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
            if (!task.isSuccessful) {

                task.exception?.let {
                    throw it
                }
            }
            return@Continuation ref.downloadUrl
        })?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Image Uploaded Successfully", Toast.LENGTH_SHORT).show()
                val downloadUri = task.result

                var image = downloadUri.toString()
                var model  = Vendor_Model(name, image, location, contact)
                reference!!.child(name).setValue(model).addOnCompleteListener {
                    Toast.makeText(this, "Data Uploaded Successfully", Toast.LENGTH_SHORT).show()}.addOnFailureListener{ Toast.makeText(this, "Something went wrong, Check Connection", Toast.LENGTH_LONG).show()}




            } else {
                // Handle failures
                Toast.makeText(this, "Something Went wrong, try again", Toast.LENGTH_SHORT).show()
            }
        }?.addOnFailureListener{

        }








    }



    fun chooseImage(){
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
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
                imageView.setImageBitmap(bitmap);
            } catch ( e : IOException) {
                // Log the exception
                e.printStackTrace();
            }


        }}

    private fun uploadImage() {

        val ref: StorageReference = Storageref.child("Restaurant/" + UUID.randomUUID().toString())
        var uploadTask =  ref.putFile(filepath)
        val urlTask = uploadTask?.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
            if (!task.isSuccessful) {

                task.exception?.let {
                    throw it
                }
            }
            return@Continuation ref.downloadUrl
        })?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Image Uploaded Successfully", Toast.LENGTH_SHORT).show()
                val downloadUri = task.result





            } else {
                // Handle failures
                Toast.makeText(this, "Something Went wrong, try again", Toast.LENGTH_SHORT).show()
            }
        }?.addOnFailureListener{

        }

    }
    private fun addUploadRecordToDb(uri: String) : String{
        var image  = uri
        return image
    }



}
