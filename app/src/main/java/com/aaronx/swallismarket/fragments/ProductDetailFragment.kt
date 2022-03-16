package com.aaronx.swallismarket.fragments

import android.graphics.BitmapFactory
import android.util.Base64
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
import com.aaronx.swallismarket.firebase.FirebaseController
import com.aaronx.swallismarket.ui.composables.EmButton
import com.aaronx.swallismarket.ui.theme.IconColor


@Composable
fun ProductDetailFragment(id: String){

    val product = FirebaseController.getProducts().value?.find { it.idProduct == id }
    val imageBytes = Base64.decode(product?.picture, 0)
    val image = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    val painter = rememberImagePainter(image)


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

            Text(text = product?.name!!
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

        Text(text = "Ingredients"
            , color = MaterialTheme.colors.IconColor
            , modifier = Modifier
                .padding(8.dp)
            , fontSize = 24.sp
            , fontWeight = FontWeight.Bold)

        Text(text = "${product?.ingredients}"
            , color = MaterialTheme.colors.IconColor
            , modifier = Modifier
                .padding(8.dp))

        Text(text = "Description"
            , color = MaterialTheme.colors.IconColor
            , modifier = Modifier
                .padding(8.dp)
            , fontSize = 24.sp
            , fontWeight = FontWeight.Bold)

        Text(text = "${product?.description}"
            , color = MaterialTheme.colors.IconColor
            , modifier = Modifier
                .padding(8.dp))

        EmButton(onClick = {},
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                .height(55.dp)
                .wrapContentWidth()
            , icon = R.drawable.ic_empty_wallet
            , text = "Buy this product")

    }
}