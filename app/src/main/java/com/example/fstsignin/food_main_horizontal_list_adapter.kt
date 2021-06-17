package com.example.fstsignin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class food_main_horizontal_list_adapter (var items : ArrayList<food_main_horizontal_list_model>,context : Context)
    : RecyclerView.Adapter<food_main_horizontal_list_adapter.ViewHolder>(){

    val ccontext = context



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            food_main_horizontal_list_adapter.ViewHolder {


        val v = LayoutInflater.from(parent.context).inflate(R.layout.food_main_horizontal_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = items[position].name
        holder.itemImage.setImageResource(items[position].image)

       // Toast.makeText(context, "sss"+items[position].name, Toast.LENGTH_SHORT).show()

        holder.view.setOnClickListener(View.OnClickListener {

            var intent = Intent(ccontext,FoodDetailsFST::class.java)
            intent.putExtra("name",items[position].name)
            intent.putExtra("image",items[position].image)
            //intent.putExtra("description",descriptionn)


           ccontext.startActivity(intent)

        })
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemName: TextView
        var view = itemView


        init {
            itemImage = itemView.findViewById(R.id.image)
            itemName = itemView.findViewById(R.id.name)


//
//            itemView.setOnClickListener(View.OnClickListener {
//
//
//                var intent = Intent(context,FoodDetailsFST::class.java)
//                ContextCompat.startActivity(context, intent, null)
//            })

        }



    }


}
