package com.example.youtubevideoplayer.database
//
//data class PlaylistResponse(val items: List<PlaylistItem>)
//
//data class PlaylistItem(val snippet: Snippet)
//
//data class Snippet(val title: String, val resourceId: ResourceId)
//
//data class ResourceId(val videoId: String)

data class YouTubeApiResponse(
    val items: List<PlaylistItem>
)

data class PlaylistItem(
    val snippet: Snippet
)

data class Snippet(
    val title: String,
    val thumbnails: Thumbnails,
    val resourceId: ResourceId
)

data class Thumbnails(
    val default: Thumbnail
)

data class Thumbnail(
    val url: String
)

data class ResourceId(
    val videoId: String
)


