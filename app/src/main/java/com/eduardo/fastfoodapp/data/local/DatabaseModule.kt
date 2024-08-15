package com.eduardo.fastfoodapp.data.local

import android.content.Context
import androidx.room.Room
import com.eduardo.fastfoodapp.data.dao.HistoricoPedidoDao
import com.eduardo.fastfoodapp.data.dao.PedidoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun providePedidoDao(database: AppDatabase): PedidoDao {
        return database.pedidoDao()
    }

    @Provides
    fun provideHistoricoPedidoDao(database: AppDatabase): HistoricoPedidoDao {
        return database.historicoPedidoDao()
    }
}
