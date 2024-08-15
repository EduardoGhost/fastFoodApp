package com.eduardo.fastfoodapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PedidoEntity::class, HistoricoPedidoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pedidoDao(): PedidoDao
    abstract fun historicoPedidoDao(): HistoricoPedidoDao
}
