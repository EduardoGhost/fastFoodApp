package com.eduardo.fastfoodapp.network

import com.eduardo.fastfoodapp.data.PaginationResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/pagination")
    suspend fun getPaginationData(): Response<PaginationResponse>

    @GET("/our-foods")
    suspend fun getFoodItems(): Response<List<FoodItem>>
}

data class FoodItem(
    val id: String,
    val img: String,
    val name: String,
    val dsc: String,
    val price: Double,
    val rate: Int,
    val country: String
)
