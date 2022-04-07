package com.mmajka.nerbydoctor.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.Black
    ),
    h1 = TextStyle(
        fontSize = 27.sp,
        lineHeight = 31.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
    ),
    h2 = TextStyle(
        fontSize = 24.sp,
        lineHeight = 28.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    ),
    h3 = TextStyle(
        fontSize = 24.sp,
        lineHeight = 28.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
    ),
    subtitle1 = TextStyle(
        fontSize = 15.sp,
        lineHeight = 18.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        color = Color.Gray
    ),
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color.Black
    )
)