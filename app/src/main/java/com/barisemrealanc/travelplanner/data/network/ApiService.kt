package com.barisemrealanc.travelplanner.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

// Veri modellerini tanımlayın
data class Place(val id: Int, val name: String, val location: String, val description: String)
data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val token: String, val message: String)

// Retrofit API tanımı
interface ApiService {
    @GET("/api/places")
    fun getAllPlaces(): Call<List<Place>>

    @POST("/api/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}
