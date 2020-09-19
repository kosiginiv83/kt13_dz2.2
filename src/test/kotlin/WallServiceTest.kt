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
        wall.getPosts().last().addAttachment(attachAudio)
        assertEquals(1, wall.getPosts().last().attachments.size)
    }
}