package com.example.fstsignin.Vendor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fstsignin.R
import com.google.firebase.database.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Vendor_Show_Data : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var DishRecycleview : RecyclerView
    private lateinit var DishArrayList : ArrayList<Vendor_Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_show_data)

DishRecycleview = findViewById(R.id.showdata_recycleview)
        DishRecycleview.layoutManager = LinearLayoutManager(this)
        DishRecycleview.setHasFixedSize(true)

        DishArrayList = arrayListOf<Vendor_Model>()




        getData()


        }

    private fun getData() {
        var dish_name : String? = ""
        dbref = FirebaseDatabase.getInstance().getReference()
        var query : Query = dbref.child("Dish/")

        query.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapShot in snapshot.children)
                    {
                       val dish = userSnapShot.getValue(Vendor_Model::class.java)
              dish_name = userSnapShot.child("dish_name").value.toString()
                        DishArrayList.add(dish!!)
                    }
                    DishRecycleview.adapter =showdata_adapter(this@Vendor_Show_Data,DishArrayList)

                                     }
                else
                {
                    Toast.makeText(this@Vendor_Show_Data, "snapshot does not exist", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Vendor_Show_Data, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })


    }



    }


