package com.eduardo.fastfoodapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.eduardo.fastfoodapp.network.FoodItem
import com.eduardo.fastfoodapp.network.RetrofitClient

@Composable
fun CategoryListScreen(
    categoryMap: Map<String, Int>,
    onCategoryClick: (String) -> Unit
) {
    LazyColumn {
        items(categoryMap.toList()) { (category, count) ->
            Text(
                text = "$category: $count items",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { onCategoryClick(category) }
            )
        }
    }
}
//category display
suspend fun fetchFoodItemsByCategory(category: String): List<FoodItem> {
    return try {
        val response = RetrofitClient.apiService.getFoodItems()
        if (response.isSuccessful) {
            val foodItems = response.body() ?: emptyList()
            Log.d("API_SUCCESS", "Fetched items: ${foodItems.size} items")

            // Filtrar por nome ou descrição se necessário
            val filteredItems = foodItems.filter { it.dsc.contains(category, ignoreCase = true) }
            Log.d("API_SUCCESS", "Filtered items for category '$category': ${filteredItems.size} items")

            filteredItems
        } else {
            Log.e("API_ERROR", "Response error: ${response.errorBody()?.string()}")
            emptyList()
        }
    } catch (e: Exception) {
        Log.e("API_ERROR", "Exception: ${e.message}", e)
        emptyList()
    }
}

//item display
@Composable
fun ItemListScreen(category: String, items: List<FoodItem>) {
    Log.d("UI_LOG", "Displaying ${items.size} items for category '$category'")

    LazyColumn {
        items(items) { item ->
            Log.d("UI_LOG", "Item: ${item.name}, Price: ${item.price}, Description: ${item.dsc}")
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(item.img),
                    contentDescription = item.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "${item.name}",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "${item.dsc}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Price: $${item.price}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}