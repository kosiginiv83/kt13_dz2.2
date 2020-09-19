import attachments.Attachment
import postFields.*
import kotlin.random.Random


data class Post(
        val text: String,
        val ownerId: Int? = null,
        val id: Int? = null,
        val replyOwnerId: Int? = null,
        val replyPostId: Int? = null,
        val friendsOnly: Boolean = false,
        val comments: Comments = Comments(),
        val copyright: String? = null,
        val likes: Likes = Likes(),
        val reposts: Reposts = Reposts(),
        val views: Views = Views(),
        val postType: PostType = PostType.POST,
        val signerId: Int? = null,
        val canPin: Boolean = true,
        val canDelete: Boolean = true,
        val canEdit: Boolean = true,
        val isPinned: Boolean = false,
        val markedAsAds: Boolean = false,
        val isFavorite: Boolean = false,
        val postponedId: Int? = null,

        val fromId: Int = Random.nextInt(1_000_000),
        val createdBy: Int = Random.nextInt(1_000_000),
        val date: Long = java.time.Instant.now().toEpochMilli(),

        val postSource: PostSource? = null,
        val geo: Geo? = null,
) {
    var copyHistory: Array<Post>? = emptyArray()
        get() = if (postType == PostType.COPY) field else null

    val attachments: Array<Attachment> = emptyArray()
}

enum class PostType(val type: String) {
    POST("post"),
    COPY("copy"),
    REPLY("reply"),
    POSTPONE("postpone"),
    SUGGEST("suggest"),
}
