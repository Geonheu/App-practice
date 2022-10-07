package com.example.copycat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.copycat.adapter.MyFragmentPagerAdapter
import com.example.copycat.databinding.ActivityMainBinding
import com.example.copycat.databinding.FragmentChattingBinding
import com.example.copycat.fragment.ChattingFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var chatBinding: FragmentChattingBinding
    private lateinit var chatAdapter : ChatAdapter
    private val tabTextList = listOf("Profile", "Search", "Setting")

    val mdatas = mutableListOf<ChatUserData>()
    private val tabTitleArray = arrayOf(
        "친구",
        "채팅",
        "채널",
        "쇼핑",
        "설정"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        chatBinding = FragmentChattingBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.viewPager.apply {
//            adapter = MyFragmentPagerAdapter(this@MainActivity)
//            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//                override fun onPageSelected(position: Int) {
//                    super.onPageSelected(position)
//                    binding.bn.selectedItemId = when (position) {
//                        0 -> R.id.menu_friends
//                        1 -> R.id.menu_chatting
//                        2 -> R.id.menu_view
//                        3 -> R.id.menu_shopping
//                        else -> R.id.menu_setting
//                    }
//                }
//            })
//        }



//        binding.bn.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.menu_friends -> binding.viewPager.currentItem = 0
//                R.id.menu_chatting -> binding.viewPager.currentItem = 1
//                R.id.menu_view -> binding.viewPager.currentItem = 2
//                R.id.menu_shopping -> binding.viewPager.currentItem = 3
//                else -> binding.viewPager.currentItem = 4
//            }
//            true
//        }

        initChattingRecyclerView()
        initializeList()

//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(
//            R.id.listFrame,
//            ChattingFragment()
//        )
//        transaction.commit()
//        intent.putExtra("DataList",mdatas)

    }

    fun initializeList(){
        with(mdatas){
            add(ChatUserData("","조건희","9월13일", "ㅎㅇ"))
            add(ChatUserData("","김유림","9월13일", "사랑해♥"))
            add(ChatUserData("","정영환","9월12일", "ㅎㅇ"))
            add(ChatUserData("","정용수","9월12일", "ㅎㅇ"))
            add(ChatUserData("","송재욱","9월11일", "ㅎㅇ"))
            add(ChatUserData("","도민종","9월11일", "ㅎㅇ"))
        }
    }

    fun initChattingRecyclerView(){
        val chatAdapter = ChatAdapter()
        chatAdapter.list = mdatas
        chatBinding.recyclerVertical.adapter = chatAdapter
        chatBinding.recyclerVertical.layoutManager = LinearLayoutManager(this)
    }

}
//
//private fun Intent.putExtra(s: String, mdatas: MutableList<ChatUserData>) {
//    TODO("Not yet implemented")
//}


