package com.eduardo.fastfoodapp.data.local

import android.util.Log
import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.data.domain.PedidoRepository
import javax.inject.Inject

class PedidoRepositoryImpl @Inject constructor(
    private val pedidoDao: PedidoDao
) : PedidoRepository {

    override suspend fun addPedido(pedido: FoodItem, quantity: Int) {
        // Conversão FoodItem para PedidoEntity
        val pedidoEntity = pedido.toEntity(quantity)
        Log.d("PedidoRepository", "Inserting pedido: $pedidoEntity")
        pedidoDao.insertPedido(pedidoEntity)
    }

    override suspend fun getPedidos(): List<FoodItem> {
        val pedidos = pedidoDao.getAllPedidos().map { it.asExternalModel() }
        Log.d("PedidoRepository", "Fetched pedidos: $pedidos")
        return pedidoDao.getAllPedidos().map { it.asExternalModel() }
    }
}


