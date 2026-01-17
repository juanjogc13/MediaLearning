package com.example.medialearning

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
    TODO("Not yet implemented")
}

@Composable
fun AudioScreen() {
    TODO("Not yet implemented")
}

@Composable
fun HomeScreen(x0: NavHostController) {
    TODO("Not yet implemented")
}