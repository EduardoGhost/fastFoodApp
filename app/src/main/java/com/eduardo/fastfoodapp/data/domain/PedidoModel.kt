package com.eduardo.fastfoodapp.data.domain

data class FoodItem(
    val id: String,
    val img: String,
    val name: String,
    val dsc: String,
    val price: Double,
    val rate: Int,
    val country: String

)