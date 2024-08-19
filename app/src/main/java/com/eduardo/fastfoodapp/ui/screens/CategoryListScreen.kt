package com.eduardo.fastfoodapp.ui.screens

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
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                items(categoryMap.toList()) { (category, count) ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { onCategoryClick(category) },
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = category,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }
    )
}