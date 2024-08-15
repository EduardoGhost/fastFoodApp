package com.eduardo.fastfoodapp

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eduardo.fastfoodapp.data.dao.PedidoDao
import com.eduardo.fastfoodapp.data.domain.FoodItem
import com.eduardo.fastfoodapp.data.local.AppDatabase
import com.eduardo.fastfoodapp.data.local.PedidoRepositoryImpl
import com.eduardo.fastfoodapp.data.repository.PedidoRepository
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PedidoRepositoryTest {

    private lateinit var database: AppDatabase
    private lateinit var repository: PedidoRepository

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
        repository = PedidoRepositoryImpl(database.pedidoDao())
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun testInsertAndGetPedido() = runBlocking {
        val pedido = FoodItem(
            id = "1",
            img = "https://goldbelly.imgix.net/uploads/showcase_media_asset/image/137148/Gramercy-Tavern-Burger-and-Kielbasa-Kit-6.4.21-72ppi-1x1-15.jpg?ixlib=react-9.0.2&auto=format&ar=1%3A1",
            name = "Gramercy Tavern", dsc = "The Gramercy Tavern Burger - 4 Pack", price = 10.0, rate = 2, country = "", quantity = 1)
        repository.addPedido(pedido, 1)
        val pedidos = repository.getPedidos()
        assertTrue(pedidos.contains(pedido))
    }
}

