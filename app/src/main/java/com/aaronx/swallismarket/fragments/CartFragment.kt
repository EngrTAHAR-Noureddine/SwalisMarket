package com.aaronx.swallismarket.fragments


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aaronx.swallismarket.R
import com.aaronx.swallismarket.data.CartItem
import com.aaronx.swallismarket.ui.composables.CartItemCard
import com.aaronx.swallismarket.ui.composables.EmButton

@Composable
fun CartFragment(){
    val cartItem = CartItem("name", 1200.0, 10, "")
    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.End) {

        LazyColumn(modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 8.dp)
            .fillMaxWidth()
            .weight(1F)){

            items(20){
                CartItemCard(cartItem = cartItem)
            }
        }

        EmButton(onClick = {},
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