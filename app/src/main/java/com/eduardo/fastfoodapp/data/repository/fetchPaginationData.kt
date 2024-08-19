package com.eduardo.fastfoodapp.data.repository

import android.util.Log
import com.eduardo.fastfoodapp.network.RetrofitClient

suspend fun fetchPaginationData(): Map<String, Int> {
    return try {
        val response = RetrofitClient.apiService.getPaginationData()
        if (response.isSuccessful) {
            val paginationData = response.body()
            if (paginationData != null) {
                mapOf(
                    "BBQs" to paginationData.bbqs,
                    "Best-Foods" to paginationData.bestFoods,
                    "Breads" to paginationData.breads,
                    "Burgers" to paginationData.burgers,
                    "Chocolates" to paginationData.chocolates,
                    "Desserts" to paginationData.desserts,
                    "Drinks" to paginationData.drinks,
                    "Fried-Chicken" to paginationData.friedChicken,
                    "Ice-Cream" to paginationData.iceCream,
                    "Pizzas" to paginationData.pizzas,
                    "Porks" to paginationData.porks,
                    "Sandwiches" to paginationData.sandwiches,
                    "Sausages" to paginationData.sausages,
                    "Steaks" to paginationData.steaks
                )
            } else {
                Log.e("API_ERROR", "Pagination data is null")
                emptyMap()
            }
        } else {
            Log.e("API_ERROR", "Response error: ${response.errorBody()?.string()}")
            emptyMap()
        }
    } catch (e: Exception) {
        Log.e("API_ERROR", "Exception: ${e.message}", e)
        emptyMap()
    }
}
