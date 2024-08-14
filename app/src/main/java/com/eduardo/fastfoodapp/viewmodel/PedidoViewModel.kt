package com.eduardo.fastfoodapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.data.domain.PedidoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PedidoViewModel @Inject constructor(
    private val pedidoRepository: PedidoRepository
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
}



