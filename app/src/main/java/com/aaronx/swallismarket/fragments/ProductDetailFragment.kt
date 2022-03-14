package com.aaronx.swallismarket.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.aaronx.swallismarket.R
import com.aaronx.swallismarket.data.Product
import com.aaronx.swallismarket.ui.composables.EmButton
import com.aaronx.swallismarket.ui.theme.IconColor


@Composable
fun ProductDetailFragment(){
    val painter = rememberImagePainter(R.drawable.profile_pic)
    val product = Product(name = "hhhh", price = 1200.0, picture = "hello there")

    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.Start) {

        Image(painter = painter
            , contentDescription = ""
            , contentScale = ContentScale.Crop
            , modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(200.dp)
                .clip(MaterialTheme.shapes.small))

        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            , horizontalArrangement = Arrangement.SpaceBetween){

            Text(text = product.name
                , color = MaterialTheme.colors.IconColor
                , modifier = Modifier
                    .padding(8.dp)
                , fontSize = 24.sp
                , fontWeight = FontWeight.Bold)

            Text(text = "${product.price} DZD"
                , color = MaterialTheme.colors.IconColor
                , modifier = Modifier
                    .padding(8.dp))
        }

        EmButton(onClick = {},
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                .height(55.dp)
                .wrapContentWidth()
            , icon = R.drawable.ic_empty_wallet
            , text = "Buy this product")

    }
}