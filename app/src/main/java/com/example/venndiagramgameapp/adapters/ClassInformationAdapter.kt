package com.example.venndiagramgameapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.venndiagramgameapp.ClassInformation
import com.example.venndiagramgameapp.R

class ClassInformationAdapter(private val itemList: List<ClassInformation>) :
    RecyclerView.Adapter<ClassInformationAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.itemTextView)
        val textViewDesc: TextView = view.findViewById(R.id.itemTextViewDescription)
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
    }

    override fun getItemCount(): Int = itemList.size
}
