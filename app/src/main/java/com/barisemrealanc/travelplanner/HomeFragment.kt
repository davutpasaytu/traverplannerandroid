package com.barisemrealanc.travelplanner

import NewsAdapter
import NewsItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // XML'i bağla
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Haber verileri
        val newsList = listOf(
            NewsItem("Haber 1", "Bu bir önizleme yazısıdır."),
            NewsItem("Haber 2", "İkinci haberin önizleme yazısı."),
            NewsItem("Haber 3", "Üçüncü haberin açıklaması."),
            NewsItem("Haber 4", "Dördüncü haberin detayları."),
        )

        // RecyclerView'i ayarla
        val rvNews = view.findViewById<RecyclerView>(R.id.rvNews)
        rvNews.layoutManager = GridLayoutManager(requireContext(), 1) // 2 sütun
        rvNews.adapter = NewsAdapter(newsList)

        return view
    }
}
