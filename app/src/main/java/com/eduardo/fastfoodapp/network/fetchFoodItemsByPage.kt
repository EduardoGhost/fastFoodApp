package com.eduardo.fastfoodapp.network

import android.util.Log
import com.eduardo.fastfoodapp.data.model.FoodItem

suspend fun fetchFoodItemsByPage(page: Int, limit: Int): List<FoodItem> {
    return try {

        val paginationResponse = RetrofitClient.apiService.getPaginationData()
        if (paginationResponse.isSuccessful) {
            val paginationData = paginationResponse.body()
            Log.d("API_SUCCESS", "Pagination data fetched successfully: $paginationData")

            val response = RetrofitClient.apiService.getFoodItems()
            if (response.isSuccessful) {
                val allItems = response.body() ?: emptyList()

                val startIndex = (page - 1) * limit
                val endIndex = (startIndex + limit).coerceAtMost(allItems.size)
                allItems.subList(startIndex, endIndex)
            } else {
                Log.e("API_ERROR", "Response error: ${response.errorBody()?.string()}")
                emptyList()
            }
        } else {
            Log.e("API_ERROR", "Pagination Response error: ${paginationResponse.errorBody()?.string()}")
            emptyList()
        }
    } catch (e: Exception) {
        Log.e("API_ERROR", "Exception: ${e.message}", e)
        emptyList()
    }
}