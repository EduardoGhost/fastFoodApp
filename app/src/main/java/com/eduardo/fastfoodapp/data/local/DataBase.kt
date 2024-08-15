package com.eduardo.fastfoodapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eduardo.fastfoodapp.data.dao.HistoricoPedidoDao
import com.eduardo.fastfoodapp.data.dao.PedidoDao
import com.eduardo.fastfoodapp.data.entities.HistoricoPedidoEntity
import com.eduardo.fastfoodapp.data.entities.PedidoEntity

@Database(entities = [PedidoEntity::class, HistoricoPedidoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pedidoDao(): PedidoDao
    abstract fun historicoPedidoDao(): HistoricoPedidoDao
}
