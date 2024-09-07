package com.example.rertrofit.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rertrofit.model.Product
import com.example.rertrofit.R
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Activity, private val productArrayList: List<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.imageView)
        var title: TextView = itemView.findViewById(R.id.title)
        var description: TextView = itemView.findViewById(R.id.description)
        var price: TextView = itemView.findViewById(R.id.price)
        var rating: TextView = itemView.findViewById(R.id.rating)
        var stock: TextView = itemView.findViewById(R.id.stock)
        var brand: TextView = itemView.findViewById(R.id.brand)
        var category: TextView = itemView.findViewById(R.id.category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(context).inflate(R.layout.main_item_view,parent,false)
        return  MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = productArrayList[position]
        Picasso.get().load(currentItem.thumbnail).into(holder.imageView)
        holder.title.text = currentItem.title
        holder.description.text = "Dec. : " + currentItem.description
        holder.price.text = "Price : "+ currentItem.price.toString()
        holder.rating.text ="Rating : " + currentItem.rating.toString()
        holder.stock.text ="Stock : " + currentItem.stock
        holder.brand.text ="Brand : " + currentItem.brand
        holder.category.text ="Category : " + currentItem.category
    }


}