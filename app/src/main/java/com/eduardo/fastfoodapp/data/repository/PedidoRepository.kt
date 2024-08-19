package com.eduardo.fastfoodapp.data.repository

import com.eduardo.fastfoodapp.data.model.FoodItem

interface PedidoRepository {

    suspend fun addPedido(pedido: FoodItem, quantity: Int)
    suspend fun getPedidos(): List<FoodItem>
    suspend fun clearPedidos()

 //   fun getAllPedidos(): Flow<List<FoodItem>>
//    suspend fun getPedidoById(id: String): FoodItem?
//    suspend fun insertPedido(foodItem: FoodItem)
//    suspend fun deletePedido(foodItem: FoodItem)
//    suspend fun updatePedido(foodItem: FoodItem)
}