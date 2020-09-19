package attachments


data class VideoAttachment(
        val id: Int,
        val ownerId: Int,
        val date: Long,
        val title: String,
        val width: Int,
        val height: Int,
        val duration: Int,

        val description: String? = null,
        val userId: Int? = null,
        val views: Int = 0,
        val addingDate: Long = java.time.Instant.now().toEpochMilli(),
        val localViews: Int = 0,
        val comments: Int = 0,
        val player: String? = null,
        val platform: String? = null,
        val canAdd: Boolean = false,
        val isPrivate: Boolean = true,
        val accessKey: String? = null,
        val processing: Boolean = true,
        val isFavorite: Boolean = false,
        val canComment: Boolean = false,
        val canEdit: Boolean = false,
        val canLike: Boolean = false,
        val canRepost: Boolean = false,
        val canSubscribe: Boolean = false,
        val canAddToFaves: Boolean = false,
        val canAttachLink: Boolean = false,
        val converting: Boolean = false,
        val added: Boolean = false,
        val isSubscribed: Boolean = false,
        val repeat: Boolean = true,
        val type: VideoType = VideoType.VIDEO,
        val balance: Int = 0,
        val liveStatus: VideoLiveStatus? = null,
        val spectators: Int = 0,
        val likes: VideoLikes = VideoLikes(),
        val reposts: VideoReposts = VideoReposts(),
): Attachment {
    val image: Array<VideoImage> = emptyArray()
    val firstFrame: Array<VideoFirstFrame> = emptyArray()
    val upcoming: Boolean
        get() = liveStatus == VideoLiveStatus.UPCOMING
}


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