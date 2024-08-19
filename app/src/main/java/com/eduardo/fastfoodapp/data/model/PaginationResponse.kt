package com.eduardo.fastfoodapp.data.model

import com.google.gson.annotations.SerializedName

data class PaginationResponse(
    @SerializedName("bbqs") val bbqs: Int,
    @SerializedName("best-foods") val bestFoods: Int,
    @SerializedName("breads") val breads: Int,
    @SerializedName("burgers") val burgers: Int,
    @SerializedName("chocolates") val chocolates: Int,
    @SerializedName("desserts") val desserts: Int,
    @SerializedName("drinks") val drinks: Int,
    @SerializedName("fried-chicken") val friedChicken: Int,
    @SerializedName("ice-cream") val iceCream: Int,
    @SerializedName("pizzas") val pizzas: Int,
    @SerializedName("porks") val porks: Int,
    @SerializedName("sandwiches") val sandwiches: Int,
    @SerializedName("sausages") val sausages: Int,
    @SerializedName("steaks") val steaks: Int
)