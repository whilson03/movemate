package com.olabode.wilson.moniepointassessment.data

import com.olabode.wilson.moniepointassessment.models.ShipmentItem
import com.olabode.wilson.moniepointassessment.models.ShipmentStatus

object FakeShipmentDataSource {
    private val RANGE = 1..5

    private val inProgressShipments = (1..3).map {
        createShipmentItem(it, ShipmentStatus.IN_PROGRESS)
    }

    private val completedShipments = (4..6).map {
        createShipmentItem(it, ShipmentStatus.COMPLETED)
    }

    private val pendingShipments = (7..11).map {
        createShipmentItem(it, ShipmentStatus.PENDING)
    }

    private val cancelledShipments = (12..16).map {
        createShipmentItem(it, ShipmentStatus.CANCELED)
    }

    private fun createShipmentItem(it: Int, status: ShipmentStatus): ShipmentItem {
        return ShipmentItem(
            status = status,
            arrival = "Arriving today!",
            date = "Feb 20, 2023",
            packageId = "#NEJ200899341${it}231$it",
            location = "Atlanta",
            price = "${(100 * it) + 50}",
            key = it
        )
    }


    val shipments = completedShipments + inProgressShipments + pendingShipments + cancelledShipments

}