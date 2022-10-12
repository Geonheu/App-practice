package com.example.copycat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.copycat.databinding.ChatListBinding
import kotlinx.android.synthetic.main.chat_list.view.*

class ChatAdapter(private var datas : ArrayList<ChatUserData>): RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(private val binding: ChatListBinding) : RecyclerView.ViewHolder(binding.root) {
//
//        val name = binding.userName
//        val content = binding.content
//        val date = binding.date
//
//

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
//        holder.name.text = currentItem.user_name
//        holder.content.text = currentItem.content
//        holder.date.text = currentItem.date
    }

    override fun getItemCount(): Int = datas.size


}