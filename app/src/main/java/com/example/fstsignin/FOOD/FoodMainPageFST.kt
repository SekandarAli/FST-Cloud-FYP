package com.example.fstsignin.FOOD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fstsignin.HOMEPAGE.HOMEPAGE
import com.example.fstsignin.*
import com.example.fstsignin.Dish_Main_Page.Dish_Main_page_Adapter
import com.example.fstsignin.MAPS.Map_User
import com.example.fstsignin.MAPS.Map_Vendor
import com.example.fstsignin.Main_Page_Adapter.Main_horizontal_card_adapter
import com.example.fstsignin.Main_Page_Adapter.Main_horizontal_list_adapter
import com.example.fstsignin.Main_Page_Model.Main_horizontal_card_model
import com.example.fstsignin.Main_Page_Model.Main_horizontal_list_model
import com.example.fstsignin.Main_Page_Model.Main_vertical_model
import com.example.fstsignin.R
import com.example.fstsignin.SEARCH.Searching_User
import com.example.fstsignin.Vendor_Dish.Vendor_Dish_Model
import com.google.firebase.database.*
import es.dmoral.toasty.Toasty
import java.util.*
import kotlin.collections.ArrayList

class FoodMainPageFST : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<Main_horizontal_list_adapter.ViewHolder>? = null
    private var vlayoutManager: RecyclerView.LayoutManager? = null
    //private var vadapter: RecyclerView.Adapter<food_main_vertical_adapter.MyViewHolder>? = null
    private var hadapter: RecyclerView.Adapter<Main_horizontal_card_adapter.ViewHolder>? = null


    //database variables


    private lateinit var dbref : DatabaseReference
    private lateinit var DishRecycleview : RecyclerView
    private lateinit var DishArrayList : ArrayList<Vendor_Dish_Model>
    private lateinit var vendor_dish_search : ImageView



    var items = ArrayList<Main_horizontal_list_model>()
    var hitems = ArrayList<Main_horizontal_card_model>()
    var vitems = ArrayList<Main_vertical_model>()
    var displayList = ArrayList<Main_horizontal_list_model>()
    var hdisplayList = ArrayList<Main_horizontal_card_model>()
    var vdisplayList = ArrayList<Main_vertical_model>()

    lateinit var  recycleView: RecyclerView
    lateinit var recycleViewcard: RecyclerView
    lateinit var vrecycleView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_main_page_fst)

        supportActionBar?.hide()



        DishArrayList = arrayListOf<Vendor_Dish_Model>()
        recycleView = findViewById(R.id.foodhorizontallist)
        recycleViewcard= findViewById(R.id.foodhorizontalcard)
        vrecycleView = findViewById(R.id.verticalfood)


        val back : ImageView = findViewById(R.id.back)
        val location : ImageView = findViewById(R.id.location)
        val food_search : ImageView = findViewById(R.id.food_search)

        back.setOnClickListener{
            intent = Intent(this, HOMEPAGE::class.java)
            startActivity(intent)
        }


        location.setOnClickListener{
            intent = Intent(this, Map_User::class.java)
            startActivity(intent)
        }

        food_search.setOnClickListener{
            intent = Intent(this, Searching_User::class.java)
            startActivity(intent)
        }



        items.add(
            Main_horizontal_list_model(
                "Lobia Fry",
                R.drawable.f10
            )
        )
        items.add(
            Main_horizontal_list_model(
                "Chinese Rice",
                R.drawable.f9
            )
        )
        items.add(
            Main_horizontal_list_model(
                "Daal Mash",
                R.drawable.f8
            )
        )

        items.add(
            Main_horizontal_list_model(
                "Tikka Karahi",
                R.drawable.f7
            )
        )
        items.add(
            Main_horizontal_list_model(
                "Mutton",
                R.drawable.f6
            )
        )
        items.add(
            Main_horizontal_list_model(
                "Chicken",
                R.drawable.r5
            )
        )


        items.add(
            Main_horizontal_list_model(
                "Saif Bakers",
                R.drawable.f10
            )
        )
        items.add(
            Main_horizontal_list_model(
                "Food Plannet",
                R.drawable.f9
            )
        )
        items.add(
            Main_horizontal_list_model(
                "De'Mininster cafe",
                R.drawable.f8
            )
        )

        items.add(
            Main_horizontal_list_model(
                "Saif Bakers",
                R.drawable.f7
            )
        )

//        displayList.addAll(items)



        recycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
            false)

        adapter = Main_horizontal_list_adapter(items, this)

        recycleView.adapter = adapter



        hitems.add(
            Main_horizontal_card_model(
                "Fry Rice",
                R.drawable.f10
            )
        )
        hitems.add(
            Main_horizontal_card_model(
                "Malai Boti",
                R.drawable.f9
            )
        )
        hitems.add(
            Main_horizontal_card_model(
                "Mutton Karahi",
                R.drawable.f8
            )
        )

        hitems.add(
            Main_horizontal_card_model(
                "Channy",
                R.drawable.f7
            )
        )
        hitems.add(
            Main_horizontal_card_model(
                "Food Plannet",
                R.drawable.f6
            )
        )
        hitems.add(
            Main_horizontal_card_model(
                "De'Mininster cafe",
                R.drawable.r5
            )
        )

        // layoutManager = LinearLayoutManager(this)

//        hdisplayList.addAll(hitems)

        recycleViewcard.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        hadapter = Main_horizontal_card_adapter(hitems, this)

        recycleViewcard.adapter = hadapter






        vrecycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)



        val DividerItemDecoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        vrecycleView.addItemDecoration(DividerItemDecoration)
        getUserData()


    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        menuInflater.inflate(R.menu.menu,menu)
//        var menuItem = menu!!.findItem(R.id.search)
//
//        if(menuItem != null)
//        {
//            val searchView = menuItem.actionView as SearchView
//
//            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//
//                override fun onQueryTextSubmit(query: String?): Boolean {
//
//                    return true
//
//                }
//
//                override fun onQueryTextChange(newText: String?): Boolean {
//
//                    if(newText!!.isNotEmpty())
//                    {
//                        vdisplayList.clear()
//
//                        var search = newText.toLowerCase(Locale.getDefault())
//                        vitems.forEach {
//
//                            if(it.name.toLowerCase(Locale.getDefault()).contains(search))
//                            {
//                                vdisplayList.add(it)
//                            }
//                        }
//
//                        vrecycleView.adapter!!.notifyDataSetChanged()
//
//                    }
//
//                    else
//                    {
//                        vdisplayList.clear()
//                        vdisplayList.addAll(vitems)
//                        vrecycleView.adapter!!.notifyDataSetChanged()
//                    }
//                    return true
//
//                }
//
//            })
//        }
//
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return super.onOptionsItemSelected(item)
//    }


    fun getUserData(){

        var dish_name : String? = ""
        dbref = FirebaseDatabase.getInstance().getReference()
        var query : Query = dbref.child("Dish/")

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapShot in snapshot.children)
                    {
                        val dish = userSnapShot.getValue(Vendor_Dish_Model::class.java)
                        dish_name = userSnapShot.child("dish_name").value.toString()
                        DishArrayList.add(dish!!)
                    }
                    vrecycleView.adapter =Dish_Main_page_Adapter(this@FoodMainPageFST,DishArrayList)

                }
                else
                {
                    Toasty.error(this@FoodMainPageFST, "Snapshot does not exist", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toasty.info(this@FoodMainPageFST, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })


    }

}
