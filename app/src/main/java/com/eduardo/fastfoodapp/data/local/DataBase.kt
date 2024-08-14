package com.eduardo.fastfoodapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PedidoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pedidoDao(): PedidoDao
}
