package com.eduardo.fastfoodapp.data.local

import androidx.room.*

@Dao
interface PedidoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPedido(pedido: PedidoEntity)

    @Query("SELECT * FROM pedido")
    suspend fun getAllPedidos(): List<PedidoEntity>

    @Query("DELETE FROM pedido")
    suspend fun clearPedidos()
}

////    @Query("SELECT * FROM pedidos WHERE id = :id")
////    suspend fun getPedidoById(id: String): PedidoEntity?
////
////    @Delete
////    suspend fun deletePedido(pedido: PedidoEntity)
////
////    @Update
////    suspend fun updatePedido(pedido: PedidoEntity)


