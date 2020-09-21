package attachments


enum class DocumentType(val id: Int) {
    TEXT(1),
    ARCHIVE(2),
    GIF(3),
    IMAGE(4),
    AUDIO(5),
    VIDEO(6),
    EBOOK(7),
    UNDEFINED(8),
}


data class DocumentPreview(
        val photo: DocumentPreviewPhoto? = null,
        val graffiti: DocumentPreviewGraffiti? = null,
        val audioMessage: DocumentPreviewAudioMessage? = null,
)


class DocumentPreviewPhoto(
        val sizes: Array<DocumentPreviewPhotoSize>? = null,
)


data class DocumentPreviewPhotoSize(
        val src: String,
        val width: Int,
        val height: Int,
        val type: String,
)


data class DocumentPreviewGraffiti(
        val src: String,
        val width: Int,
        val height: Int,
)


class DocumentPreviewAudioMessage(
        val duration: Int,
        val waveform: Array<Int>? = null,
        val linkOgg: String,
        val linkMp3: String,
)