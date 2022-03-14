package com.aaronx.swallismarket.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.aaronx.swallismarket.data.User
import com.aaronx.swallismarket.ui.composables.EmButton
import com.aaronx.swallismarket.ui.theme.IconColor
import com.aaronx.swallismarket.ui.theme.SurfaceColor

@Composable
fun ProfileFragment(){
    val painter = rememberImagePainter(R.drawable.profile_pic)
    val mainProfile = User("Aaron"
        , "Nerox"
        , "Passcode"
        , ""
        ,"hh_kechaoui@esi.dz"
        , "09-09-1999"
        , "Blida, Algeria"
        , "0550505000")

    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painter
            , contentDescription = "profile picture"
            , contentScale = ContentScale.Crop
            , modifier = Modifier
                .padding(all = 16.dp)
                .size(140.dp)
                .clip(CircleShape)
                .border(4.dp, MaterialTheme.colors.SurfaceColor, CircleShape))

        Text(text = "${mainProfile.name} ${mainProfile.surname}"
            , color = MaterialTheme.colors.IconColor
            , fontWeight = FontWeight.Bold
            , fontSize = 24.sp
            , modifier = Modifier.padding(16.dp))

        Text(text = mainProfile.email
            , color = MaterialTheme.colors.IconColor
            , fontWeight = FontWeight.SemiBold
            , fontSize = 20.sp
            , modifier = Modifier.padding(8.dp))

        Text(text = mainProfile.birthdate
            , color = MaterialTheme.colors.IconColor
            , modifier = Modifier.padding(8.dp))

        Text(text = mainProfile.address
            , color = MaterialTheme.colors.IconColor
            , modifier = Modifier.padding(8.dp))

        Text(text = mainProfile.phone
            , color = MaterialTheme.colors.IconColor
            , modifier = Modifier.padding(8.dp))

        EmButton(onClick = {},
            modifier = Modifier
                .padding(all = 16.dp)
                .height(55.dp)
                .wrapContentWidth()
            , icon = R.drawable.ic_profile
            , text = "Logout")


    }
}