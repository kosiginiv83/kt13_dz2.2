package postFields


data class Comments(
        val count: Int = 0,
        val canPost: Boolean = true,
        val groupsCanPost: Boolean = false,
        val canClose: Boolean = true,
        val canOpen: Boolean = false,
)