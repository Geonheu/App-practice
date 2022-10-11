package com.example.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.databinding.ItemRecyclerBinding

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var datalist = mutableListOf<ItemData>()

    inner class MyViewHolder(private val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(itemData: ItemData){
            binding.name.text = itemData.name
            binding.content.text = itemData.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    override fun getItemCount(): Int = datalist.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}