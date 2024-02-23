package com.olabode.wilson.moniepointassessment.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.olabode.wilson.moniepointassessment.ui.calculate.CalculateScreen
import com.olabode.wilson.moniepointassessment.ui.home.HomeScreen
import com.olabode.wilson.moniepointassessment.ui.profile.ProfileScreen
import com.olabode.wilson.moniepointassessment.ui.shipment.ShipmentScreen
import com.olabode.wilson.moniepointassessment.ui.status.StatusScreen

private const val AnimationDuration = 700

@Composable
internal fun MoveMateNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = Screens.Home.route,
        route = "root",
        enterTransition = {
            fadeIn(animationSpec = tween(AnimationDuration)) +
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up,
                        tween(AnimationDuration)
                    )

        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Down,
                tween(300)
            ) + fadeOut()
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(AnimationDuration)) +
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up,
                        tween(AnimationDuration)
                    )
        }, popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Down,
                tween(300)
            ) + fadeOut()
        }
    ) {
        composable(route = Screens.Home.route) {
            HomeScreen()
        }

        composable(route = Screens.Calculate.route) {
            CalculateScreen(
                onCalculateClicked = {
                    navController.navigate(Screens.Status.route)
                },
                onBackClicked = {
                    navController.popBackStack()
                })
        }

        composable(route = Screens.Shipment.route) {
            ShipmentScreen {
                navController.popBackStack()
            }
        }

        composable(route = Screens.Status.route) {
            StatusScreen {
                navController.popBackStack(Screens.Home.route, false)
            }
        }

        composable(route = Screens.Profile.route) {
            ProfileScreen()
        }
    }
}
