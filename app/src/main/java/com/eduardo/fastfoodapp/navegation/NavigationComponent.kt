package com.eduardo.fastfoodapp.navegation

import android.util.Log
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.data.fetchPaginationData
import com.eduardo.fastfoodapp.ui.screens.CategoryListScreen
import com.eduardo.fastfoodapp.ui.screens.ItemListScreen
import com.eduardo.fastfoodapp.ui.screens.fetchFoodItemsByCategory

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "categoryList") {
        composable("categoryList") {
            var categoryMap by remember { mutableStateOf(mapOf<String, Int>()) }

            LaunchedEffect(Unit) {
                val fetchedData = fetchPaginationData()
                categoryMap = fetchedData
            }

            CategoryListScreen(categoryMap, onCategoryClick = { category ->
                navController.navigate("itemList/$category")
            })
        }

        composable("itemList/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            if (category != null) {
                var items by remember { mutableStateOf(listOf<FoodItem>()) }

                LaunchedEffect(category) {
                    val fetchedItems = fetchFoodItemsByCategory(category)
                    items = fetchedItems
                }

                ItemListScreen(
                    items = items,
                    onAddToCartClicked = { item ->
                        Log.d("UI_LOG", "Item ${item.name} adicionado ao carrinho")
                    }
                )

            }
        }
    }
}

