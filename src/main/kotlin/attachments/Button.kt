package attachments


class Button(
        val title: String,
        var action: ButtonAction,
)


class ButtonAction(
        val type: String,
        val url: String,
)