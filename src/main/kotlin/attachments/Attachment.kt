package attachments


sealed class Attachment {

    data class AudioAttachment(
            val id: Int,
            val ownerId: Int,
            val artist: String,
            val title: String,
            val duration: Int,
            val url: String,
            val lyricsId: Int? = null,
            val date: Long = java.time.Instant.now().toEpochMilli(),
            val albumId: Int? = null,
            val noSearch: Boolean = false,
            val isHq: Boolean = false,
            val genreId: Int = AudioGenre.OTHER.id,
    ): Attachment()

    data class DocumentAttachment(
            val id: Int,
            val ownerId: Int,
            val date: Long,
            val title: String,
            val size: Int,
            val ext: String,
            val url: String,
            val type: Int = DocumentType.UNDEFINED.id,
            val preview: DocumentPreview? = null,
    ): Attachment()

    data class LinkAttachment(
            val url: String,
            val title: String,
            val caption: String? = null,
            val description: String? = null,
            val photo: PhotoAttachment? = null,
            val price: Product? = null,
            val button: Button? = null,
            val previewPage: String,
            val previewUrl: String,
    ): Attachment()

    data class PhotoAttachment(
            val id: Int,
            val ownerId: Int,
            val date: Long = java.time.Instant.now().toEpochMilli(),
            val albumId: Int? = null,
            val userId: Int? = null,
            val text: String? = null,
            val width: Int,
            val height: Int,
    ): Attachment() {
        val sizes: Array<PhotoSizes> = emptyArray()
    }

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
    ): Attachment() {
        val image: Array<VideoImage> = emptyArray()
        val firstFrame: Array<VideoFirstFrame> = emptyArray()
        val upcoming: Boolean
            get() = liveStatus == VideoLiveStatus.UPCOMING
    }
}