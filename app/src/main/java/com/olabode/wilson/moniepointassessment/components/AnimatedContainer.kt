package com.olabode.wilson.moniepointassessment.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable

const val AnimationDuration = 600

val FadeIn = fadeIn(
    animationSpec = tween(AnimationDuration, easing = LinearEasing, delayMillis = 200)
)

val FadeOut = fadeOut(
    animationSpec = tween(AnimationDuration, easing = LinearEasing)
)


val SlideInVertical = slideInVertically(
    animationSpec = tween(AnimationDuration, easing = LinearEasing, delayMillis = 100),
    initialOffsetY = { it / 2 }
)

val SlideOutVertical = slideOutVertically(
    animationSpec = tween(AnimationDuration, easing = LinearOutSlowInEasing, delayMillis = 100)
)

val SlideInHorizontalRTL = slideInHorizontally(
    animationSpec = tween(AnimationDuration, easing = LinearEasing),
    initialOffsetX = { it / 2 }
)


@Composable
fun SlideInUpContainer(
    visible: Boolean = false,
    enter: EnterTransition = FadeIn + SlideInVertical,
    exitTransition: ExitTransition = FadeOut + SlideOutVertical,
    content: @Composable () -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        enter = enter,
        exit = exitTransition
    ) {
        content()
    }
}