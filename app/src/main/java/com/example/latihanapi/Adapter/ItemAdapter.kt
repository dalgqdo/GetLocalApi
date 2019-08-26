package com.example.latihanapi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanapi.R
import com.example.latihanapi.model.Item

class ItemAdapter(val context: Context, val items: ArrayList<Item>) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_view, null)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items.get(position)
        holder.idItem.text = item.id.toString()
        holder.itemName.text = item.name
        holder.itemSize.text = item.size
        holder.itemColor.text = item.color
    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idItem: TextView
        val itemName: TextView
        val itemSize: TextView
        val itemColor: TextView

        init {
            idItem = view.findViewById(R.id.idItem)
            itemName = view.findViewById(R.id.itemName)
            itemSize = view.findViewById(R.id.itemSize)
            itemColor = view.findViewById(R.id.itemColor)
        }
    }
}
