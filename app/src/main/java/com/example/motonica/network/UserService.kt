package com.example.motonica.network


import com.example.motonica.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("user/{id}")
    suspend fun getUser(@Path("id") id: Int): Response<User>
}