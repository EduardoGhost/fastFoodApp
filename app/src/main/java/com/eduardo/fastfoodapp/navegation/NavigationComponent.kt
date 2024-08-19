package com.eduardo.fastfoodapp.navegation

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eduardo.fastfoodapp.data.model.FoodItem
import com.eduardo.fastfoodapp.data.repository.fetchPaginationData
import com.eduardo.fastfoodapp.network.fetchFoodItemsByPage
import com.eduardo.fastfoodapp.ui.screens.*
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
                },  navController = navController
            )
        }

        composable("itemList/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            if (category != null) {
                var items by remember { mutableStateOf(listOf<FoodItem>()) }

                LaunchedEffect(category) {
                    val fetchedItems = fetchFoodItemsByPage(1, 20)
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
        composable("pedidoList") {
            val viewModel: PedidoViewModel = hiltViewModel()
            PedidoListScreen(viewModel = viewModel, navController = navController)
        }

        composable("historicoPedidoList") {
            HistoricoPedidoScreen(navController = navController)
        }
    }
}