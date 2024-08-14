package com.eduardo.fastfoodapp.navegation

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.data.fetchPaginationData
import com.eduardo.fastfoodapp.ui.screens.CategoryListScreen
import com.eduardo.fastfoodapp.ui.screens.ItemListScreen
import com.eduardo.fastfoodapp.ui.screens.fetchFoodItemsByCategory
import com.eduardo.fastfoodapp.viewmodel.PedidoViewModel

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "categoryList") {
        composable("categoryList") {
            var categoryMap by remember { mutableStateOf(mapOf<String, Int>()) }

            LaunchedEffect(Unit) {
                val fetchedData = fetchPaginationData()
                categoryMap = fetchedData
            }

            CategoryListScreen(
                categoryMap = categoryMap,
                onCategoryClick = { category ->
                    navController.navigate("itemList/$category")
                }
            )
        }

        composable("itemList/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            if (category != null) {
                var items by remember { mutableStateOf(listOf<FoodItem>()) }

                LaunchedEffect(category) {
                    val fetchedItems = fetchFoodItemsByCategory(category)
                    items = fetchedItems
                }

                val viewModel: PedidoViewModel = hiltViewModel()
                ItemListScreen(
                    items = items,
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }
    }
}