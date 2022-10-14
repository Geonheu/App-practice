//package com.example.copycat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.copycat.ChatUserData
import com.example.copycat.databinding.ChatListBinding
import kotlinx.android.synthetic.main.chat_list.view.*


class ChatAdapter(private var datas : ArrayList<ChatUserData>): RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(val binding: ChatListBinding) : RecyclerView.ViewHolder(binding.root)
    {
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
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int = datas.size


}