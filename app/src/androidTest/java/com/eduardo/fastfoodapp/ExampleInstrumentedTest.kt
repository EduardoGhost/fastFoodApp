package com.eduardo.fastfoodapp

import com.eduardo.fastfoodapp.data.repository.PedidoRepository
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.times

class ExampleUnitTest {

    interface Service : PedidoRepository {
        fun performAction()
    }

    @Test
    fun mockitoIsWorking() {

        val mockService = mock(Service::class.java)

        mockService.performAction()

        verify(mockService, times(1)).performAction()
    }
}