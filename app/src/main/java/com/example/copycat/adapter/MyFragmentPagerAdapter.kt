package com.example.copycat.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.copycat.*
import com.example.copycat.fragment.*

class MyFragmentPagerAdapter(activity: MainActivity): FragmentStateAdapter(activity) {
    val fragments : List<Fragment>
    init {
        fragments = listOf(
            FriendsFragment(),
            ChattingFragment(),
            ViewFragment(),
            ShoppingFragment(),
            SettingFragment()
        ) // rename 한 파일들은 바꾼 이름이 아닌 원래 이름으로 호출해야함. 아 싯팔 아님 ㅋㅋ 클래스명을 안바꿔서 안된거였음...
    }
    override fun getItemCount(): Int = fragments.size // fragment의 개수를 파악

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FriendsFragment()
            1 -> ChattingFragment()
            2 -> ViewFragment()
            3 -> ShoppingFragment()
            else -> SettingFragment()
        }
    } // 어떤 fragment 인지 파악
}