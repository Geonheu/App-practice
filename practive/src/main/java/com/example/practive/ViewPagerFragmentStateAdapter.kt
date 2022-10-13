package com.example.practive

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerFragmentStateAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    // ViewPager에서 이동할 Fragment list
    private var fragments: ArrayList<Fragment> = arrayListOf(PendingFragment(), DoneFragment())

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}