package com.example.transittrackingapp

import  android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.transittrackingapp.screens.AlertsScreen
import com.example.transittrackingapp.screens.MapScreen
import com.example.transittrackingapp.screens.RoutesScreen
import com.example.transittrackingapp.ui.theme.TransitTrackingAppTheme



class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instantiate ViewModel
        mainViewModel = MainViewModel()


        setContent {
            TransitTrackingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TransitApp()
                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TransitApp() {

        val navController: NavHostController = rememberNavController()

        Scaffold(

            bottomBar = {
                BottomAppBar(

                    //backgroundColor = Color.Transparent
                    actions = {
                        IconButton(onClick = { navController.navigate("map") }) {

                        }
                        IconButton(onClick = { navController.navigate("routes") }

                        ) {

                        }
                        IconButton(onClick = { navController.navigate("alerts") }
                        ) {


                        }
                    }
                )

            }
        ) { innerPadding ->
            // NavHost will display the correfct screen
            NavHost(
                navController = navController,
                startDestination = "map",
                modifier = Modifier.padding(innerPadding)

            ) {
                composable(route = "map") {
                    MapScreen() // for now
                }
                composable(route = "routes") {
                    RoutesScreen()
                }
                composable(route = "alerts") {
                    AlertsScreen()
                }
            }
        }
    }
}