package com.eduardo.fastfoodapp.network

import com.eduardo.fastfoodapp.data.model.FoodItem
import com.eduardo.fastfoodapp.data.model.PaginationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/pagination")
    suspend fun getPaginationData(): Response<PaginationResponse>

    @GET("/our-foods")
    suspend fun getFoodItems(): Response<List<FoodItem>>

    @GET("/{category}")
    suspend fun getFoodItemsByCategory(
        @Path("category") category: String
    ): Response<List<FoodItem>>

}