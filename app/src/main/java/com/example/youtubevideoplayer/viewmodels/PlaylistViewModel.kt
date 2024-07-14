package com.example.youtubevideoplayer.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubevideoplayer.database.Snippet
import com.example.youtubevideoplayer.database.YouTubeApi
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlaylistViewModel : ViewModel() {
    private val _videos = MutableLiveData<List<Snippet>>()
    val videos: LiveData<List<Snippet>> get() = _videos

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/youtube/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(YouTubeApi::class.java)

    fun fetchPlaylistVideos(apiKey: String, playlistId: String) {
        viewModelScope.launch {
            try {
                val response = api.getPlaylistItems("snippet", playlistId, apiKey)
                _videos.value = response.items.map { it.snippet }
                Log.d("PlaylistViewModel", "Fetched videos: ${response.items.map { it.snippet.title }}")
            } catch (e: Exception) {
                Log.e("PlaylistViewModel", "Error fetching playlist videos", e)
            }
        }
    }
}


//class PlaylistViewModel : ViewModel() {
//    private val _videos = MutableLiveData<List<Snippet>>()
//    val videos: LiveData<List<Snippet>> get() = _videos
//
//    private val retrofit = Retrofit.Builder()
//        .baseUrl("https://www.googleapis.com/youtube/v3/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    private val api = retrofit.create(YouTubeApi::class.java)
//
//    fun fetchPlaylistVideos(apiKey: String, playlistId: String) {
//        viewModelScope.launch {
//            try {
//                val response = api.getPlaylistItems("snippet", playlistId, apiKey)
//                _videos.value = response.items.map { it.snippet }
//                Log.d("PlaylistViewModel", "Fetched videos: ${response.items.map { it.snippet.title }}")
//            } catch (e: HttpException) {
//                Log.e("PlaylistViewModel", "HTTP Error: ${e.code()}")
//                Log.e("PlaylistViewModel", "Error fetching playlist videos", e)
//                // Handle specific HTTP error codes (e.g., 403 Forbidden)
//            } catch (e: Exception) {
//                Log.e("PlaylistViewModel", "Error fetching playlist videos", e)
//                // Handle other exceptions
//            }
//        }
//
//    }
//}


