package com.eduardo.fastfoodapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pedido")
data class PedidoEntity(
    @PrimaryKey val id: String,
    val name: String,
    val price: Double,
    val quantity: Int
)
