package com.eduardo.fastfoodapp.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.viewmodel.PedidoViewModel

//item display
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemListScreen(items: List<FoodItem>, viewModel: PedidoViewModel,  navController: NavController) {
    Log.d("UI_LOG", "Displaying ${items.size}")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Item List") },
                actions = {
                    IconButton(onClick = { navController.navigate("pedidoList") }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Carrinho")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding
        ) {
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
                    Button(
                        onClick = {
                            // Adiciona item no carrinho
                            viewModel.addPedidoToCart(item, quantity = 1)
                            Log.d("UI_LOG", "Item ${item.name} added to cart")
                        },
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text(text = "Adicionar ao Carrinho")
                    }
                }
            }
        }
    }
}





