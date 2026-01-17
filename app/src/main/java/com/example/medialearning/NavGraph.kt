package com.example.medialearning

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("audio") { AudioScreen() }
        composable("video") { VideoScreen() }
    }
}

@Composable
fun VideoScreen() {
    Text("Pantalla de vídeo (en construcción)")
}

