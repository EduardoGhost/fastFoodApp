package com.eduardo.fastfoodapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.viewmodel.PedidoViewModel

//tela de lista de pedidos / checkout
@Composable
fun PedidoListScreen(viewModel: PedidoViewModel) {
    val pedidos by viewModel.pedidos.collectAsState(initial = emptyList())
    val context = LocalContext.current

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
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Total: R$${pedidos.sumOf { it.price * it.quantity }}",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        Button(
            onClick = { viewModel.finalizarCompra()
                Toast.makeText(context, "Compra concluída com sucesso!", Toast.LENGTH_SHORT).show()
                      },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Concluir Compra")
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
        Text(text = "Preço: R$${pedido.price*pedido.quantity}", style = MaterialTheme.typography.bodyMedium)
    }
}