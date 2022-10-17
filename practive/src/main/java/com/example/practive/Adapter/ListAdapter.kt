package com.example.practive.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practive.FriendList
import com.example.practive.databinding.FriendListBinding

class ListAdapter(private var list: ArrayList<FriendList>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(val binding: FriendListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(friendList: FriendList){
            //binding.friendImage.setImageResource(friendList.friendImage)
            binding.friendName.text = friendList.nickName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = FriendListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}