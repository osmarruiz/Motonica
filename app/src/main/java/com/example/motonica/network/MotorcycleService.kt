package com.example.motonica.network

import com.example.motonica.models.Motorcycle
import retrofit2.Response
import retrofit2.http.GET

interface MotorcycleService {
    @GET("/me/motorcycles?page=2")
    suspend fun getMotorcycles(): Response<List<Motorcycle>>
}