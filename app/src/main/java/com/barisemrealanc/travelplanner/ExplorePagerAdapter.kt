package com.barisemrealanc.travelplanner

import FollowingFragment
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ExplorePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2 // İki sekme: Local ve Following
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LocalFragment() // İlk sekme için fragment
            1 -> FollowingFragment() // İkinci sekme için fragment
            else -> throw IllegalStateException("Invalid position $position")
        }
    }
}
