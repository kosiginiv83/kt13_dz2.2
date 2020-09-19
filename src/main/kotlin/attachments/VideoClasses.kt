package attachments


enum class VideoType(val type: String) {
    VIDEO("video"),
    MUSIC_VIDEO("music_video"),
    MOVIE("movie"),
}


enum class VideoLiveStatus(val type: String) {
    WAITING("waiting"),
    STARTED("started"),
    FINISHED("finished"),
    FAILED("failed"),
    UPCOMING("upcoming"),
}


data class VideoLikes(
        val count: Int = 0,
        val userLikes: Boolean = false,
)


data class VideoReposts(
        val count: Int = 0,
        val wallCount: Int = 0,
        val mailCount: Int = 0,
        val userReposted: Boolean = false,
)


data class VideoFirstFrame(
        val url: String,
        val height: Int,
        val width: Int,
)


data class VideoImage(
        val url: String,
        val height: Int,
        val width: Int,
        val withPadding: Int,
)