package com.example.transittrackingapp

import android.util.Log
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
            for (entity in feed.entityList){
                if(entity.hasVehicle()){
                    // vehicle
                    val vehiclePosition = entity.vehicle
                    // route
                    val routeName = vehiclePosition.trip.routeId
                    // latitude
                    val latitude = vehiclePosition.position.latitude
                    // longitude
                    val longitude = vehiclePosition.position.longitude


                    Log.d("Position", "Route: $routeName, Location: ($latitude, $longitude)")


                }
            }
        }.start()
    }
}
