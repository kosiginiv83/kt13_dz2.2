import attachments.Attachment

class WallService(val ownerId: Int) {
    private var posts: Array<Post> = emptyArray()
    private var comments: Array<Comment> = emptyArray()
    private var reports = emptyArray<Report>()
    private var postCount = 0
    private var commentCount = 0

    fun getPosts() = posts

    fun getComments() = comments

    fun getReports() = reports

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

    fun addAttachmentToPost(postId: Int?, attach: Attachment?) {
        if (attach == null) throw AttachmentIsNull("Пустое вложение")
        when (val foundPost = this.posts.find { it.id == postId }) {
            null -> throw PostNotFoundException("Поста с таким ID не существует")
            else -> foundPost.attachments += attach
        }
    }

    fun printPosts() {
        println("\n\tСписок постов:")
        posts.forEach { println("id: ${it.id}, date: ${it.date}, text: '${it.text}', " +
                "type: ${it.postType}") }
        println()
    }

    fun createComment(postId: Int, comment: Comment): Int? {
        return when (posts.indexOfFirst{ it.id == postId }) {
            -1 -> throw PostNotFoundException("Поста с таким ID не существует")
            else -> {
                comments += comment.copy(id = ++commentCount)
                comments.last().id
            }
        }
    }

    fun reportComment(commentId: Int, reasonId: Int): Boolean {
        var result = true
        try {
            if (!ReportReasons.values().any { it.id == reasonId }) {
                result = false
                throw ReportReasonNotExistException("Такого ID причины для жалобы не существует")
            }
            if (!comments.any { it.id == commentId }) {
                result = false
                throw CommentNotFoundException("Комментарий не найден")
            }
            reports += Report(commentId, reasonId)
        } catch(e: ReportReasonNotExistException) {
            e.printStackTrace()
        } catch(e: CommentNotFoundException) {
            e.printStackTrace()
        } finally {
            return result
        }
    }
}