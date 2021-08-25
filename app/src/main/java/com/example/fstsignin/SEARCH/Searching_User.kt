package com.example.fstsignin.SEARCH

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fstsignin.R
import com.example.fstsignin.Vendor_Dish.Vendor_Dish_Adapter
import com.example.fstsignin.Vendor_Dish.Vendor_Dish_Model
import com.google.firebase.database.*

class Searching_User : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var DishRecycleview : RecyclerView
    private lateinit var DishArrayList : ArrayList<Vendor_Dish_Model>
    private lateinit var search_text : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searching_user)

        DishRecycleview = findViewById(R.id.searchData_recycleview)
        DishRecycleview.layoutManager = LinearLayoutManager(this)
        DishRecycleview.setHasFixedSize(true)

        DishArrayList = arrayListOf<Vendor_Dish_Model>()

        var tv_search_text = findViewById<AutoCompleteTextView>(R.id.ed_search_text)


        val suggestions = arrayOf("pizza","food","mutton","burger","salad","biryani")

        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, suggestions)

        tv_search_text.setAdapter(adapter)
        tv_search_text.setThreshold(1)



        var btn_search = findViewById<Button>(R.id.btn_search)
        var btn_clear = findViewById<Button>(R.id.btn_clear).setOnClickListener {


            tv_search_text.text.clear()
        }


//
//        var btn_back = findViewById<Button>(R.id.btn_back).setOnClickListener {
//
//
//            intent = Intent(this,Vendor_Dish_Show_Data::class.java)
//            startActivity(intent)
//        }

        btn_search.setOnClickListener {
            search_text = tv_search_text.text.toString()
            Toast.makeText(this, "text = "+search_text, Toast.LENGTH_SHORT).show()
            getData()

        }

    }

    private fun getData() {



        dbref = FirebaseDatabase.getInstance().getReference()
        var query : Query = dbref.child("Dish").orderByChild("dish_name").equalTo(search_text)

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapShot in snapshot.children)
                    {
                        val dish = userSnapShot.getValue(Vendor_Dish_Model::class.java)

                        DishArrayList.add(dish!!)
                    }
                    DishRecycleview.adapter = Vendor_Dish_Adapter(this@Searching_User,DishArrayList)

                }
                else
                {
                    Toast.makeText(this@Searching_User, "snapshot does not exist", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Searching_User, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })


    }
}