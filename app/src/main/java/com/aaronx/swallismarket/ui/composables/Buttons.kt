package com.aaronx.swallismarket.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aaronx.swallismarket.R

@Composable
fun ButtonIcon(icon: Int,modifier: Modifier = Modifier, onClick: ()-> Unit){
    Box(modifier = modifier
        .clip(MaterialTheme.shapes.small)
        .clickable { onClick() }
        , contentAlignment = Alignment.Center){

        Image(painter = painterResource(id = icon)
            , contentDescription = "icon button"
            , modifier = Modifier.size(25.dp))
    }
}

@Composable
fun EmButton(modifier: Modifier = Modifier
             , icon: Int = R.drawable.ic_empty_wallet
             , text: String = ""
             , onClick: () -> Unit){

    Row(verticalAlignment = Alignment.CenterVertically
        , modifier = modifier
            .background(MaterialTheme.colors.primary
            , MaterialTheme.shapes.small)
            .clip(MaterialTheme.shapes.small)
            .clickable { onClick() }
            .padding(horizontal = 16.dp)){

        Icon(painter = painterResource(id = icon)
            , contentDescription = "button icon"
            , modifier = Modifier.padding(end = 8.dp).size(25.dp))
        Text(text = text)
    }
}