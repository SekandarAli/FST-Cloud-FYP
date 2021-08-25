package com.example.fstsignin.Vendor_Resturant

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fstsignin.R
import com.example.fstsignin.Vendor_Dish.Vendor_Dish_Add_Data
import com.example.fstsignin.Vendor_Dish.Vendor_Dish_Model
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import java.io.IOException
import java.util.*

class Vendor_Resturant_Add_Data : AppCompatActivity() {


    lateinit var next: Button


    var root_Node: FirebaseDatabase? = null
    var reference: DatabaseReference? = null
    lateinit var vendor_resturant_imageView: ImageView
    lateinit var mAuth: FirebaseAuth
    lateinit var vendor_resturant_name: EditText
    lateinit var vendor_resturant_description: EditText
    lateinit var vendor_resturant_location: EditText
    lateinit var vendor_resturant_chooseImage: Button
    lateinit var vendor_resturant_next: Button

    //Strings and constant

    var location: String = ""
    var PICK_IMAGE_REQUEST = 22

    //Database storage variables

    lateinit var db: FirebaseStorage
    lateinit var Storageref: StorageReference
    lateinit var filepath: Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_resturant_add_data)


        next = findViewById(R.id.add_data_next)
        next.setOnClickListener {

            intent = Intent(this, Vendor_Dish_Add_Data::class.java)
            startActivity(intent)

        }


        val add_data: Button = findViewById(R.id.vendor_resturant_add_data)
        val show_data: Button = findViewById(R.id.vendor_resturant_show_data)
        vendor_resturant_chooseImage = findViewById(R.id.vendor_resturant_choose_image)
        vendor_resturant_name = findViewById(R.id.vendor_resturant_name)
        vendor_resturant_description = findViewById(R.id.vendor_resturant_description)
        vendor_resturant_location = findViewById(R.id.vendor_resturant_location)
        vendor_resturant_imageView = findViewById(R.id.vendor_resturant_image)
        vendor_resturant_next = findViewById(R.id.add_data_next)

        //Firebase Storage Initialization
        db = FirebaseStorage.getInstance()
        Storageref = db.reference


        mAuth = FirebaseAuth.getInstance()

        show_data.setOnClickListener {

            intent = Intent(this, Vendor_Restaurant_Show_Data::class.java)
            startActivity(intent)

        }


        vendor_resturant_chooseImage.setOnClickListener {

            chooseImage()

        }




        vendor_resturant_next.setOnClickListener {

            intent = Intent(this, Vendor_Dish_Add_Data::class.java)
            startActivity(intent)
        }

        add_data.setOnClickListener {

            var pd = ProgressDialog(this)
            pd.setTitle("SignUp in progress...")
            pd.setMessage("Please wait your data is adding")
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            pd.setProgress(0)
            pd.setMax(100)

            Add_Data()

        }
    }


    fun Add_Data() {

        //Real Time data base Initialization code
        root_Node = FirebaseDatabase.getInstance()
        reference = root_Node!!.getReference("Restaurant")

        var resturant_name = vendor_resturant_name.text.toString()
        var resturant_description = vendor_resturant_description.text.toString()
        var resturant_location = vendor_resturant_location.text.toString()


        // Only Image Uploading to cloud storage Code
        val ref: StorageReference = Storageref.child("Restaurant/" + UUID.randomUUID().toString())
        var uploadTask = ref.putFile(filepath)
        val urlTask =
            uploadTask?.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
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

                    var resturant_image = downloadUri.toString()
                    var model = Vendor_Resturant_Model(resturant_name,resturant_image, resturant_description, resturant_location)
                    reference!!.child(resturant_name).setValue(model).addOnCompleteListener {
                        Toast.makeText(this, "Data Uploaded Successfully", Toast.LENGTH_SHORT)
                            .show()


                        vendor_resturant_name.setText("")
                        vendor_resturant_description.setText("")
                        vendor_resturant_location.setText("")

                        vendor_resturant_name.isFocused
                        vendor_resturant_name.isFocusable

                    }.addOnFailureListener {
                        Toast.makeText(
                            this,
                            "Something went wrong, Check Connection",
                            Toast.LENGTH_LONG
                        ).show()
                    }


                } else {
                    // Handle failures
                    Toast.makeText(this, "Something Went wrong, try again", Toast.LENGTH_SHORT)
                        .show()
                }
            }?.addOnFailureListener {

            }


    }


    fun chooseImage() {
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
            && data.getData() != null
        ) {

            // Get the Uri of data
            filepath = data.getData()!!;
            try {

                // Setting image on image view using Bitmap
                var bitmap: Bitmap =
                    MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                vendor_resturant_imageView.setImageBitmap(bitmap);
            } catch (e: IOException) {
                // Log the exception
                e.printStackTrace();
            }


        }
    }
}



