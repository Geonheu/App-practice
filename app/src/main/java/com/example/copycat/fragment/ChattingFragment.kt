package com.example.copycat.fragment

import ChatAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.copycat.ChatUserData
import com.example.copycat.R
import com.example.copycat.databinding.FragmentChattingBinding
import kotlinx.android.synthetic.main.chat_list.*
import java.util.zip.Inflater

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChattingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChattingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentChattingBinding
    private lateinit var adapter : ChatAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var datas: ArrayList<ChatUserData>

    lateinit var name : Array<String>
    lateinit var date : Array<String>
    lateinit var content : Array<String>

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
        binding = FragmentChattingBinding.inflate(inflater, container, false)
        dataInitialize()
        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerVertical.layoutManager = layoutManager
        adapter = ChatAdapter(datas)
        binding.recyclerVertical.adapter = adapter
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChattingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChattingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    private fun dataInitialize() {
        datas = arrayListOf<ChatUserData>()


        name = arrayOf(
            getString(R.string.friends_1),
            getString(R.string.friends_2),
            getString(R.string.friends_3),
            getString(R.string.friends_4),
            getString(R.string.friends_5),
            getString(R.string.friends_6),
            getString(R.string.friends_7)
        )

        date = arrayOf(
            getString(R.string.date_today),
            getString(R.string.date_today),
            getString(R.string.date_today),
            getString(R.string.date_yesterday),
            getString(R.string.date_yesterday),
            getString(R.string.date_yesterday),
            getString(R.string.date_yesterday)
        )

        content = arrayOf(
            getString(R.string.content_a),
            getString(R.string.content_b),
            getString(R.string.content_c),
            getString(R.string.content_d),
            getString(R.string.content_e),
            getString(R.string.content_f),
            getString(R.string.content_g)
        )

        for (i in name.indices){

            val users = ChatUserData("${name[i]}", "${date[i]}", "${content[i]}")
            datas.add(users)
        }
    }


}