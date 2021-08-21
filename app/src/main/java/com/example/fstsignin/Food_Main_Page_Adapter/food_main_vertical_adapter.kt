package com.example.fstsignin.Food_Main_Page_Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fstsignin.FOOD.FoodDetailsFST
import com.example.fstsignin.R
import com.example.fstsignin.Food_Main_Page_Model.food_main_vertical_model

class food_main_vertical_adapter (var items : ArrayList<food_main_vertical_model>, context
                : Context) : RecyclerView.Adapter<food_main_vertical_adapter.ViewHolder>() {


    val context = context



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val v = LayoutInflater.from(parent.context).inflate(R.layout.food_main_vertical, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = items[position].name
        holder.itemDescription.text = items[position].description
        holder.itemRating.text = items[position].rating
        holder.itemImage.setImageResource(items[position].image)

        holder.view.setOnClickListener(View.OnClickListener {

            var intent = Intent(context, FoodDetailsFST::class.java)
            intent.putExtra("name",items[position].name)
            //intent.putExtra("description",descriptionn)
            intent.putExtra("image",items[position].image)


            context.startActivity(intent)

        })
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemName: TextView
        var itemDescription: TextView
        var itemRating: TextView
        var view = itemView

        init {
            itemImage = itemView.findViewById(R.id.image)
            itemName = itemView.findViewById(R.id.name)
            itemDescription = itemView.findViewById(R.id.description)
            itemRating = itemView.findViewById(R.id.rating)

            itemView.setOnClickListener(View.OnClickListener {
                var intent = Intent(context, FoodDetailsFST::class.java)
                ContextCompat.startActivity(context, intent, null)
            })


        }



    }




}