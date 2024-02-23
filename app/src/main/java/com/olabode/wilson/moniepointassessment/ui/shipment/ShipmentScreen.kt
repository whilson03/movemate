package com.olabode.wilson.moniepointassessment.ui.shipment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olabode.wilson.moniepointassessment.DetailState
import com.olabode.wilson.moniepointassessment.components.MoveMateCenterAppBar
import com.olabode.wilson.moniepointassessment.components.Section
import com.olabode.wilson.moniepointassessment.components.ShipmentCard
import com.olabode.wilson.moniepointassessment.components.SlideInUpContainer
import com.olabode.wilson.moniepointassessment.data.FakeShipmentDataSource
import com.olabode.wilson.moniepointassessment.models.ShipmentItem
import com.olabode.wilson.moniepointassessment.navigation.AnimatedAppBar
import com.olabode.wilson.moniepointassessment.ui.theme.OffWhite
import com.olabode.wilson.moniepointassessment.ui.theme.Orange600
import com.olabode.wilson.moniepointassessment.ui.theme.Transluscent
import com.olabode.wilson.moniepointassessment.ui.theme.White

@Composable
fun ShipmentScreen(modifier: Modifier = Modifier, onBackClicked: () -> Unit) {
    ShipmentScreenContent(
        modifier = modifier,
        onBackClicked = onBackClicked
    )
}


@Composable
private fun ShipmentScreenContent(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit
) {
    var tabIndex by remember { mutableIntStateOf(0) }
    val shipment by remember { mutableStateOf(FakeShipmentDataSource.shipments) }


    val tabs = listOf(
        ShipmentTabs.ALL,
        ShipmentTabs.IN_PROGRESS,
        ShipmentTabs.PENDING,
        ShipmentTabs.CANCELED,
        ShipmentTabs.COMPLETED
    )

    var currentState by remember { mutableStateOf(DetailState.INVISIBLE) }
    LaunchedEffect(key1 = currentState) {
        currentState = DetailState.VISIBLE
    }

    Scaffold(
        backgroundColor = OffWhite,
        topBar = {
            AnimatedAppBar(currentState = currentState) {
                Column(Modifier.fillMaxWidth()) {
                    MoveMateCenterAppBar(title = "Shipment history", onClick = onBackClicked)
                    ShipmentTabContainer(
                        selectedTabIndex = tabIndex,
                        tabs = tabs,
                        shipments = shipment,
                        onClick = {
                            tabIndex = it
                            currentState = DetailState.INVISIBLE
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        SlideInUpContainer(
            currentState == DetailState.VISIBLE
        ) {
            ShipmentList(
                modifier = Modifier.padding(paddingValues),
                shipments = shipment.filterByTab(tabs[tabIndex])
            )
        }
    }
}

@Composable
fun ShipmentTabContainer(
    modifier: Modifier = Modifier,
    selectedTabIndex: Int,
    shipments: List<ShipmentItem>,
    tabs: List<ShipmentTabs>,
    onClick: (Int) -> Unit
) {
    ScrollableTabRow(
        modifier = modifier,
        selectedTabIndex = selectedTabIndex,
        edgePadding = 16.dp,
        indicator = { tabPositions ->
            Box(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabIndex])
                    .height(4.dp)
                    .background(Orange600)
            )
        }
    ) {
        // Create tabs dynamically based on your data
        tabs.forEachIndexed { index, item ->
            Tab(modifier = Modifier.padding(4.dp),
                selected = selectedTabIndex == index,
                onClick = { onClick(index) }
            ) {
                Row(
                    Modifier.padding(bottom = 8.dp, start = 8.dp, end = 8.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = item.title,
                        color = White
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Badge(
                        count = shipments.filterByTab(item).size,
                        color = if (selectedTabIndex == index) Orange600 else Transluscent.copy(
                            alpha = 0.3f
                        )
                    )
                }
            }
        }
    }
}


@Composable
fun Badge(count: Int, color: Color) {
    Text(
        modifier = Modifier
            .padding(4.dp)
            .background(color, CircleShape)
            .padding(horizontal = 6.dp, vertical = 1.dp),
        text = count.toString(),
        color = Color.White,
        fontSize = 12.sp
    )
}


@Composable
private fun ShipmentList(
    modifier: Modifier = Modifier,
    shipments: List<ShipmentItem>
) {
    LazyColumn(
        modifier = modifier,
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Section(header = "Shipment") {}
        }

        items(shipments) {
            ShipmentCard(
                modifier = Modifier, shipmentItem = it
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

enum class ShipmentTabs(val title: String) {
    ALL("All"),
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    CANCELED("Canceled")
}

private fun List<ShipmentItem>.filterByTab(tab: ShipmentTabs): List<ShipmentItem> {
    return when (tab) {
        ShipmentTabs.ALL -> this
        else -> this.filter { it.status.name == tab.name }
    }
}

@Preview
@Composable
fun PreviewShipmentContent() {
    ShipmentScreenContent() {

    }
}