package com.example.copycat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.copycat.databinding.ChatListBinding
import com.example.copycat.databinding.FragmentChattingBinding
import com.example.copycat.fragment.ChattingFragment

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    var list = mutableListOf<ChatUserData>()

    inner class ChatViewHolder(private val binding: ChatListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(chatUserData: ChatUserData){
            binding.userName.text = chatUserData.user_name
            binding.content.text = chatUserData.content
            binding.date.text = chatUserData.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ChatListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}