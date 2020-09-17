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
}
