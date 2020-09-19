package attachments

data class LinkAttachment(
        val url: String,
        val title: String,
        val caption: String? = null,
        val description: String? = null,
        val photo: PhotoAttachment? = null,
        val price: Product? = null,
        val button: Button? = null,
        val previewPage: String,
        val previewUrl: String,
): Attachment