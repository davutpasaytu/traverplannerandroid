package com.barisemrealanc.travelplanner

import ExploreAdapter
import ExplorePost
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.barisemrealanc.travelplanner.databinding.FragmentExploreBinding
import com.google.android.material.tabs.TabLayout

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    private lateinit var localPosts: List<ExplorePost>
    private lateinit var followingPosts: List<ExplorePost>
    private lateinit var adapter: ExploreAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)

        setupData()
        setupRecyclerView()
        setupTabLayout()

        return binding.root
    }

    private fun setupData() {
        // Local sekmesi için veriler
        localPosts = listOf(
            ExplorePost(
                "Vito Pelliccia Jr.",
                "Dec 12 · Follow",
                "Afternoon hike at Mirror Lake, White Trail, and Castle Craig",
                R.drawable.app_logo, // Profil fotoğrafı placeholder
                R.drawable.app_logo // Post görseli placeholder
            ),
            ExplorePost(
                "Jane Doe",
                "Dec 10 · Follow",
                "Morning walk at Sunset Point",
                R.drawable.app_logo,
                R.drawable.app_logo
            )
        )

        // Following sekmesi için veriler
        followingPosts = listOf(
            ExplorePost(
                "John Smith",
                "Dec 15 · Follow",
                "Exploring the Hidden Gems of Mystic Falls",
                R.drawable.app_logo,
                R.drawable.app_logo
            ),
            ExplorePost(
                "Emily Brown",
                "Dec 9 · Follow",
                "Cycling along the Seaside Trails",
                R.drawable.app_logo,
                R.drawable.app_logo
            )
        )
    }

    private fun setupRecyclerView() {
        adapter = ExploreAdapter(localPosts) // İlk olarak "Local" sekmesinin verileri gösteriliyor
        binding.recyclerViewExplore.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewExplore.adapter = adapter
    }

    private fun setupTabLayout() {
        binding.tabLayoutExplore.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        // "Local" sekmesi seçildi
                        adapter.updatePosts(localPosts)
                    }
                    1 -> {
                        // "Following" sekmesi seçildi
                        adapter.updatePosts(followingPosts)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
