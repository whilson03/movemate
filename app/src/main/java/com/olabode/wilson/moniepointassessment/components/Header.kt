package com.olabode.wilson.moniepointassessment.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Header(
    modifier: Modifier = Modifier,
    text: String,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.subtitle2.copy(
            color = color,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
    )
}


@Composable
fun SubHeader(
    modifier: Modifier = Modifier,
    text: String,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.caption.copy(
            color = color,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500
        )
    )
}