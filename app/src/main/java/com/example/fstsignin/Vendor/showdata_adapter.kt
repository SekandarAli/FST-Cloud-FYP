package com.example.fstsignin.Vendor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fstsignin.R
import com.squareup.picasso.Picasso

class showdata_adapter (var context : Context, var dish_list : ArrayList<Vendor_Model>) : RecyclerView.Adapter<showdata_adapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.vendor_showdata_itemlist,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = dish_list[position]
        holder.dish_name.text = currentItem.dish_name
        holder.dish_price.text = currentItem.dish_price
        holder.dish_description.text = currentItem.dish_description

        if(currentItem.dish_image == null){}
        else
        {Picasso.get().load(currentItem.dish_image).into(holder.dish_image)}


    }

    override fun getItemCount(): Int {
        return dish_list.size
    }
    class MyViewHolder ( itemView : View) : RecyclerView.ViewHolder(itemView){

        var dish_name = itemView.findViewById<TextView>(R.id.vendor_showdata_name)
        var dish_price = itemView.findViewById<TextView>(R.id.vendor_showdata_price)
        var dish_description = itemView.findViewById<TextView>(R.id.vendor_showdata_description)
        var dish_image = itemView.findViewById<ImageView>(R.id.vendor_showdata_image)


    }

}
