package com.example.resturantapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resturantapplication.R

class CategoryAdapter(val categoryList: ArrayList<CategoryClass>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val categoryTitle: TextView = itemView.findViewById(R.id.categoryTitle)
        val categoryImage: ImageView = itemView.findViewById(R.id.categoryImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPosition = categoryList[position]

        holder.categoryTitle.text = currentPosition.title
        holder.categoryImage.setImageResource(currentPosition.image)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}