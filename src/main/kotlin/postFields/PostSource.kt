package postFields


data class PostSource(
    val type: Type? = null,
    val platform: Platform? = null,
    val data: String? = null,
    val url: String? = null,
)

enum class Type {VK, WIDGET, API, RSS, SMS}

enum class Platform {ANDROID, IPHONE, WPHONE}