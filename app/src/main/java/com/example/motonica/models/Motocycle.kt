package com.example.motonica.models

data class Motocycle(
    val id: Int,
    val post_title: String,
    val price: Double,
    val type: String,
    val mileage: Int,
    val brand: String,
    val model: String,
    val engine: String,
    val color: String,
    val description: String,
    val location: String
)
