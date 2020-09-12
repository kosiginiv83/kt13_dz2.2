import postFields.*
import java.time.LocalDateTime
import kotlin.random.Random


data class Post(
        var text: String,
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

        var fromId: Int = Random.nextInt(1_000_000),
        var createdBy: Int = Random.nextInt(1_000_000),
        var ownerId: Int? = WallService.ownerId,
        var date: Long = java.time.Instant.now().toEpochMilli(),
//        var date: LocalDateTime? = LocalDateTime.now(),
)