package com.example.fstsignin.TRAVEL

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.HOMEPAGE.HOMEPAGE
import com.example.MAPS.Map_location
import com.example.fstsignin.*
import com.example.fstsignin.Food_Main_Page_Adapter.food_main_horizontal_card_adapter
import com.example.fstsignin.Food_Main_Page_Adapter.food_main_horizontal_list_adapter
import com.example.fstsignin.Food_Main_Page_Adapter.food_main_vertical_adapter
import com.example.fstsignin.Food_Main_Page_Model.food_main_horizontal_card_model
import com.example.fstsignin.Food_Main_Page_Model.food_main_horizontal_list_model
import com.example.fstsignin.Food_Main_Page_Model.food_main_vertical_model

class TravelMainPageFST : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<food_main_horizontal_list_adapter.ViewHolder>? = null
    private var vlayoutManager: RecyclerView.LayoutManager? = null
    private var vadapter: RecyclerView.Adapter<food_main_vertical_adapter.ViewHolder>? = null
    private var hadapter: RecyclerView.Adapter<food_main_horizontal_card_adapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_main_page_fst)

        supportActionBar?.hide()

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

        val items = ArrayList<food_main_horizontal_list_model>()


        items.add(
            food_main_horizontal_list_model(
                "Murree",
                R.drawable.t1
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "nathiagali",
                R.drawable.t2
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Ayubia",
                R.drawable.t3
            )
        )

        items.add(
            food_main_horizontal_list_model(
                "Shimla Hills",
                R.drawable.t4
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Ilyasi",
                R.drawable.t5
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Nathia",
                R.drawable.t6
            )
        )


        items.add(
            food_main_horizontal_list_model(
                "Karla",
                R.drawable.t7
            )
        )
        items.add(
            food_main_horizontal_list_model(
                "Waterfall",
                R.drawable.t8
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
                "Murree",
                R.drawable.t9
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "Ayubia",
                R.drawable.t8
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "Harnoi",
                R.drawable.t7
            )
        )

        hitems.add(
            food_main_horizontal_card_model(
                "Waterfall",
                R.drawable.t6
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "Shimla",
                R.drawable.t5
            )
        )
        hitems.add(
            food_main_horizontal_card_model(
                "Mountains",
                R.drawable.t4
            )
        )


         layoutManager = LinearLayoutManager(this)

        val recycleViewcard: RecyclerView = findViewById(R.id.foodhorizontalcard)
        recycleViewcard.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        hadapter = food_main_horizontal_card_adapter(hitems, this)

        recycleViewcard.adapter = hadapter

        val vitems = ArrayList<food_main_vertical_model>()

        vitems.add(
            food_main_vertical_model(
                "Nathiagali", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.t6
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Waterfall", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.t8
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Hills", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.t4
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Place", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.t2
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Karla", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.t7
            )
        )

        vitems.add(
            food_main_vertical_model(
                "Murree", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.t9
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