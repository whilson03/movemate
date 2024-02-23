package com.olabode.wilson.moniepointassessment.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olabode.wilson.moniepointassessment.R
import com.olabode.wilson.moniepointassessment.ui.theme.Green100
import com.olabode.wilson.moniepointassessment.ui.theme.LightGrey100
import com.olabode.wilson.moniepointassessment.ui.theme.Orange600


@Composable
fun TrackingCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                TopSection()
                Spacer(modifier = Modifier.height(16.dp))
                MoveMateDivider(color = LightGrey100)
                Spacer(modifier = Modifier.height(16.dp))
                MiddleSection()
                Spacer(modifier = Modifier.height(16.dp))
            }

            MoveMateDivider(color = LightGrey100)
            TextButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 4.dp),
                onClick = { }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add", tint = Orange600)
                Text(text = "Add Stop", color = Orange600)
            }
        }
    }
}


@Composable
private fun TopSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Shipment Number",
                color = Color.Gray,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "NEJ2000892849",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                style = MaterialTheme.typography.subtitle1
            )
        }

        Image(painter = painterResource(id = R.drawable.ic_forklift), contentDescription = null)
    }
}


@Composable
fun MiddleSection(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            TrackingMenuItem(
                header = "Sender",
                content = "Atlanta, 5243",
                leadingIcon = painterResource(id = R.drawable.ic_send)
            )
            Spacer(modifier = Modifier.height(32.dp))
            TrackingMenuItem(
                header = "Receiver",
                content = "Chicago, 5846",
                leadingIcon = painterResource(id = R.drawable.ic_receive)
            )
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            TrackingMenuItem(
                header = "Time",
                content = "2 days - 3 days",
                statusIcon = painterResource(
                    id = R.drawable.ic_dot_separator
                )
            )
            Spacer(modifier = Modifier.height(32.dp))
            TrackingMenuItem(header = "Status", content = "Waiting to Collect")
        }
    }
}


@Composable
private fun TrackingMenuItem(
    modifier: Modifier = Modifier,
    leadingIcon: Painter? = null,
    statusIcon: Painter? = null,
    header: String,
    content: String
) {
    Row(modifier = modifier.wrapContentSize(), verticalAlignment = Alignment.CenterVertically) {
        leadingIcon?.let {
            Image(painter = leadingIcon, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
        }
        Column {
            Text(
                text = header,
                color = Color.Gray,
                fontSize = 14.sp,
                style = MaterialTheme.typography.subtitle2
            )
            if (statusIcon != null) {
                Row(Modifier.wrapContentWidth(), verticalAlignment = Alignment.CenterVertically) {
                    SeparatorIcon(color = Green100)
                    Text(
                        text = content,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            } else {
                Text(
                    text = content,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewTrackingCard() {
    TrackingCard()
}