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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.eduardo.fastfoodapp.data.domain.FoodItem

//item display
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemListScreen(
    items: List<FoodItem>,
    onAddToCartClicked: (FoodItem) -> Unit
) {
    Log.d("UI_LOG", "Displaying ${items.size}")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Item List") },
                actions = {
                    IconButton(onClick = {
                        // Ação ao clicar no ícone do carrinho
                        Log.d("UI_LOG", "Carrinho clicked")
                    }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Carrinho")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
            ))
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            items(items) { item ->
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
                        text = item.name,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = item.dsc,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Price: $${item.price}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Button(
                        onClick = {
                            onAddToCartClicked(item)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Yellow,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    ) {
                        Text("Adicionar ao Carrinho")
                    }
                }
            }
        }
    }
}




