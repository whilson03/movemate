package com.olabode.wilson.moniepointassessment.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olabode.wilson.moniepointassessment.ui.theme.Orange600
import com.olabode.wilson.moniepointassessment.ui.theme.White


@Composable
fun MoveMateButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Orange600,
            contentColor = White
        )

    ) {
        Text(text = text, modifier = Modifier.padding(8.dp), fontSize = 16.sp)
    }
}