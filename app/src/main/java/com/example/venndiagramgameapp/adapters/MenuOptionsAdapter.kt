package com.example.venndiagramgameapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.venndiagramgameapp.R
import com.example.venndiagramgameapp.entities.MenuOption


class MenuOptionsAdapter(private val itemList: List<MenuOption>, private val onCardClickListener: OnCardClickListener) :
    RecyclerView.Adapter<MenuOptionsAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imageView)
        val textView: TextView = view.findViewById(R.id.titleTextView)
        val textViewDesc: TextView = view.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.textView.text = item.title
        holder.textViewDesc.text = item.description

        Glide.with(holder.itemView.context)
            .load(item.imgLink)
            .into(holder.img)

        holder.itemView.setOnClickListener {
            onCardClickListener.onCardClick(itemList[position])
        }
    }

    override fun getItemCount(): Int = itemList.size

    interface OnCardClickListener {
        fun onCardClick(item: MenuOption)
    }

}