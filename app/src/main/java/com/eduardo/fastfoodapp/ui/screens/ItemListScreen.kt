package com.eduardo.fastfoodapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.eduardo.fastfoodapp.components.IncrementDecrementButtonsComponent
import com.eduardo.fastfoodapp.components.RateComponent
import com.eduardo.fastfoodapp.data.model.FoodItem
import com.eduardo.fastfoodapp.viewmodel.PedidoViewModel

//item display
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemListScreen(
    items: List<FoodItem>,
    viewModel: PedidoViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }
    val pedidos by viewModel.pedidos.collectAsState(initial = emptyList())

    val filteredItems = if (searchQuery.isEmpty()) {
        items
    } else {
        items.filter { it.name.contains(searchQuery, ignoreCase = true) || it.dsc.contains(searchQuery, ignoreCase = true) }
    }

    LaunchedEffect(pedidos) {
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Item List", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = Color.White)
                    }
                },
                windowInsets = WindowInsets.systemBars,
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,

                    ),
                scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
                actions = {
                    Box(
                        contentAlignment = Alignment.CenterEnd,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        IconButton(onClick = { navController.navigate("pedidoList") }) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Carrinho",
                                tint = Color.White
                            )
                        }
                        if (pedidos.isNotEmpty()) {
                            Badge(
                                containerColor = Color.Red,
                                contentColor = Color.White,
                                modifier = Modifier.offset(x = (-8).dp, y = (-8).dp)
                            ) {
                                Text("${pedidos.size}")
                            }
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            LazyColumn {
                items(filteredItems) { item ->
                    var quantity by remember { mutableStateOf(1) }
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

                        RateComponent(rate = item.rate)

                        Text(
                            text = "Price: $${item.price}",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        IncrementDecrementButtonsComponent(
                            quantity = quantity,
                            onIncrement = { quantity += 1 },
                            onDecrement = { if (quantity > 1) quantity -= 1 }
                        )

                        Button(
                            onClick = {
                                viewModel.addPedidoToCart(item, quantity)
                                Toast.makeText(context, "Item adicionado ao Carrinho!", Toast.LENGTH_SHORT).show()
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
}



