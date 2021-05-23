package com.example.resturantapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resturantapplication.R

class ProductAdapter(val userList: ArrayList<ProductClass>) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgProductImage: ImageView = itemView.findViewById(R.id.imgProductImage)
        var txtItem: TextView = itemView.findViewById(R.id.txtItem)
        var txtPrice: TextView = itemView.findViewById(R.id.txtPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPosition = userList[position]

        holder.txtItem.text = currentPosition.productTitle
        holder.txtPrice.text = currentPosition.productPrice
        holder.imgProductImage.setImageResource(currentPosition.productImage)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}