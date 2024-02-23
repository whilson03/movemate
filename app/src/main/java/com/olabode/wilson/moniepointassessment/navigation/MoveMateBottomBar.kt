package com.olabode.wilson.moniepointassessment.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olabode.wilson.moniepointassessment.components.SlideInUpContainer
import com.olabode.wilson.moniepointassessment.ui.theme.BottomNavUnselectedColor
import com.olabode.wilson.moniepointassessment.ui.theme.Orange600
import com.olabode.wilson.moniepointassessment.ui.theme.Purple700


@Composable
fun MoveMateBottomBar(
    modifier: Modifier = Modifier,
    items: Array<BottomNavigationItem>,
    currentRoute: String,
    navigateToRoute: (String) -> Unit,
) {
    SlideInUpContainer(currentRoute == BottomNavigationItem.HOME.route) {
        BottomNavigation(
            modifier = modifier,
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                items.forEach { item ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (item.route == currentRoute) {
                            Box(
                                Modifier
                                    .height(4.dp)
                                    .width(100.dp)
                                    .background(Purple700)
                            )
                        }

                        this@BottomNavigation.BottomNavigationItem(
                            selected = item.route == currentRoute,
                            onClick = { navigateToRoute(item.route) },
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = stringResource(id = item.title)
                                )
                            },
                            label = {
                                Text(
                                    stringResource(id = item.title),
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 10.sp
                                )
                            },
                            selectedContentColor = MaterialTheme.colors.primary,
                            unselectedContentColor = BottomNavUnselectedColor,
                            alwaysShowLabel = false
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun BottomBarIndicator() {
    Box(
        Modifier
            .height(4.dp)
            .width(100.dp)
            .background(Orange600)
    )
}

@Preview
@Composable
fun PreviewBottomNavigationBar() {
    val bottomBarTabs = BottomNavigationItem.entries.toTypedArray()

    BottomBarIndicator()
}
