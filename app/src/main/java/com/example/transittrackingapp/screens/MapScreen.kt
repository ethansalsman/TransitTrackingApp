package com.example.transittrackingapp.screens

import android.content.Context
import android.view.View
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.viewinterop.NoOpUpdate
import com.example.transittrackingapp.ui.theme.TransitTrackingAppTheme
import java.lang.reflect.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView




    private lateinit var mapView: MapView



        @Composable
        fun MapScreen() {
            AndroidView(factory = {
               // mapView = MapView(this)
                mapView.mapboxMap.setCamera(
                    CameraOptions.Builder()
                        .center(Point.fromLngLat(-63.5728, 44.6476))
                        .pitch(0.0)
                        .zoom(2.0)
                        .bearing(0.0)
                        .build()
                )
                    mapView

            })
        }








