package com.aaronx.swallismarket.fragments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.aaronx.swallismarket.data.Order
import com.aaronx.swallismarket.firebase.FirebaseController
import com.aaronx.swallismarket.ui.composables.OrderCard

@Composable
fun OrdersFragment(){
    FirebaseController.getListOrders(LocalContext.current)
    val orders = FirebaseController.getOrders().observeAsState()
    val order = Order("20-09-2022", "Delivered")

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.padding(all = 4.dp)){

            if(orders.value != null){
                items(orders.value!!){
                    OrderCard(order = it)
                }
            }


            item {
                Spacer(modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth())
            }
        }
    }
}