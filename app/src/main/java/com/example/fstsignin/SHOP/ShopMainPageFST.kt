package com.example.fstsignin.SHOP

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fstsignin.HOMEPAGE.HOMEPAGE
import com.example.fstsignin.MAPS.Map_location
import com.example.fstsignin.*
import com.example.fstsignin.Food_Main_Page_Adapter.food_main_horizontal_card_adapter
import com.example.fstsignin.Food_Main_Page_Adapter.food_main_horizontal_list_adapter
import com.example.fstsignin.Food_Main_Page_Adapter.food_main_vertical_adapter
import com.example.fstsignin.Food_Main_Page_Model.food_main_horizontal_card_model
import com.example.fstsignin.Food_Main_Page_Model.food_main_horizontal_list_model
import com.example.fstsignin.Food_Main_Page_Model.food_main_vertical_model
import com.example.fstsignin.SEARCH.Searching

class ShopMainPageFST : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<food_main_horizontal_list_adapter.ViewHolder>? = null
    private var vlayoutManager: RecyclerView.LayoutManager? = null
    private var vadapter: RecyclerView.Adapter<food_main_vertical_adapter.ViewHolder>? = null
    private var hadapter: RecyclerView.Adapter<food_main_horizontal_card_adapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_main_page_fst)

        supportActionBar?.hide()

        val back : ImageView = findViewById(R.id.back)
        val location : ImageView = findViewById(R.id.location)
        val shop_search : ImageView = findViewById(R.id.shop_search)

        back.setOnClickListener{
            intent = Intent(this, HOMEPAGE::class.java)
            startActivity(intent)
        }


        location.setOnClickListener{
            intent = Intent(this, Map_location::class.java)
            startActivity(intent)
        }

        shop_search.setOnClickListener{
            intent = Intent(this, Searching::class.java)
            startActivity(intent)
        }

        val items = ArrayList<food_main_horizontal_list_model>()


        items.add(
            food_main_horizontal_list_model(
                "Khadi",
                R.drawable.s1
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Nishta lilan",
                R.drawable.s2
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Kids Store",
                R.drawable.s3
            )
        )

        items.add(
            food_main_horizontal_list_model(
                "Outfitter",
                R.drawable.s4
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Harbour",
                R.drawable.s5
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Stone Harbour",
                R.drawable.s6
            )
        )


        items.add(
            food_main_horizontal_list_model(
                "Khadi",
                R.drawable.s7
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Bata Shop",
                R.drawable.s8
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Service",
                R.drawable.s9
            )
        )

        items.add(
            food_main_horizontal_list_model(
                "Outfitters",
                R.drawable.s10
            )
        )

        // layoutManager = LinearLayoutManager(this)

        val recycleView: RecyclerView = findViewById(R.id.foodhorizontallist)
        recycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter = food_main_horizontal_list_adapter(items, this)

        recycleView.adapter = adapter



        val hitems = ArrayList<food_main_horizontal_card_model>()


        hitems.add(
            food_main_horizontal_card_model(
                "Khadi",
                R.drawable.s1
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "Outfitters",
                R.drawable.s4
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "Nishat",
                R.drawable.s5
            )
        )

        hitems.add(
            food_main_horizontal_card_model(
                "Kids Shop",
                R.drawable.s6
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "Cougar",
                R.drawable.s7
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "Khadai",
                R.drawable.s8
            )
        )


        // layoutManager = LinearLayoutManager(this)

        val recycleViewcard: RecyclerView = findViewById(R.id.foodhorizontalcard)
        recycleViewcard.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        hadapter = food_main_horizontal_card_adapter(hitems, this)

        recycleViewcard.adapter = hadapter

        val vitems = ArrayList<food_main_vertical_model>()

        vitems.add(
            food_main_vertical_model(
                "Khadi", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.s7
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Outfitters", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.s8
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Nishat Lilan", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.s3
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Service", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.s5
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Bata", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.s7
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Kids Store", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.s9
            )
        )



        val vrecycleView: RecyclerView = findViewById(R.id.verticalfood)
        vrecycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        vadapter = food_main_vertical_adapter(vitems, this)
        vrecycleView.adapter = vadapter

        val DividerItemDecoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        vrecycleView.addItemDecoration(DividerItemDecoration)


    }


}