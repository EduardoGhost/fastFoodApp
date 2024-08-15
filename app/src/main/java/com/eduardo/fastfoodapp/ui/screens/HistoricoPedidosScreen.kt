package com.eduardo.fastfoodapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eduardo.fastfoodapp.data.entities.HistoricoPedidoEntity
import com.eduardo.fastfoodapp.viewmodel.HistoricoPedidoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoricoPedidoScreen(
    viewModel: HistoricoPedidoViewModel = hiltViewModel(),
    navController: NavController
) {
    val historicoPedidos by viewModel.historicoPedidos.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Histórico de Pedidos", color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                if (historicoPedidos.isEmpty()) {
                    Text(text = "Nenhum pedido realizado.", style = MaterialTheme.typography.bodyMedium)
                } else {
                    LazyColumn {
                        items(historicoPedidos) { pedido ->
                            HistoricoPedidoItem(pedido)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun HistoricoPedidoItem(pedido: HistoricoPedidoEntity) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = pedido.name, style = MaterialTheme.typography.titleMedium)
        Text(text = "Quantidade: ${pedido.quantity}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Preço: R$${pedido.price}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Total: R$${pedido.total}", style = MaterialTheme.typography.bodyMedium)
    }
}
