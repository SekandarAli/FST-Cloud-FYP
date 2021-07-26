package com.example.fstsignin.Vendor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fstsignin.R
import java.util.*
import kotlin.collections.ArrayList

class Vendor_Main_Page : AppCompatActivity() {

    var items = ArrayList<Vendor_Model>()
    var displayList = ArrayList<Vendor_Model>()

    lateinit var recycleView: RecyclerView

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<Vendor_Adapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_main_page)


            recycleView = findViewById(R.id.recycleView)

            items.add(
                Vendor_Model(
                    "Burger",
                    R.drawable.burger
                )
            )
            items.add(
                Vendor_Model(
                    "Pizza",
                    R.drawable.pizza
                )
            )
            items.add(
                Vendor_Model(
                    "French Fries",
                    R.drawable.fries
                )
            )
            items.add(
                Vendor_Model(
                    "Chicken/Meat Roll",
                    R.drawable.rolls
                )
            )
            items.add(
                Vendor_Model(
                    "Ice-Cream",
                    R.drawable.icecream
                )
            )
            items.add(
                Vendor_Model(
                    "Chicken Shawarma",
                    R.drawable.shawarma
                )
            )
        items.add(
                Vendor_Model(
                    "Add more",
                    R.drawable.addmore
                )
            )



            displayList.addAll(items)


            layoutManager = LinearLayoutManager(this)


            recycleView.layoutManager = GridLayoutManager(this,1)

            adapter = Vendor_Adapter(displayList,this)
            recycleView.adapter = adapter


        }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {

            menuInflater.inflate(R.menu.menu,menu)
            var menuItem = menu!!.findItem(R.id.search_menu)

            if(menuItem != null)
            {
                val searchView = menuItem.actionView as SearchView

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

                    override fun onQueryTextSubmit(query: String?): Boolean {

                        return true

                    }

                    override fun onQueryTextChange(newText: String?): Boolean {

                        if(newText!!.isNotEmpty())
                        {
                            displayList.clear()

                            var search = newText.toLowerCase(Locale.getDefault())
                            items.forEach {

                                if(it.name.toLowerCase(Locale.getDefault()).contains(search))
                                {
                                    displayList.add(it)
                                }
                            }

                            recycleView.adapter!!.notifyDataSetChanged()

                        }

                        else
                        {
                            displayList.clear()
                            displayList.addAll(items)
                            recycleView.adapter!!.notifyDataSetChanged()
                        }
                        return true

                    }

                })
            }

            return super.onCreateOptionsMenu(menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return super.onOptionsItemSelected(item)
        }

    }

