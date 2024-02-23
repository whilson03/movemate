package com.olabode.wilson.moniepointassessment.ui.calculate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olabode.wilson.moniepointassessment.DetailState
import com.olabode.wilson.moniepointassessment.R
import com.olabode.wilson.moniepointassessment.components.FadeIn
import com.olabode.wilson.moniepointassessment.components.MoveMateButton
import com.olabode.wilson.moniepointassessment.components.MoveMateCenterAppBar
import com.olabode.wilson.moniepointassessment.components.MoveMateInputField
import com.olabode.wilson.moniepointassessment.components.Section
import com.olabode.wilson.moniepointassessment.components.SlideInHorizontalRTL
import com.olabode.wilson.moniepointassessment.components.SlideInUpContainer
import com.olabode.wilson.moniepointassessment.navigation.AnimatedAppBar
import com.olabode.wilson.moniepointassessment.ui.theme.Black
import com.olabode.wilson.moniepointassessment.ui.theme.Blue300
import com.olabode.wilson.moniepointassessment.ui.theme.OffWhite
import com.olabode.wilson.moniepointassessment.ui.theme.White

@Composable
fun CalculateScreen(
    modifier: Modifier = Modifier,
    onCalculateClicked: () -> Unit,
    onBackClicked: () -> Unit
) {
    CalculateScreenContent(
        modifier = modifier,
        onCalculateClicked = onCalculateClicked,
        onBackClicked = onBackClicked
    )
}

@Composable
fun CalculateScreenContent(
    modifier: Modifier = Modifier,
    onCalculateClicked: () -> Unit,
    onBackClicked: () -> Unit
) {
    var currentState by remember { mutableStateOf(DetailState.INVISIBLE) }

    LaunchedEffect(key1 = currentState) {
        currentState = DetailState.VISIBLE
    }
    Scaffold(
        containerColor = OffWhite,
        topBar = {
            AnimatedAppBar(currentState = currentState) {
                MoveMateCenterAppBar(title = "Calculate", onClick = onBackClicked)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .then(modifier)
            ) {
                item {
                    SlideInUpContainer(currentState == DetailState.VISIBLE) {
                        Section(modifier = Modifier, header = "Destination") {
                            DestinationCard()
                        }
                    }
                }

                item {
                    SlideInUpContainer(currentState == DetailState.VISIBLE) {
                        Section(
                            modifier = Modifier,
                            header = "Packaging",
                            subtitle = "What are you sending?"
                        ) {
                            PackagingContainer()
                        }
                    }
                }


                item {
                    Section(
                        modifier = Modifier,
                        header = "Categories",
                        subtitle = "What are you sending?"
                    ) {
                        SlideInUpContainer(
                            currentState == DetailState.VISIBLE,
                            enter = FadeIn + SlideInHorizontalRTL
                        ) {
                            CategoriesSection()
                        }
                    }
                }
            }

            MoveMateButton(
                text = "Calculate",
                modifier = Modifier.padding(16.dp),
                onClick = onCalculateClicked
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoriesSection(modifier: Modifier = Modifier) {
    val categories = listOf(
        "Documents", "Glass", "Liquid", "Food", "Electronic", "Product", "Others"
    )
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        categories.forEach { word ->
            ChipItem(word)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipItem(value: String) {
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text(value, color = if (selected) White else Black)
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0xFF082140),
            selectedLeadingIconColor = Color.White
        )
    )
}


@Composable
fun DestinationCard(modifier: Modifier = Modifier) {
    val sender = remember { mutableStateOf("") }
    val receiver = remember { mutableStateOf("") }
    val weight = remember { mutableStateOf("") }

    Card(
        modifier = modifier, shape = RoundedCornerShape(16.dp), elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MoveMateInputField(
                hint = "Sender Location",
                value = sender.value,
                vectorImageId = R.drawable.ic_send_package,
                onInputChanged = { sender.value = it }
            )
            MoveMateInputField(
                hint = "Receiver Location",
                value = receiver.value,
                vectorImageId = R.drawable.ic_receive_package,
                onInputChanged = { receiver.value = it }
            )
            MoveMateInputField(
                hint = "Approx weight",
                vectorImageId = R.drawable.ic_weigh_package,
                value = weight.value,
                onInputChanged = { weight.value = it }
            )
        }
    }
}

@Composable
fun PackagingContainer(modifier: Modifier = Modifier) {
    Card(modifier = modifier, elevation = 0.5.dp, shape = RoundedCornerShape(10.dp)) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_box_package),
                    contentDescription = null,
                    tint = Color.Gray
                )

                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .height(25.dp)
                        .background(Color.LightGray)
                )
            }
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                text = "Box",
                style = MaterialTheme.typography.subtitle2.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = Blue300,
                    fontSize = 20.sp
                )
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_expand),
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}
