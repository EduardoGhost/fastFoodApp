package com.eduardo.fastfoodapp.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.InsertChart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.network.RetrofitClient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListScreen(
    categoryMap: Map<String, Int>,
    onCategoryClick: (String) -> Unit,
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Categorias", color = Color.White) },
                windowInsets = WindowInsets.systemBars,
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,

                ),
                scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),

                actions = {
                    IconButton(onClick = {
                        navController.navigate("historicoPedidoList")
                    }) {
                        Icon(Icons.Default.InsertChart, contentDescription = "Ver Histórico", tint = Color.White)
                    }
                }

            )
        },
        content = { paddingValues ->
            LazyColumn(
                contentPadding = paddingValues,
                modifier = Modifier.fillMaxSize()
            ) {
                items(categoryMap.toList()) { (category, count) ->
                    Text(
                        text = "$category",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable { onCategoryClick(category) }
                    )
                }
            }
        }
    )
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