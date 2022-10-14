package com.example.practive.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practive.MainActivity
import com.example.practive.R
import com.example.practive.Todo
import com.example.practive.TodoViewModel
import com.example.practive.adapter.TodoAdapter
import com.example.practive.databinding.FragmentPendingBinding
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PendingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PendingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewModel: TodoViewModel
    private lateinit var binding: FragmentPendingBinding
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // 1. ViewModel 설정
        viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory()).get(TodoViewModel::class.java)

        // 2. ViewBinding 설정
        binding = FragmentPendingBinding.inflate(inflater, container, false)

        // 3. Adapter 연결 ( list를 인자로 )
        val pendingList = viewModel.pendingList.value
        adapter = TodoAdapter(pendingList?: emptyList<Todo>(), onClickDeleteButton = {viewModel.deleteTask(it)}
        , onCheckedChange = {it: Todo, check: Boolean -> viewModel.updateToggle(it, check)})
        adapter.setHasStableIds(true)
        binding!!.rvPending.adapter = adapter

        // 4. recyclerView에 Layout 꼭 설정하기 ( 안그러면 화면에 표시 안되고 skip됨 )
        binding!!.rvPending.layoutManager = LinearLayoutManager(activity)

        // 5. return Fragment Layout View
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.todoList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            binding.rvPending.post(Runnable { adapter.setPendingData(it.filter { x -> !x.isDone}) })
        })
    }

    override fun onStart() {
        super.onStart()
        binding.btnAddTask.setOnClickListener {
            val transaction = (activity as MainActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, AddFragment())
            transaction.commit()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PendingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PendingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}