package com.example.fstsignin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodMainPageFST : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<food_main_horizontal_list_adapter.ViewHolder>? = null
    private var vlayoutManager: RecyclerView.LayoutManager? = null
    private var vadapter: RecyclerView.Adapter<food_main_vertical_adapter.ViewHolder>? = null
    private var hadapter: RecyclerView.Adapter<food_main_horizontal_card_adapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_main_page_fst)

        supportActionBar?.hide()

        val back : ImageView = findViewById(R.id.back)
        val location : ImageView = findViewById(R.id.location)

        back.setOnClickListener{
            intent = Intent(this,HOMEPAGE::class.java)
            startActivity(intent)
        }


        location.setOnClickListener{
            intent = Intent(this,Map_location::class.java)
            startActivity(intent)
        }

        val items = ArrayList<food_main_horizontal_list_model>()


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

        // layoutManager = LinearLayoutManager(this)

        val recycleView: RecyclerView = findViewById(R.id.foodhorizontallist)
        recycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter = food_main_horizontal_list_adapter(items, this)

        recycleView.adapter = adapter



        val hitems = ArrayList<food_main_horizontal_card_model>()


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

        val recycleViewcard: RecyclerView = findViewById(R.id.foodhorizontalcard)
        recycleViewcard.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        hadapter = food_main_horizontal_card_adapter(hitems, this)

        recycleViewcard.adapter = hadapter

        val vitems = ArrayList<food_main_vertical_model>()

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


        val vrecycleView: RecyclerView = findViewById(R.id.verticalfood)
        vrecycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        vadapter = food_main_vertical_adapter(vitems, this)
        vrecycleView.adapter = vadapter

        val DividerItemDecoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        vrecycleView.addItemDecoration(DividerItemDecoration)


    }


}