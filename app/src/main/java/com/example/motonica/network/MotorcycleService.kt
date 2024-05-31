package com.example.motonica.network

import androidx.room.util.query
import com.example.motonica.models.Motorcycle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MotorcycleService {
    @GET("/me/motorcycles")
    suspend fun getMotorcycles(@Query("page") page: Int): Response<List<Motorcycle>>
}