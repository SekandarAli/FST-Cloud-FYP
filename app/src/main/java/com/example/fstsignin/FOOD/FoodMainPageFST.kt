package com.example.fstsignin.FOOD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.HOMEPAGE.HOMEPAGE
import com.example.MAPS.Map_location
import com.example.fstsignin.*
import com.example.fstsignin.Main_Adapter.food_main_horizontal_card_adapter
import com.example.fstsignin.Main_Adapter.food_main_horizontal_list_adapter
import com.example.fstsignin.Main_Adapter.food_main_vertical_adapter
import com.example.fstsignin.Main_Model.food_main_horizontal_card_model
import com.example.fstsignin.Main_Model.food_main_horizontal_list_model
import com.example.fstsignin.Main_Model.food_main_vertical_model
import java.util.*
import kotlin.collections.ArrayList

class FoodMainPageFST : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<food_main_horizontal_list_adapter.ViewHolder>? = null
    private var vlayoutManager: RecyclerView.LayoutManager? = null
    private var vadapter: RecyclerView.Adapter<food_main_vertical_adapter.ViewHolder>? = null
    private var hadapter: RecyclerView.Adapter<food_main_horizontal_card_adapter.ViewHolder>? = null



    var items = ArrayList<food_main_horizontal_list_model>()
    var hitems = ArrayList<food_main_horizontal_card_model>()
    var vitems = ArrayList<food_main_vertical_model>()
    var displayList = ArrayList<food_main_horizontal_list_model>()
    var hdisplayList = ArrayList<food_main_horizontal_card_model>()
    var vdisplayList = ArrayList<food_main_vertical_model>()

    lateinit var  recycleView: RecyclerView
    lateinit var recycleViewcard: RecyclerView
    lateinit var vrecycleView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_main_page_fst)

        supportActionBar?.hide()

        recycleView = findViewById(R.id.foodhorizontallist)
        recycleViewcard= findViewById(R.id.foodhorizontalcard)
        vrecycleView = findViewById(R.id.verticalfood)


        val back : ImageView = findViewById(R.id.back)
        val location : ImageView = findViewById(R.id.location)

        back.setOnClickListener{
            intent = Intent(this, HOMEPAGE::class.java)
            startActivity(intent)
        }


        location.setOnClickListener{
            intent = Intent(this, Map_location::class.java)
            startActivity(intent)
        }



        items.add(
            food_main_horizontal_list_model(
                "Lobia Fry",
                R.drawable.f10
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Chinese Rice",
                R.drawable.f9
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Daal Mash",
                R.drawable.f8
            )
        )

        items.add(
            food_main_horizontal_list_model(
                "Tikka Karahi",
                R.drawable.f7
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Mutton",
                R.drawable.f6
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Chicken",
                R.drawable.r5
            )
        )


        items.add(
            food_main_horizontal_list_model(
                "Saif Bakers",
                R.drawable.f10
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Food Plannet",
                R.drawable.f9
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "De'Mininster cafe",
                R.drawable.f8
            )
        )

        items.add(
            food_main_horizontal_list_model(
                "Saif Bakers",
                R.drawable.f7
            )
        )

//        displayList.addAll(items)



        recycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter = food_main_horizontal_list_adapter(items, this)

        recycleView.adapter = adapter



        hitems.add(
            food_main_horizontal_card_model(
                "Fry Rice",
                R.drawable.f10
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "Malai Boti",
                R.drawable.f9
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "Mutton Karahi",
                R.drawable.f8
            )
        )

        hitems.add(
            food_main_horizontal_card_model(
                "Channy",
                R.drawable.f7
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "Food Plannet",
                R.drawable.f6
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "De'Mininster cafe",
                R.drawable.r5
            )
        )

        // layoutManager = LinearLayoutManager(this)

//        hdisplayList.addAll(hitems)

        recycleViewcard.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        hadapter = food_main_horizontal_card_adapter(hitems, this)

        recycleViewcard.adapter = hadapter




        vitems.add(
            food_main_vertical_model(
                "Haleem", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.r6
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Biryani", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.r7
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Pulao", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.r8
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Kabab", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.f10
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Raita", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.f6
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Mir Bakers", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.r9
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Usmania Resturant", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.f7
            )
        )

        vitems.add(
            food_main_vertical_model(
                "De'Mininster cafe", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.f8
            )
        )


        vdisplayList.addAll(vitems)
        vrecycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        vadapter = food_main_vertical_adapter(vdisplayList, this)
        vrecycleView.adapter = vadapter

        val DividerItemDecoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        vrecycleView.addItemDecoration(DividerItemDecoration)


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu,menu)
        var menuItem = menu!!.findItem(R.id.search)

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
                        vdisplayList.clear()

                        var search = newText.toLowerCase(Locale.getDefault())
                        vitems.forEach {

                            if(it.name.toLowerCase(Locale.getDefault()).contains(search))
                            {
                                vdisplayList.add(it)
                            }
                        }

                        vrecycleView.adapter!!.notifyDataSetChanged()

                    }

                    else
                    {
                        vdisplayList.clear()
                        vdisplayList.addAll(vitems)
                        vrecycleView.adapter!!.notifyDataSetChanged()
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
