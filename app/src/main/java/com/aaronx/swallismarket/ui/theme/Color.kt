package com.aaronx.swallismarket.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color


val OceanAccent = Color(0xFFEADDFF)
val OceanBlue500 = Color(0xFFC6A3FF)
val OceanBlue700 = Color(0xFF7D69FC)
val RoyalBlack = Color(0xFF222222)

val Colors.SurfaceColor : Color
    get() = if(isLight)  Color(0xFFFFFFFF) else Color(0xFF333333)

val Colors.IconColor: Color
    get() = if(isLight) Color(0xFF222222) else Color(0xFFFFFFFF)