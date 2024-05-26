package com.example.motonica.network

import com.example.motonica.models.Motorcycle
import com.example.motonica.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MotorcycleService {
    @GET("motorcycle")
    suspend fun getMotorcycles(): Response<List<Motorcycle>>
}