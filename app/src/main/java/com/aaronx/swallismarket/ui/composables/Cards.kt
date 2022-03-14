package com.aaronx.swallismarket.ui.composables

import SwalisMarketTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.aaronx.swallismarket.R
import com.aaronx.swallismarket.data.CartItem
import com.aaronx.swallismarket.data.Order
import com.aaronx.swallismarket.data.Product
import com.aaronx.swallismarket.ui.theme.IconColor
import com.aaronx.swallismarket.ui.theme.SurfaceColor

@Composable
fun ProductCard(product: Product, onClick: () -> Unit){
    val imagePainter = rememberImagePainter(R.drawable.profile_pic)
    Column(modifier = Modifier
        .padding(all = 4.dp)
        .clip(MaterialTheme.shapes.small)
        .background(MaterialTheme.colors.SurfaceColor)
        .clickable { onClick() } ){

        Image(painter = imagePainter
            , modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
                .aspectRatio(1F)
                .clip(MaterialTheme.shapes.small)
            , contentScale = ContentScale.Crop
            , contentDescription = "product image")

        Row(modifier = Modifier
            .padding(top = 4.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            Text(text = "${product.price} DZD",
                color = MaterialTheme.colors.IconColor)
            ButtonIcon(icon = R.drawable.ic_bag_2
                ,modifier = Modifier
                    .size(45.dp)
                    .background(MaterialTheme.colors.primary, MaterialTheme.shapes.small)
                , onClick = {})
        }
    }
}

@Composable
fun CartItemCard(cartItem: CartItem){
    val imagePainter = rememberImagePainter(R.drawable.profile_pic)
    val counter = rememberSaveable{ mutableStateOf(1) }

    Column(modifier = Modifier
        .padding(all = 4.dp)
        .clip(MaterialTheme.shapes.small)
        .background(MaterialTheme.colors.SurfaceColor) ){

        Row(modifier = Modifier.fillMaxWidth()
            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceBetween) {

            Image(painter = imagePainter
                , modifier = Modifier
                    .padding(all = 8.dp)
                    .height(130.dp)
                    .aspectRatio(1F)
                    .clip(MaterialTheme.shapes.small)
                , contentScale = ContentScale.Crop
                , contentDescription = "product image")

            Column(modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
                , horizontalAlignment = Alignment.Start) {

                Text(text = cartItem.name,
                    color = MaterialTheme.colors.IconColor,
                    modifier = Modifier.padding(vertical = 4.dp))

                Text(text = "Price: ${cartItem.price} DZD",
                    color = MaterialTheme.colors.IconColor,
                    modifier = Modifier.padding(vertical = 4.dp))

                Text(text = "Quantity",
                    color = MaterialTheme.colors.IconColor,
                    modifier = Modifier.padding(top = 4.dp, bottom = 8.dp))

                CounterModifier(count = counter.value,
                    onCountChange = { counter.value = if (it >= 1) it else 1 })
            }

        }
    }
}

@Composable
fun CounterModifier(count: Int, onCountChange: (Int) -> Unit){

    Row (modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight()
        , verticalAlignment = Alignment.CenterVertically) {

        ButtonIcon(icon = R.drawable.ic_add_circle
                ,modifier = Modifier
                .defaultMinSize(40.dp, 40.dp)
                .size(40.dp)
                .background(MaterialTheme.colors.primary, MaterialTheme.shapes.small)
                , onClick = { onCountChange(count + 1) })

        Text(text = count.toString(), color = MaterialTheme.colors.IconColor
            , modifier = Modifier.padding(horizontal = 16.dp))

        ButtonIcon(icon = R.drawable.ic_minus
            ,modifier = Modifier
                .defaultMinSize(40.dp, 40.dp)
                .size(40.dp)
                .background(MaterialTheme.colors.primary, MaterialTheme.shapes.small)
            , onClick = { onCountChange(count - 1) })
    }

}

@Composable
fun OrderCard(order: Order){
    Row(modifier = Modifier
        .padding(all = 4.dp)
        .clip(MaterialTheme.shapes.small)
        .background(MaterialTheme.colors.SurfaceColor)
        , verticalAlignment = Alignment.CenterVertically) {

        Image(painter = painterResource(id = R.drawable.ic_orders)
            , colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
            , contentDescription = "order icon"
            , modifier = Modifier.padding(8.dp).size(35.dp))

        Column(modifier = Modifier.padding(vertical = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()) {

            Text(text = order.orderDate, color = MaterialTheme.colors.IconColor)
            Text(text = order.state, color = MaterialTheme.colors.IconColor)
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun ProductItemPreview(){
    val cartItem = CartItem("name", 1200.0, 10, "")
    SwalisMarketTheme {
        CartItemCard(cartItem = cartItem)
    }

}