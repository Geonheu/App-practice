package com.example.practive.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.practive.MineFragment
import com.example.practive.fragments.OneFragment
import com.example.practive.fragments.TodoMineFragment
import com.example.practive.fragments.TwoFragment

class ViewPagerAdapter(fragment: MineFragment): FragmentStateAdapter(fragment) {

    val fragments: List<Fragment>
    init{
        fragments = listOf(TodoMineFragment(), OneFragment(), TwoFragment())
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}