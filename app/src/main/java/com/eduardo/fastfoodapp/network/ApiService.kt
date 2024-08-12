package com.eduardo.fastfoodapp.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/pagination")
    suspend fun getPaginationData(): Response<Map<String, Int>>
}

//data class Menu(
//    val id: String,
//    val name: String,
//)
