package com.eduardo.fastfoodapp.data.local

import android.util.Log
import com.eduardo.fastfoodapp.data.dao.HistoricoPedidoDao
import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.data.entities.HistoricoPedidoEntity
import com.eduardo.fastfoodapp.data.repository.HistoricoPedidoRepository
import javax.inject.Inject

class HistoricoPedidoRepositoryImpl @Inject constructor(
    private val historicoPedidoDao: HistoricoPedidoDao
) : HistoricoPedidoRepository {

    override suspend fun addPedidoToHistory(pedido: FoodItem) {
        val historicoPedidoEntity = HistoricoPedidoEntity(
            pedidoId = pedido.id,
            name = pedido.name,
            price = pedido.price,
            quantity = pedido.quantity,
            total = pedido.price * pedido.quantity,
            // dataCompra = System.currentTimeMillis() // implementar depois
        )
        historicoPedidoDao.insertHistoricoPedido(historicoPedidoEntity)
        Log.d("historicoRepository", "Inserting pedido no historico: $historicoPedidoEntity")
    }

    override suspend fun getAllHistoricoPedidos(): List<HistoricoPedidoEntity> {
        val pedidosHistorico = historicoPedidoDao.getAllHistoricoPedidos()
        Log.d("HistoricoRepository", "Fetched pedidos historico: $pedidosHistorico")

        return historicoPedidoDao.getAllHistoricoPedidos()
    }
}
