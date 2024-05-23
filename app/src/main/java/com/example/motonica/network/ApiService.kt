package com.example.motonica.network

import com.example.motonica.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): Response<User>
}