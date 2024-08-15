package com.eduardo.fastfoodapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoricoPedidoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoricoPedido(historicoPedido: HistoricoPedidoEntity)

    @Query("SELECT * FROM historico_pedido")
    fun getAllHistoricoPedidos(): List<HistoricoPedidoEntity>
}