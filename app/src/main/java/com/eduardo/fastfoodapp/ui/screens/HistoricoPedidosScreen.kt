package com.eduardo.fastfoodapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.eduardo.fastfoodapp.data.local.HistoricoPedidoEntity
import com.eduardo.fastfoodapp.viewmodel.HistoricoPedidoViewModel


@Composable
fun HistoricoPedidoScreen(viewModel: HistoricoPedidoViewModel = hiltViewModel()) {
    val historicoPedidos by viewModel.historicoPedidos.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Histórico de Pedidos",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

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
