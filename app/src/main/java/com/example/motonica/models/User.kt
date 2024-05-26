package com.example.motonica.models

data class User(
    val id: Int,
    val first_name: String,
    val middle_name: String,
    val last_name: String,
    val surname: String,
    val email: String,
    val phone_number: String,
    val picture_url: String
    )
