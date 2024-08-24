package com.eduardo.fastfoodapp.data.repository

import com.eduardo.fastfoodapp.data.model.FoodItem

interface PedidoRepository {

    suspend fun addPedido(pedido: FoodItem, quantity: Int)
    suspend fun getPedidos(): List<FoodItem>
    suspend fun clearPedidos()
    suspend fun deletePedido(pedido: FoodItem)
}