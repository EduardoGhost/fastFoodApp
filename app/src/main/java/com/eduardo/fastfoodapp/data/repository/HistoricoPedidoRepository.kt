package com.eduardo.fastfoodapp.data.repository

import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.data.entities.HistoricoPedidoEntity

interface HistoricoPedidoRepository {
    suspend fun addPedidoToHistory(pedido: FoodItem)
    suspend fun getAllHistoricoPedidos(): List<HistoricoPedidoEntity>
}
