package com.eduardo.fastfoodapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.data.repository.HistoricoPedidoRepository
import com.eduardo.fastfoodapp.data.repository.PedidoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PedidoViewModel @Inject constructor(
    private val pedidoRepository: PedidoRepository,
    private val historicoPedidoRepository: HistoricoPedidoRepository
) : ViewModel() {

    private val _pedidos = MutableStateFlow<List<FoodItem>>(emptyList())
    val pedidos: StateFlow<List<FoodItem>> = _pedidos.asStateFlow()

    init {
        loadPedidos()
    }

    private fun loadPedidos() {
        viewModelScope.launch {
            _pedidos.value = pedidoRepository.getPedidos()
        }
    }

    fun addPedidoToCart(foodItem: FoodItem, quantity: Int) {
        viewModelScope.launch {
            pedidoRepository.addPedido(foodItem, quantity)
            loadPedidos()
        }
    }

    fun finalizarCompra() {
        viewModelScope.launch {
            // Pegar pedidos
            val currentPedidos = pedidoRepository.getPedidos()

            // Salvar cada pedido no histórico/relatorio
            currentPedidos.forEach { pedido ->
                historicoPedidoRepository.addPedidoToHistory(pedido)
            }

            // Limpar os pedidos
            pedidoRepository.clearPedidos()

            // Atualizar a lista de pedidos observada pela UI
            _pedidos.value = emptyList()

        }
    }

}



