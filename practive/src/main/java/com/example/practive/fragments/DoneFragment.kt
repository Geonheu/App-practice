package com.example.practive.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practive.R
import com.example.practive.Todo
import com.example.practive.adapter.TodoDoneAdapter
import com.example.practive.adapter.TodoPendingAdapter
import com.example.practive.databinding.FragmentDoneBinding
import com.example.practive.databinding.FragmentPendingBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DoneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DoneFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentDoneBinding
    private lateinit var adapter: TodoDoneAdapter

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
        binding = FragmentDoneBinding.inflate(inflater, container, false)

        // 2. Adapter 연결 ( list를 인자로 )
        adapter = TodoDoneAdapter(emptyList<Todo>())
        adapter.setHasStableIds(true)
        binding!!.rvDone.adapter = adapter

        // 3. recyclerView에 Layout 꼭 설정하기 ( 안그러면 화면에 표시 안되고 skip됨 )
        binding!!.rvDone.layoutManager = LinearLayoutManager(activity)

        // 4. return Fragment Layout View
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DoneFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DoneFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}