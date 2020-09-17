package postFields

data class Geo(
    val type: String? = null,
    val coordinates: String? = null,
    val place: GeoPlace? = null,
)