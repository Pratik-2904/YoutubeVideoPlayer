package com.example.youtubevideoplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.youtubevideoplayer.navigation.NavGraph
import com.example.youtubevideoplayer.viewmodels.PlaylistViewModel


class MainActivity : ComponentActivity() {
    private val viewModel: PlaylistViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavGraph()
        }

        val apiKey = "AIzaSyD_vBOEhC9Qf3r9RaN56o8D1gNk4KRkTSE"
        val playlistId = "PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz"
        viewModel.fetchPlaylistVideos(apiKey, playlistId)
    }
}
