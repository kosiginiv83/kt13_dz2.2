import attachments.*
import org.junit.Test
import org.junit.Assert.*


class WallServiceTest {

    @Test
    fun addingPost() {
        val wall = WallService(1)
        wall.add(Post("test"))
        assertEquals(1, wall.getPosts().size)
    }

    @Test
    fun updateExistingPost() {
        val wall = WallService(2)
        wall.add(Post("test"))
        val updated = wall.getPosts()[0].copy("updated")
        assertTrue(wall.update(updated))
    }

    @Test
    fun updateNotExistingPost() {
        val wall = WallService(3)
        wall.add(Post("test"))
        val newPost = Post("new")
        assertFalse(wall.update(newPost))
    }

    @Test
    fun copyHistoryOfRepost() {
        val wall = WallService(ownerId = 4)
        wall.add(Post("repost", postType = PostType.COPY))
        var copyHistory = wall.getPosts()[0].copyHistory
        copyHistory = copyHistory!!.plus(Post("text"))
        assertEquals(1, copyHistory.size)
    }

    @Test
    fun copyHistoryOfPost() {
        val wall = WallService(ownerId = 5)
        wall.add(Post("post"))
        assertNull(wall.getPosts()[0].copyHistory)
    }

    @Test
    fun addAttachToPost_Audio() {
        val wall = WallService(ownerId = 6)
        wall.add(Post("With audio attachment"))
        val attachAudio = Attachment.AudioAttachment(id = 1, ownerId = wall.ownerId,
                artist = "Artist1", title = "Title1", duration = 100, url = "link/to/audio/file1")
        wall.addAttachmentToPost(wall.getPosts().last().id, attachAudio)
        assertEquals(1, wall.getPosts().last().attachments.size)
    }

    @Test
    fun addCommentToPost_Success() {
        val wall = WallService(ownerId = 7)
        wall.add(Post("Post"))
        val comment = Comment(456, "Comment to existing post")
        assertEquals(1, wall.createComment(1, comment))
    }

    @Test(expected = PostNotFoundException::class)
    fun addCommentToPost_Fail() {
        val wall = WallService(ownerId = 8)
        wall.add(Post("Post"))
        val comment = Comment(456, "Comment to fake post")
        wall.createComment(2, comment)
    }

    @Test
    fun addReportToComment_Success() {
        val wall = WallService(ownerId = 9)
        wall.add(Post("Adding report"))
        val comment = Comment(fromId = 456, text = "For report")
        wall.createComment(1, comment)
        assertTrue(wall.reportComment(1, 0))
    }

    @Test
    fun addReportToComment_CommentNotFoundException() {
        val wall = WallService(ownerId = 10)
        wall.add(Post("CommentNotFoundException"))
        val comment = Comment(fromId = 456, text = "For report")
        wall.createComment(postId = 1, comment)
        assertFalse(wall.reportComment(commentId = 2, reasonId = 0))
    }

    @Test
    fun addReportToComment_ReportReasonNotExistException() {
        val wall = WallService(ownerId = 11)
        wall.add(Post("ReportReasonNotExistException"))
        val comment = Comment(fromId = 456, text = "For report")
        wall.createComment(postId = 1, comment)
        assertFalse(wall.reportComment(commentId = 1, reasonId = 10))
    }
}