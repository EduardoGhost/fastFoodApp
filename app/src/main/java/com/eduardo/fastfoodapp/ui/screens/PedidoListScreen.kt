package com.eduardo.fastfoodapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.viewmodel.PedidoViewModel

//tela de lista de pedidos / carrinho
@Composable
fun PedidoListScreen(viewModel: PedidoViewModel) {
    val pedidos by viewModel.pedidos.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Carrinho",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (pedidos.isEmpty()) {
            Text(text = "Nenhum pedido no carrinho.", style = MaterialTheme.typography.bodyMedium)
        } else {
            LazyColumn {
                items(pedidos) { pedido ->
                    PedidoItem(pedido)

                }
            }
        }
    }
}

@Composable
fun PedidoItem(pedido: FoodItem) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = pedido.name, style = MaterialTheme.typography.titleMedium)
        Text(text = "Quantidade: ${pedido.quantity}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Preço: R$${pedido.price}", style = MaterialTheme.typography.bodyMedium)
    }
}


