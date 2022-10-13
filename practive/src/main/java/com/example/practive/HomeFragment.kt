package com.example.practive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.practive.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentHomeBinding

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

        // 1. ViewBinding 설정
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // 2. ViewPager 의 Adapter 가져오기
        binding.vpTodo.adapter = activity?.let { ViewPagerFragmentStateAdapter(it) }

        // 3. ViewPager 의 방향 설정하기
        binding.vpTodo.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 4. TabLayout + ViewPager2 연동하기 ( ViewPager2 Adapter 연동 후에 )
        TabLayoutMediator(binding.tabLayout, binding.vpTodo){ tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        // 5. return Fragment layout view , onCreateView 는 view 를 반환하기 때문에 까먹으면 안됨
        return binding.root
    }

    // Tab & ViewPager 연동 및 Tab title 설정
    private fun getTabTitle(position: Int): String?{
        return when(position){
            0 -> "Pending"
            1 -> "Done"
            else -> null
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}