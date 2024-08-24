package com.eduardo.fastfoodapp.data.dao

import androidx.room.*
import com.eduardo.fastfoodapp.data.entities.PedidoEntity

@Dao
interface PedidoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPedido(pedido: PedidoEntity)

    @Query("SELECT * FROM pedido")
    suspend fun getAllPedidos(): List<PedidoEntity>

    @Query("DELETE FROM pedido")
    suspend fun clearPedidos()

    @Delete
    suspend fun deletePedido(pedido: PedidoEntity)
}


