package com.example.youtubevideoplayer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.youtubevideoplayer.Screens.VideoListScreen
import com.example.youtubevideoplayer.Screens.VideoPlayerScreen

sealed class Screen(val route: String) {
    object VideoList : Screen("video_list")
    object VideoPlayer : Screen("video_player/{videoId}") {
        fun createRoute(videoId: String) = "video_player/$videoId"
    }
}

@Composable
fun NavGraph(startDestination: String = Screen.VideoList.route) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.VideoList.route) {
            VideoListScreen(navController = navController)
        }
        composable(Screen.VideoPlayer.route) { backStackEntry ->
            val videoId = backStackEntry.arguments?.getString("videoId") ?: ""
            VideoPlayerScreen(videoId = videoId)
        }
    }
}

