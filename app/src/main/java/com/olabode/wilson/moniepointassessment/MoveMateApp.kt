package com.olabode.wilson.moniepointassessment

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.olabode.wilson.moniepointassessment.navigation.MoveMateBottomBar
import com.olabode.wilson.moniepointassessment.navigation.MoveMateNavigation
import com.olabode.wilson.moniepointassessment.ui.rememberMoveMateAppState
import com.olabode.wilson.moniepointassessment.ui.theme.MoveMateTheme


@Composable
fun MoveMateApp() {
    MoveMateTheme {
        val appState = rememberMoveMateAppState()
        Scaffold(
            bottomBar = {
                if (appState.shouldShowBottomBar) {
                    MoveMateBottomBar(
                        items = appState.bottomBarTabs,
                        currentRoute = appState.currentRoute!!,
                        navigateToRoute = appState::navigateToBottomBarRoute
                    )
                }
            }
        ) { paddingValues ->
            MoveMateNavigation(
                navController = appState.navController,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}
