package com.example.fstsignin.Vendor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fstsignin.R
import com.squareup.picasso.Picasso


class Adapter  (var item : List<Item>, context : Context) : RecyclerView.Adapter<Adapter.ViewHolder>()

{

    val context = context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).
            inflate(R.layout.activity_vendor_show_image_card, parent, false))
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder : ViewHolder, position: Int) {

        var item : Item = item[position]
        Picasso.get().load(item.imageUrl).into(holder.itemImage)



    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemImage: ImageView = itemView.findViewById(R.id.image)

    }



}

