package com.example.practive.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practive.Todo
import com.example.practive.databinding.ItemTodoBinding

class TodoPendingAdapter(var Todos: List<Todo>): RecyclerView.Adapter<TodoPendingAdapter.TodoViewHolder>() {

    private lateinit var itemBinding: ItemTodoBinding

    // ViewHolder를 생성해 Todo.kt에 있는 data들을 view를 사용해 화면에 보여주는 역할을 한다.
    inner class TodoViewHolder(private var itemBinding: ItemTodoBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: Todo){
            itemBinding.tvTitle.text = data.title
            itemBinding.tvContent.text = data.content
            itemBinding.cbIsDone.isChecked = data.isDone
        }
    }

    // viewHolder에 layout inflate 하는 함수 ( viewBinding 사용 )
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodoPendingAdapter.TodoViewHolder {
        itemBinding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(itemBinding)
    }

    // viewHolder에 각 view를 bind 하는 함수
    // TodoViewHolder에 bind를 정의했으므로, 각 Todos[position]인 item data랑 view를 bind하면 됨.
    override fun onBindViewHolder(holder: TodoPendingAdapter.TodoViewHolder, position: Int) {
        holder.bind(Todos[position])
    }

    // RecyclerView내의 item 개수 return 하는 함수
    override fun getItemCount(): Int = Todos.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}