package com.eduardo.fastfoodapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historico_pedido")
data class HistoricoPedidoEntity(
    @PrimaryKey val pedidoId: String,
    val name: String,
    val price: Double,
    val quantity: Int,
    val total: Double,
  //  val dataCompra: Long // Timestamp
)
