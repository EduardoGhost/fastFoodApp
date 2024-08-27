package com.eduardo.fastfoodapp

import com.eduardo.fastfoodapp.data.model.FoodItem
import com.eduardo.fastfoodapp.data.repository.PedidoRepository
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlinx.coroutines.test.runTest
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.`when` as whenever


@RunWith(MockitoJUnitRunner::class)
class PedidoRepositoryTest {

    private lateinit var pedidoRepository: PedidoRepository

    @Before
    fun setUp() {
        pedidoRepository = mock(PedidoRepository::class.java)
    }

    @Test
    fun teste_addPedido() = runTest {
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
        val quantity = 1

        // Act
        pedidoRepository.addPedido(foodItem, quantity)

        // Assert
        verify(pedidoRepository).addPedido(foodItem, quantity)
    }

    @Test
    fun test_clearPedidos() = runTest {
        // Act
        pedidoRepository.clearPedidos()

        // Assert
        verify(pedidoRepository).clearPedidos()
    }

    @Test
    fun test_deletePedido() = runTest {
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
        pedidoRepository.deletePedido(foodItem)

        // Assert
        verify(pedidoRepository).deletePedido(foodItem)
    }

    @Test
    fun test_getPedidos() = runTest {
        // Arrange
        val foodItem1 = FoodItem(
            id = "whole-brisket-texas-bbq-sauce",
            img = "",
            name = "Franklin Barbecue",
            dsc = "",
            price = 249.0,
            rate = 0,
            country = "",
            quantity = 1
        )
        val foodItem2 = FoodItem(
            id = "005-kings-carolina-oink-sampler",
            img = "",
            name = "Kings BBQ",
            dsc = "",
            price = 89.0,
            rate = 0,
            country = "",
            quantity = 1

        )
        val expectedList = listOf(foodItem1, foodItem2)

        whenever(pedidoRepository.getPedidos()).thenReturn(expectedList)

        // Act
        val result = pedidoRepository.getPedidos()

        // Assert
        verify(pedidoRepository).getPedidos()
        assertEquals(expectedList, result)
    }
}
