package com.eduardo.fastfoodapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eduardo.fastfoodapp.data.entities.HistoricoPedidoEntity

@Dao
interface HistoricoPedidoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoricoPedido(historicoPedido: HistoricoPedidoEntity)

    @Query("SELECT * FROM historico_pedido")
    suspend fun getAllHistoricoPedidos(): List<HistoricoPedidoEntity>
}