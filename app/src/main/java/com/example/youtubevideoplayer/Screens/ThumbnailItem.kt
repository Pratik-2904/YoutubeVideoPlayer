package com.example.youtubevideoplayer.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.youtubevideoplayer.database.Snippet
import com.example.youtubevideoplayer.database.YoutubePlayer

@Composable
fun ThumbnailItem(video: Snippet, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = rememberImagePainter(data = video.thumbnails.default.url),
            contentDescription = "Thumbnail",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}


//Video player screen

@Composable
fun VideoPlayerScreen(videoId: String) {
    val lifecycleOwner = LocalLifecycleOwner.current
    YoutubePlayer(youtubeVideoId = videoId, lifecycleOwner = lifecycleOwner)
}
