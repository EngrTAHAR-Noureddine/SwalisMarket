package com.aaronx.swallismarket.data

data class Order(
    var orderDate: String = "",
    var state: String = "",
    var idUser: String = "",
    var idArtisan: String = "",
    var nameProduct: String = "",
    var pictureProduct : String = "",
    var priceProduct : Double = 0.0,
    var quantity : Int = 0,
    var idOrder: String = ""
)
