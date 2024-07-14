package com.example.youtubevideoplayer.database

import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {
    @GET("playlistItems")
    suspend fun getPlaylistItems(
        @Query("part") part: String,
        @Query("playlistId") playlistId: String,
        @Query("key") apiKey: String
    ): YouTubeApiResponse
}

