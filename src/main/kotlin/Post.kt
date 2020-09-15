import postFields.*
import kotlin.random.Random


data class Post(
        val text: String,
        val ownerId: Int = -1,
        val id: Int = -1,
        val replyOwnerId: Int = 0,
        val replyPostId: Int = 0,
        val friendsOnly: Boolean = false,
        val comments: Comments = Comments(),
        val copyright: String = "",
        val likes: Likes = Likes(),
        val reposts: Reposts = Reposts(),
        val views: Views = Views(),
        val postType: String = "post",
        val signerId: Int = 0,
        val canPin: Boolean = true,
        val canDelete: Boolean = true,
        val canEdit: Boolean = true,
        val isPinned: Boolean = false,
        val markedAsAds: Boolean = false,
        val isFavorite: Boolean = false,
        val postponedId: Int = 0,

        val fromId: Int = Random.nextInt(1_000_000),
        val createdBy: Int = Random.nextInt(1_000_000),
        val date: Long = java.time.Instant.now().toEpochMilli(),
)