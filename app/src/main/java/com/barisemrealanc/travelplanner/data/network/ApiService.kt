package com.barisemrealanc.travelplanner.data.network

import Place
import retrofit2.http.GET

interface ApiService {

    @GET("places")  // Bu, API'nizin ilgili endpoint'ine göre değişebilir
    suspend fun getPlaces(): List<Place>
}
