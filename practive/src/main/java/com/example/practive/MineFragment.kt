package com.example.practive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.practive.Adapter.ListAdapter
import com.example.practive.Adapter.ViewPagerAdapter
import com.example.practive.databinding.FragmentMineBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MineFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentMineBinding
    private lateinit var adapter: ListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var list: ArrayList<FriendList>

    lateinit var friendImage: Array<String>
    lateinit var friendName: Array<String>

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
        // 1. viewbinding 설정
        binding = FragmentMineBinding.inflate(inflater, container, false)

        // 2. Adapter 연결
        dataInitialize()
        adapter = ListAdapter(list)
        adapter.setHasStableIds(true)
        binding!!.recyclerView.adapter = adapter

        // 3. recyclerView에 layout 꼭 설정하기 ( 안그러면 skip 됨 )
        binding!!.recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        // 4. return Fragment layout view

        // 5. viewPager 연결
        val viewpager: ViewPager2 = binding.viewPager
        val viewpagerAdapter = ViewPagerAdapter(this)
        viewpager.adapter = viewpagerAdapter


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MineFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MineFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun dataInitialize(){
        list = arrayListOf<FriendList>()

        friendName = arrayOf(
            "유림",
            "엄마",
            "아빠",
            "재욱",
            "용수",
            "영환",
            "준호",
            "종욱",
            "민종"
        )

        for(i in friendName.indices){

            val users = FriendList("${friendName[i]}")
            list.add(users)
        }
    }
}