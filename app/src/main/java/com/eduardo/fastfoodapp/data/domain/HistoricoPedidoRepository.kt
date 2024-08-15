package com.eduardo.fastfoodapp.data.domain

import com.eduardo.fastfoodapp.data.local.HistoricoPedidoEntity

interface HistoricoPedidoRepository {
    suspend fun addPedidoToHistory(pedido: FoodItem)
    suspend fun getAllHistoricoPedidos(): List<HistoricoPedidoEntity>
}
