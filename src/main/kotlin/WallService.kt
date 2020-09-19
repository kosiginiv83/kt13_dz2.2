class WallService(val ownerId: Int) {
    private var posts: Array<Post> = emptyArray()
    private var postCount = 0

    fun getPosts() = posts

    fun add(post: Post): Post {
        val newPost = post.copy(id = ++postCount, ownerId = ownerId)
        posts += newPost
        return newPost
    }

    fun update(post: Post): Boolean {
        return when (val foundInd = posts.indexOfFirst { it.id == post.id }) {
            -1 -> false
            else -> {
                posts[foundInd] = post.copy(date = post.date)
                true
            }
        }
    }

    fun printPosts() {
        println("\n\tСписок постов:")
        posts.forEach { println("id: ${it.id}, date: ${it.date}, text: '${it.text}', " +
                "type: ${it.postType}") }
        println()
    }
}