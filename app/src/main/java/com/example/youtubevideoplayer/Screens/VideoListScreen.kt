package com.example.youtubevideoplayer.Screens

//@Composable
//fun VideoListScreen(viewModel: PlaylistViewModel) {
//    val videos by viewModel.videos.observeAsState(emptyList())
//
//    if (videos.isEmpty()) {
//        Text("No videos available")
//        Log.d("VideoListScreen", "No videos available")
//    } else {
//        LazyColumn {
//            items(videos) { video ->
//                Column {
//                    Text(text = video.title)
//                    Log.d("VideoListScreen", "Displaying video: ${video.title}")
//                    YoutubePlayer(youtubeVideoId = video.resourceId.videoId, lifecycleOwner = LocalContext.current as LifecycleOwner)
//                }
//            }
//        }
//    }
//}

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.youtubevideoplayer.navigation.Screen
import com.example.youtubevideoplayer.viewmodels.PlaylistViewModel

@Composable
fun VideoListScreen(navController: NavController, viewModel: PlaylistViewModel = viewModel()) {
    val videos by viewModel.videos.observeAsState(emptyList())

    if (videos.isEmpty()) {
        Text("No videos available")
    } else {
        LazyColumn {
            items(videos) { video ->
                Column {
                    Text(text = video.title)
                    ThumbnailItem(
                        video = video,
                        onClick = {
                            navController.navigate(Screen.VideoPlayer.createRoute(video.resourceId.videoId))
                        }
                    )
                }
            }
        }
    }
}





