package com.olabode.wilson.moniepointassessment.models

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.olabode.wilson.moniepointassessment.R

data class ShipmentItem(
    val status: ShipmentStatus,
    val arrival: String,
    val date: String,
    val packageId: String,
    val location: String,
    val price: String,
    val key : Int
)


enum class ShipmentStatus(
    @DrawableRes val iconRes: Int,
    val title: String,
    @ColorRes val color : Int
) {
    IN_PROGRESS(R.drawable.ic_in_progress, "In Progress", R.color.blue),
    PENDING(R.drawable.ic_pending, "Pending", R.color.amber),
    CANCELED(R.drawable.ic_pending, "Cancelled", R.color.red),
    COMPLETED(R.drawable.ic_completed, "Completed", R.color.green)
}