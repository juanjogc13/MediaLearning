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
        composable("audio") { AudioScreen(navController) }
        composable("video") { VideoScreen(navController) }

        composable("video_player/{url}") { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url") ?: ""
            VideoPlayerScreen(videoUrl = url)
        }
    }
}
