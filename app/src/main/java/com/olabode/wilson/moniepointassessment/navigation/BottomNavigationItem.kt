package com.olabode.wilson.moniepointassessment.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.olabode.wilson.moniepointassessment.R

enum class BottomNavigationItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {
    HOME(R.string.home, R.drawable.ic_home, Screens.Home.route),
    CALCULATE(R.string.calculate, R.drawable.ic_calculate, Screens.Calculate.route),
    SHIPMENT(R.string.shipment, R.drawable.ic_shipment, Screens.Shipment.route),
    PROFILE(R.string.profile, R.drawable.ic_profile, Screens.Profile.route),
}
