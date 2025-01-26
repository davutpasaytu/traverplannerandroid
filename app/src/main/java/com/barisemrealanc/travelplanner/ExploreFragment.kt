package com.barisemrealanc.travelplanner

import FollowingFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.barisemrealanc.travelplanner.databinding.FragmentExploreBinding
import com.google.android.material.tabs.TabLayoutMediator

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)

        setupViewPager()
        return binding.root
    }

    private fun setupViewPager() {
        // ViewPager adapter
        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 2 // Local ve Following
            override fun createFragment(position: Int): Fragment {
                return if (position == 0) LocalFragment() else FollowingFragment()
            }
        }
        binding.viewPagerExplore.adapter = adapter

        // TabLayout mediator
        TabLayoutMediator(binding.tabLayoutExplore, binding.viewPagerExplore) { tab, position ->
            tab.text = if (position == 0) "Local" else "Following"
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
