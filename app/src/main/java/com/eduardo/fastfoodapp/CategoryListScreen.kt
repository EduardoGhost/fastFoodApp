package com.eduardo.fastfoodapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eduardo.fastfoodapp.network.RetrofitClient
import com.eduardo.fastfoodapp.ui.theme.FastFoodAppTheme

@Composable
fun CategoryListScreen(categoryMap: Map<String, Int>) {
    LazyColumn {
        items(categoryMap.toList()) { (category, count) ->
            Text(text = "$category: $count items")
        }
    }
}

suspend fun fetchPaginationData(): Map<String, Int> {
    return try {
        val response = RetrofitClient.apiService.getPaginationData()
        if (response.isSuccessful) {
            response.body() ?: emptyMap()
        } else {
            Log.e("API_RESPONSE", "Response error: ${response.errorBody()?.string()}")
            emptyMap()
        }
    } catch (e: Exception) {
        Log.e("API_ERROR", "Exception: ${e.message}", e)
        emptyMap()
    }
}