package com.barisemrealanc.travelplanner

import ParkAdapter
import ParkItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.barisemrealanc.travelplanner.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        val parks = listOf(
            ParkItem(
                name = "Ragged Mountain Blue and Red Blazed Loop",
                location = "Berlin, Connecticut",
                rating = 4.6,
                difficulty = "Moderate",
                distance = "9.01 km",
                estimatedTime = "Est. 2h 28m",
                imageList = listOf(R.drawable.image3, R.drawable.image4)
            ),
            ParkItem(
                name = "Another Trail Name",
                location = "Another Location",
                rating = 4.3,
                difficulty = "Easy",
                distance = "5.6 km",
                estimatedTime = "Est. 1h 45m",
                imageList = listOf(R.drawable.image3, R.drawable.image4)
            ),
            ParkItem(
                name = "Baris Secret Place",
                location = "Ameriga",
                rating = 5.0,
                difficulty = "hard",
                distance = "40000km",
                estimatedTime = "Est. 15h",
                imageList = listOf(R.drawable.image4, R.drawable.image3)
            )

        )

        val adapter = ParkAdapter.ParkAdapter(parks, onSaveClick = { park ->
            println("${park.name} saved!")
        }, onDetailsClick = { park ->
            println("Navigating to details for ${park.name}")
        })

        binding.recyclerViewParks.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewParks.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
