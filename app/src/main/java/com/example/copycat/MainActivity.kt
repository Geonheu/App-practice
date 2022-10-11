package com.example.copycat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.copycat.databinding.ActivityMainBinding
import com.example.copycat.databinding.FragmentChattingBinding
import com.example.copycat.fragment.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bn.setOnItemSelectedListener { item -> changeFragment(  // fragment 전환을 when 함수로 이용해서 적용
            when (item.itemId) {
                R.id.menu_friends -> FriendsFragment()
                R.id.menu_chatting -> ChattingFragment()
                R.id.menu_view -> ViewFragment()
                R.id.menu_shopping -> ShoppingFragment()
                else -> SettingFragment()
            })
            true
        }
        binding.bn.selectedItemId = R.id.viewFrame

    }
    private fun changeFragment(fragment: Fragment) { // Fragment 전환할때 필요한 함수
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }

    // https://www.youtube.com/watch?v=5mdV1hLbXzo 이거 참고 ( fragment랑 recyclerview 같이 넣기 )
}


