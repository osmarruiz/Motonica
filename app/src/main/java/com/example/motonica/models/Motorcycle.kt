package com.example.motonica.models

data class Motorcycle(
    val id: Int,
    val owner_id: Int,
    val price: Double,
    val type: String,
    val mileage: Int,
    val brand: String,
    val model: String,
    val year: Int,
    val engine: String,
    val color: String,
    val description: String,
    val location: String,
    val images: List<MotorcycleImage>
)
