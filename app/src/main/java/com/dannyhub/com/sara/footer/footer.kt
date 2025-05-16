package com.dannyhub.com.sara.footer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppFooter() {

    Text(
        text = "\"Lo que debe hacerse, requiere ser bien hecho.\"",
        color = Color.Black,
        fontSize = 13.sp,
        lineHeight = 18.sp,
        modifier = Modifier.padding(top = 16.dp)
    )

    Text(
        text = "E.S.E IMSALUD © V1.0 SARA MOVIL",
        fontSize = 12.sp,
        color = Color.Black
    )
}