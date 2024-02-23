package com.olabode.wilson.moniepointassessment.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.olabode.wilson.moniepointassessment.ui.theme.Blue300


@Composable
fun Section(
    modifier: Modifier = Modifier,
    header: String,
    subtitle: String? = null,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Header(text = header, color = Blue300)
        if (subtitle != null) {
            SubHeader(text = subtitle, color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(8.dp))
        content()
    }
}