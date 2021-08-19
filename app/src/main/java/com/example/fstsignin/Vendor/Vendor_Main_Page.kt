package com.example.fstsignin.Vendor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fstsignin.R
//import com.example.fstsignin.Vendor_Adapter
import kotlin.collections.ArrayList

class Vendor_Main_Page : AppCompatActivity() {

//    var items = ArrayList<Vendor_Model>()
//    var displayList = ArrayList<Vendor_Model>()

    lateinit var recycleView: RecyclerView

    private var layoutManager: RecyclerView.LayoutManager? = null
   // private var adapter: RecyclerView.Adapter<Vendor_Adapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_main_page)


            recycleView = findViewById(R.id.recycleView)

          //  displayList.addAll(items)


            layoutManager = LinearLayoutManager(this)


            recycleView.layoutManager = GridLayoutManager(this,1)

         //   adapter = Vendor_Adapter(displayList,this)
                //  recycleView.adapter = adapter


        }


    }

