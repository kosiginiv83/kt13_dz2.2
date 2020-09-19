package attachments

data class AudioAttachment(
        val id: Int,
        val ownerId: Int,
        val date: Long,
        val artist: String,
        val title: String,
        val duration: Int,
        val url: String,

        val lyricsId: Int? = null,
        val albumId: Int? = null,
        val noSearch: Boolean = false,
        val isHq: Boolean = false,
        val genreId: Int = AudioGenre.OTHER.id,
): Attachment


enum class AudioGenre(val id: Int) {
    ROCK(1),
    POP(2),
    RAP_HIPHOP(3),
    EASY_LISTENING(4),
    HOUSE_DANCE(5),
    INSTRUMENTAL(6),
    METAL(7),
    ALTERNATIVE(21),
    DUBSTEP(8),
    JAZZ_BLUES(1001),
    DRUM_BASS(10),
    TRANCE(11),
    CHANSON(12),
    ETNIC(13),
    ACOUSTIC_VOCAL(14),
    REGGAE(15),
    CLASSICAL(16),
    INDIE_POP(17),
    SPEECH(19),
    ELECTROPOP_DISCO(22),
    OTHER(18),
}