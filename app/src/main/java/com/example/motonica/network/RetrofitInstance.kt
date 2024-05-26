package com.example.motonica.network
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://moto-back-end-78da4d159a54.herokuapp.com"
    private const val TOKEN = "tu_token_aqui"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userService: UserService by lazy {
        retrofit.create(UserService::class.java)
    }

    val motorcycleService: MotorcycleService by lazy {
        retrofit.create(MotorcycleService::class.java)
    }
    private fun getOkHttpClient(): OkHttpClient {
        val tokenInterceptor = Interceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $TOKEN")
                .build()
            chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .addInterceptor(tokenInterceptor)
            .build()
    }
}