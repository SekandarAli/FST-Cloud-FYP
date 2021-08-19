//package com.example.fstsignin
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class Vendor_Adapter(var items : ArrayList<Vendor_Model>, context : Context) : RecyclerView.Adapter<Vendor_Adapter.ViewHolder>() {
//
//
//        val context = context
//
//
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//
//
//            val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_vendor_card, parent, false)
//            return ViewHolder(v)
//        }
//
//        override fun getItemCount(): Int {
//            return items.size
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//        }
//
//
//        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//            var itemImage: ImageView
//            var itemName: TextView
//
//            init {
//                itemImage = itemView.findViewById(R.id.image)
//                itemName = itemView.findViewById(R.id.name)
//
//
//            }
//
//        }
//    }
//
//
//
