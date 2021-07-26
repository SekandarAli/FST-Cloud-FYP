package com.example.fstsignin.Vendor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fstsignin.R
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageReference

class Vendor_Show_Image : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_show_image)


        val storage = FirebaseStorage.getInstance()

        val vendor_add_back : Button = findViewById(R.id.vendor_add_back)

        vendor_add_back.setOnClickListener {

            intent = Intent(this,Vendor_Add_picture::class.java)
            startActivity(intent)

        }
        val storageRef = storage.reference.child("images")
        val imageList: ArrayList<Item> = ArrayList()

        val recycleView: RecyclerView = findViewById(R.id.recycleView)

        val listAllTask: Task<ListResult> = storageRef.listAll()
        listAllTask.addOnCompleteListener { result ->
            var items: List<StorageReference> = result.result!!.items

            items.forEachIndexed { index, item ->


                item.downloadUrl.addOnSuccessListener {

                    imageList.add(Item(it.toString()))
                }.addOnCompleteListener {


                    recycleView.adapter = Adapter(imageList, this)
                    recycleView.layoutManager =
                        LinearLayoutManager(this)

                }

            }
        }
    }
}
