package com.eduardo.fastfoodapp

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eduardo.fastfoodapp.data.model.FoodItem
import com.eduardo.fastfoodapp.data.local.AppDatabase
import com.eduardo.fastfoodapp.data.local.PedidoRepositoryImpl
import com.eduardo.fastfoodapp.data.repository.PedidoRepository
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlinx.coroutines.test.runTest
import org.junit.After

@RunWith(AndroidJUnit4::class)
class PedidoRepositoryTest2 {

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
    fun testInsertAndGetPedido() = runTest {
        // Arrange
        val foodItem = FoodItem(
            id = "whole-brisket-texas-bbq-sauce",
            img = "",
            name = "Franklin Barbecue",
            dsc = "",
            price = 249.0,
            rate = 0,
            country = "",
            quantity = 1
        )

        // Act
        repository.addPedido(foodItem, 1)
        val pedidos = repository.getPedidos()

        // Assert
        assertTrue(pedidos.any { it.id == foodItem.id })
    }
}
