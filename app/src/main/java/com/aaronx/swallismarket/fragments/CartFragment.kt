package com.aaronx.swallismarket.fragments


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.aaronx.swallismarket.R
import com.aaronx.swallismarket.data.CartItem
import com.aaronx.swallismarket.data.Order
import com.aaronx.swallismarket.firebase.FirebaseController
import com.aaronx.swallismarket.ui.composables.CartItemCard
import com.aaronx.swallismarket.ui.composables.EmButton
import java.util.*

@Composable
fun CartFragment(){
    val context = LocalContext.current
    val cartItem = CartItem("Séborégulateur", 110.0, 10, "")
    val cartItem2 = CartItem("Séborégulateur", 110.0, 10, "")
    val cartItem3 = CartItem("Séborégulateur", 110.0, 10, "")

    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.End) {

        LazyColumn(modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 8.dp)
            .fillMaxWidth()
            .weight(1F)){

            item{
                CartItemCard(cartItem = cartItem)
            }

            item{
                CartItemCard(cartItem = cartItem2)
            }

            item{
                CartItemCard(cartItem = cartItem3)
            }
        }

        EmButton(onClick = {
            FirebaseController.postOrder(orderTransformer(cartItem), context)
            FirebaseController.postOrder(orderTransformer(cartItem2), context)
            FirebaseController.postOrder(orderTransformer(cartItem3), context)
        },
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .height(55.dp)
                    .wrapContentWidth()
            , icon = R.drawable.ic_empty_wallet
            , text = "Checkout")

        Spacer(modifier = Modifier
            .height(80.dp)
            .fillMaxWidth())

    }
}

fun orderTransformer(cartItem: CartItem): Order {
    val order = Order(
        "16-3-2022",
        "In progress",
        "",
        "",
        cartItem.name,
        cartItem.picture,
        cartItem.price * cartItem.quantity,
        cartItem.quantity,
        UUID.randomUUID().toString()
    )

    return order
}