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
        val updated = wall.getPosts().get(0).copy("updated")
        assertTrue(wall.update(updated))
    }

    @Test
    fun updateNotExistingPost() {
        val wall = WallService(3)
        wall.add(Post("test"))
        val newPost = Post("new")
        assertFalse(wall.update(newPost))
    }
}