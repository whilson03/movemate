package com.olabode.wilson.moniepointassessment.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.olabode.wilson.moniepointassessment.R
import com.olabode.wilson.moniepointassessment.ui.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoveMateCenterAppBar(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colors.primary,
            titleContentColor = White,
        ),
        title = {
            Text(
                title,
                style = MaterialTheme.typography
                    .body1
                    .copy(fontWeight = FontWeight.SemiBold, color = White)
            )
        },
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    painterResource(id = R.drawable.ic_chevron_left),
                    contentDescription = null,
                    tint = White
                )
            }
        }
    )
}