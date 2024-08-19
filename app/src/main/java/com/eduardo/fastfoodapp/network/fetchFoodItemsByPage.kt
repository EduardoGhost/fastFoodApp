package com.eduardo.fastfoodapp.network

import android.util.Log
import com.eduardo.fastfoodapp.data.model.FoodItem

suspend fun fetchFoodItemsByCategory(categoryName: String): List<FoodItem> {
    return try {
        val response = RetrofitClient.apiService.getFoodItemsByCategory(categoryName)
        if (response.isSuccessful) {
            val foodItems = response.body() ?: emptyList()
            Log.d("API_SUCCESS", "Fetched items for category '$categoryName': ${foodItems.size} items")
            foodItems
        } else {
            Log.e("API_ERROR", "Response error: ${response.errorBody()?.string()}")
            emptyList()
        }
    } catch (e: Exception) {
        Log.e("API_ERROR", "Exception: ${e.message}", e)
        emptyList()
    }
}