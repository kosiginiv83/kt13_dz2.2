import attachments.*


fun main() {
    val wall = WallService(123)
    wall.add(Post("saontehuaostneu"))
    wall.add(Post("crjkgo euntih asonethu onteuhneosu hntsoe"))
    wall.printPosts()

    val postToUpdate = wall.getPosts()[0].copy(text = "updated text")
    println("update 1: " + wall.update(postToUpdate))
    val postToUpdateNo = Post("jkqqjkmb")
    println("update 2: " + wall.update(postToUpdateNo))
    wall.printPosts()

    wall.add(Post("Repost", postType = PostType.COPY))
    wall.printPosts()
    println(wall.getPosts()[1].copyHistory)
    println(wall.getPosts()[2].copyHistory)
    wall.getPosts()[2].copyHistory =
            wall.getPosts()[2].copyHistory?.plus(Post("To copyHistory"))
    wall.getPosts()[2].copyHistory?.forEach { println("\tHistory post: $it") }
    println(wall.getPosts()[1].copyHistory)
    println(wall.getPosts()[2].copyHistory)

    val postForAttach = Post("With audio attachment")
    val attachAudio = Attachment.AudioAttachment(id = 1, ownerId = wall.ownerId,
            artist = "Artist1", title = "Title1", duration = 100, url = "link/to/audio/file1")
    wall.add(postForAttach)
    wall.addAttachmentToPost(wall.getPosts().last().id, attachAudio)
    println(wall.getPosts().last().attachments[0].toString())

    println()
    val comment1 = Comment(456, "First comment")
    val comment2 = Comment(456, "Second comment")
    println(wall.createComment(1, comment1))
//    println(wall.createComment(5, comment2))

    println()
    println(wall.reportComment(1, 0))
    println(wall.getReports()[0].reason)
    println(wall.reportComment(10, 0))
    println(wall.reportComment(1, 10))
}
