package com.eduardo.fastfoodapp.data.local

import com.eduardo.fastfoodapp.data.model.FoodItem
import com.eduardo.fastfoodapp.data.entities.PedidoEntity

fun FoodItem.toEntity(quantity: Int): PedidoEntity = PedidoEntity(
    id = this.id,
    name = this.name,
    price = this.price,
    quantity = quantity
)

fun PedidoEntity.asExternalModel(): FoodItem = FoodItem(
    id = this.id,
    img = "",
    name = this.name,
    dsc = "",
    price = this.price,
    rate = 0,
    country = "",
    quantity = this.quantity
)
