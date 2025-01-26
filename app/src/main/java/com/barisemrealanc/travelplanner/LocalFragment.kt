package com.barisemrealanc.travelplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.barisemrealanc.travelplanner.databinding.FragmentLocalBinding

class LocalFragment : Fragment() {

    private var _binding: FragmentLocalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocalBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        // İçerik Listesi
        val localPosts = listOf(
            LocalPost(
                "Maria Markham",
                "1d · Follow",
                "Afternoon hike at Violet and Orange Trails",
                "Hamden, Connecticut",
                "5,00 km", "127 m", "1h 21m",
                R.drawable.image4, // Profil Resmi
                R.drawable.image3 // Gönderi Resmi
            ),
            LocalPost(
                "John Doe",
                "2d · Follow",
                "Morning walk at Lake View",
                "New Haven, Connecticut",
                "3,80 km", "85 m", "45m",
                R.drawable.image3, // Profil Resmi
                R.drawable.image4 // Gönderi Resmi
            )
        )

        // RecyclerView Ayarları
        val adapter = LocalAdapter(localPosts)
        binding.recyclerViewLocal.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLocal.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
