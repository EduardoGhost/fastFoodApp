package com.eduardo.fastfoodapp.data.local

import com.eduardo.fastfoodapp.data.dao.HistoricoPedidoDao
import com.eduardo.fastfoodapp.data.dao.PedidoDao
import com.eduardo.fastfoodapp.data.local.HistoricoPedidoRepositoryImpl
import com.eduardo.fastfoodapp.data.local.PedidoRepositoryImpl
import com.eduardo.fastfoodapp.data.repository.HistoricoPedidoRepository
import com.eduardo.fastfoodapp.data.repository.PedidoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providePedidoRepository(
        pedidoDao: PedidoDao
    ): PedidoRepository {
        return PedidoRepositoryImpl(pedidoDao)
    }

    @Provides
    fun provideHistoricoPedidoRepository(
        historicoPedidoDao: HistoricoPedidoDao
    ): HistoricoPedidoRepository {
        return HistoricoPedidoRepositoryImpl(historicoPedidoDao)
    }
}


