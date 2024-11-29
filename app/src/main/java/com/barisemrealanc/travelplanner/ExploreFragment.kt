package com.barisemrealanc.travelplanner

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import com.barisemrealanc.travelplanner.R
import com.barisemrealanc.travelplanner.data.network.ApiService
import com.barisemrealanc.travelplanner.data.network.Place
import com.barisemrealanc.travelplanner.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExploreFragment : Fragment(R.layout.fragment_explore) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sayfa açıldığında API çağrısını başlat
        fetchPlaces()
    }

     //API'den Gezilecek Yerleri Çekme
    private fun fetchPlaces() {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        apiService.getAllPlaces().enqueue(object : Callback<List<Place>> {
            override fun onResponse(call: Call<List<Place>>, response: Response<List<Place>>) {
                if (response.isSuccessful) {
                    val places = response.body()
                    println("Gezilecek Yerler: $places")
                } else {
                    println("Hata: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Place>>, t: Throwable) {
                println("Bağlantı Hatası: ${t.message}")
            }
        })
    }
}
