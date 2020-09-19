package attachments


data class PhotoAttachment(
        val id: Int,
        val ownerId: Int,
        val date: Long = java.time.Instant.now().toEpochMilli(),
        val albumId: Int? = null,
        val userId: Int? = null,
        val text: String? = null,
        val width: Int,
        val height: Int,
): Attachment {
    val sizes: Array<PhotoSizes> = emptyArray()
}


data class PhotoSizes(
        val type: String,
        val url: String,
        val width: Int,
        val height: Int,
)