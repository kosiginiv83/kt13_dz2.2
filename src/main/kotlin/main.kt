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
}
