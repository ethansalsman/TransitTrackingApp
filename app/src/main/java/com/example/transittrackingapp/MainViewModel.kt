package com.example.transittrackingapp

import androidx.compose.ui.layout.LayoutCoordinates
import androidx.lifecycle.ViewModel
import com.google.transit.realtime.GtfsRealtime
import java.net.URL

class MainViewModel : ViewModel() {

    fun loadBusPositions() {
        Thread {
            val url = URL("https://gtfs.halifax.ca/realtime/Vehicle/VehiclePositions.pb")
            val feed = GtfsRealtime.FeedMessage.parseFrom(url.openStream())

            // rest of code goes here
        }.start()
    }
}
