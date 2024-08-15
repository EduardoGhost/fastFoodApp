package com.eduardo.fastfoodapp.data.local

import com.eduardo.fastfoodapp.data.domain.HistoricoPedidoRepository
import com.eduardo.fastfoodapp.data.domain.PedidoRepository
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


