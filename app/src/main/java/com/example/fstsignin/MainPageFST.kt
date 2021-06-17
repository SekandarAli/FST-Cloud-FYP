package com.example.fstsignin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainPageFST (context: Context): Fragment() {

    var food_context = context
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<horizontal_recycle_main_adapter.ViewHolder>? = null
    private var vlayoutManager: RecyclerView.LayoutManager? = null
    private var vadapter: RecyclerView.Adapter<vertical_recycle_main_adapter.ViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    var v : View = LayoutInflater.from(food_context).inflate(R.layout.activity_main_page_fst,
        container,false)

    val items = ArrayList<horizontal_recycle_main_model>()


        items.add(
            horizontal_recycle_main_model(
                "Saif Bakers",
                R.drawable.f10
            )
        )
        items.add(
            horizontal_recycle_main_model(
                "Food Plannet",
                R.drawable.f9
            )
        )
        items.add(
            horizontal_recycle_main_model(
                "De'Mininster cafe",
                R.drawable.f8
            )
        )

        items.add(
            horizontal_recycle_main_model(
                "Saif Bakers",
                R.drawable.f7
            )
        )
        items.add(
            horizontal_recycle_main_model(
                "Food Plannet",
                R.drawable.f6
            )
        )
        items.add(
            horizontal_recycle_main_model(
                "De'Mininster cafe",
                R.drawable.r5
            )
        )


        // layoutManager = LinearLayoutManager(this)

        val recycleView: RecyclerView = v.findViewById(R.id.horizontalrecycleView)
        recycleView.layoutManager = LinearLayoutManager(food_context, LinearLayoutManager.HORIZONTAL, false)

        adapter = horizontal_recycle_main_adapter(items, food_context)
        recycleView.adapter = adapter



        val vitems = ArrayList<vertical_recycle_main_model>()

        vitems.add(
            vertical_recycle_main_model(
                "De'Mininster cafe", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.r6
            )
        )

        vitems.add(
            vertical_recycle_main_model(
                "Coffity", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.r7
            )
        )

        vitems.add(
            vertical_recycle_main_model(
                "Mir Bakers", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.r8
            )
        )

        vitems.add(
            vertical_recycle_main_model(
                "Usmania Resturant", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.f10
            )
        )

        vitems.add(
            vertical_recycle_main_model(
                "De'Mininster cafe", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.f6
            )
        )

        vitems.add(
            vertical_recycle_main_model(
                "Mir Bakers", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.r9
            )
        )

        vitems.add(
            vertical_recycle_main_model(
                "Usmania Resturant", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.f7
            )
        )

        vitems.add(
            vertical_recycle_main_model(
                "De'Mininster cafe", "North Food special plate", "3 min | 4.2 stars",
                R.drawable.f8
            )
        )


        val vrecycleView: RecyclerView = v.findViewById(R.id.verticalrecycleView)
        vrecycleView.layoutManager = LinearLayoutManager(food_context, LinearLayoutManager.VERTICAL, false)

        vadapter = vertical_recycle_main_adapter(vitems, food_context)
        vrecycleView.adapter = vadapter

        val DividerItemDecoration = DividerItemDecoration(food_context, DividerItemDecoration.VERTICAL)
        vrecycleView.addItemDecoration(DividerItemDecoration)


    return v
    }

}


