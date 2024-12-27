package com.barisemrealanc.travelplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.barisemrealanc.travelplanner.R
import com.barisemrealanc.travelplanner.databinding.FragmentSavedBinding

class SavedFragment : Fragment() {

    private var _binding: FragmentSavedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSavedBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        val savedItems = listOf(
            SavedItem("Create new list", R.drawable.app_logo, ""),
            SavedItem("My favorites", R.drawable.app_logo, "1 trail"),
            SavedItem("My maps", R.drawable.app_logo, "0 maps")
        )

        val adapter = SavedAdapter(savedItems)
        binding.recyclerViewSaved.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSaved.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
