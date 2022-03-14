package com.aaronx.swallismarket.fragments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aaronx.swallismarket.data.Order
import com.aaronx.swallismarket.ui.composables.OrderCard

@Composable
fun OrdersFragment(){
    val order = Order("20-09-2022", "Delivered")

    Column {
        LazyColumn(modifier = Modifier.padding(all = 4.dp)){

            items(20){
                OrderCard(order = order)
            }

            item {
                Spacer(modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth())
            }
        }
    }
}