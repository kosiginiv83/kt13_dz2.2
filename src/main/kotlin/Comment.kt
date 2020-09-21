import attachments.Attachment


data class Comment(
        val fromId: Int,
        val text: String,
        val id: Int? = null,
        val date: Long = java.time.Instant.now().toEpochMilli(),
        val replyToUser: Int? = null,
        val replyToComment: Int? = null,
        val thread: Thread? = null,
) {
    var parentStack: Array<Int> = emptyArray()
    var attachments: Array<Attachment> = emptyArray()

    fun addAttachment(attach: Attachment) {
        attachments += attach
    }
}


data class Thread(
        val count: Int = 0,
        val canPost: Boolean = false,
        val showReplyButton: Boolean = false,
        val groupsCanPost: Boolean = false,
) {
    var items: Array<Comment> = emptyArray()
}
