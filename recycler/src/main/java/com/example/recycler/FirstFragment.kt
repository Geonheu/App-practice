package com.example.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: RecyclerViewAdapter

    val mDatas = mutableListOf<ItemData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // 1. View Binding 설정
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        // 2. adapter 설정 (list를 인자로)
        initInputData()
        adapter = RecyclerViewAdapter()
        adapter.datalist = mDatas
        adapter.setHasStableIds(true)
        binding!!.recyclerView.adapter = adapter


        // 3. recyclerView에 Layout 꼭 설정하기 (안그러면 화면에 표시 안되고 skip됨)
        binding!!.recyclerView.layoutManager = LinearLayoutManager(activity)

        // 4. return Fragment Layout View
        return binding.root

//
//        val adapter = RecyclerViewAdapter() // 어댑터 객체 만들어줌
//        adapter.datalist = mDatas // 데이터 넣어줌
//        binding.recyclerView.adapter = adapter // 리사이클러뷰에 어댑터 연결
//        binding.recyclerView.layoutManager = LinearLayoutManager(activity) // 레이아웃 매니저 연결
//

//        }
    }

    fun initInputData(){
        with(mDatas) {
            add(ItemData("조건희", "안녕^^", ""))
            add(ItemData("김유림", "안녕^^", ""))
            add(ItemData("정영환", "안녕^^", ""))
            add(ItemData("송재욱", "안녕^^", ""))
            add(ItemData("정용수", "안녕^^", ""))
            add(ItemData("도민종", "안녕^^", ""))
            add(ItemData("한준호", "안녕^^", ""))
            add(ItemData("이종욱", "안녕^^", ""))
        }
    }

}