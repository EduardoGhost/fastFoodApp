package com.eduardo.fastfoodapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduardo.fastfoodapp.data.repository.HistoricoPedidoRepository
import com.eduardo.fastfoodapp.data.entities.HistoricoPedidoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HistoricoPedidoViewModel @Inject constructor(
    private val historicoPedidoRepository: HistoricoPedidoRepository
) : ViewModel() {

    private val _historicoPedidos = MutableStateFlow<List<HistoricoPedidoEntity>>(emptyList())
    val historicoPedidos: StateFlow<List<HistoricoPedidoEntity>> = _historicoPedidos

    init {
        viewModelScope.launch {
            _historicoPedidos.value = historicoPedidoRepository.getAllHistoricoPedidos()
        }
    }
}

