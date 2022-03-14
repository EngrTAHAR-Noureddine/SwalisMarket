package com.aaronx.swallismarket.data

data class CartItem(
    var name : String = "",
    var price : Double = 0.0,
    var quantity: Int = 0,
    var picture: String = ""
)