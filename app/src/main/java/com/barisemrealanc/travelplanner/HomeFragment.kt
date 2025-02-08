package com.barisemrealanc.travelplanner

import ParkAdapter
import ParkItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.barisemrealanc.travelplanner.data.network.RetrofitInstance
import com.barisemrealanc.travelplanner.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

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
        // RecyclerView için başlangıçta boş bir listeyle adapter'ı başlatıyoruz
        val adapter = ParkAdapter(emptyList(), onSaveClick = { park ->
            println("${park.name} saved!")
        }, onDetailsClick = { park ->
            println("Navigating to details for ${park.name}")
        })

        // RecyclerView'ı ve adapter'ı bağlıyoruz
        binding.recyclerViewParks.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewParks.adapter = adapter

        // Retrofit ile veriyi çekiyoruz
        lifecycleScope.launch {
            try {
                // API'den veri çekme
                val places = RetrofitInstance.api.getPlaces()
                // Adapter'ı güncelliyoruz
                adapter.updatePlaces(places)
            } catch (e: Exception) {
                e.printStackTrace()
                // Hata durumunda kullanıcıya bir mesaj gösterebilirsiniz
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
