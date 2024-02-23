package com.olabode.wilson.moniepointassessment.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olabode.wilson.moniepointassessment.R
import com.olabode.wilson.moniepointassessment.data.FakeShipmentDataSource
import com.olabode.wilson.moniepointassessment.models.ShipmentItem
import com.olabode.wilson.moniepointassessment.models.ShipmentStatus
import com.olabode.wilson.moniepointassessment.ui.theme.LightGrey100
import com.olabode.wilson.moniepointassessment.ui.theme.LightGrey300
import com.olabode.wilson.moniepointassessment.ui.theme.Purple


@Composable
fun ShipmentCard(modifier: Modifier = Modifier, shipmentItem: ShipmentItem) {
    Card(modifier = modifier, elevation = 0.dp, shape = RoundedCornerShape(16.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            StatusItem(status = shipmentItem.status)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(
                        text = shipmentItem.arrival,
                        style = MaterialTheme.typography.subtitle1.copy(
                            fontSize = 18.sp
                        ),
                        fontWeight = FontWeight.SemiBold,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Your delivery ${shipmentItem.packageId}",
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Gray
                    )
                    Text(
                        text = "from ${shipmentItem.location} is ${shipmentItem.arrival}",
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Gray
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_box_package),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp),
                    tint = Color.Gray
                )
            }
            BottomDetailsContainer(Modifier, shipmentItem)
        }
    }
}

@Composable
private fun BottomDetailsContainer(modifier: Modifier = Modifier, shipmentItem: ShipmentItem) {
    Row(
        modifier = modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "$${shipmentItem.price} USD",
            color = Purple,
            style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.SemiBold)
        )

        SeparatorIcon(Modifier.padding(horizontal = 2.dp), color = LightGrey300)

        Text(
            text = shipmentItem.date,
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Medium
            ),
            color = Color.DarkGray
        )
    }
}


@Composable
private fun StatusItem(modifier: Modifier = Modifier, status: ShipmentStatus) {
    Row(
        modifier = modifier
            .wrapContentWidth()
            .background(LightGrey100, RoundedCornerShape(20.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(
            painter = painterResource(id = status.iconRes),
            tint = colorResource(id = status.color),
            contentDescription = status.title
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = status.title,
            color = colorResource(id = status.color),
            style = MaterialTheme.typography.caption.copy(
                fontWeight = FontWeight.Medium
            ),
        )
    }
}


@Preview
@Composable
fun PreviewShipmentCard() {
    Box(Modifier.padding(8.dp)) {
        ShipmentCard(Modifier, FakeShipmentDataSource.shipments.first())
    }
}