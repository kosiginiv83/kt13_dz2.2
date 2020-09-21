class Report(
        val toCommentId: Int,
        val reasonId: Int,
//        val reason: ReportReasons,
) {
    val reason: ReportReasons? =  ReportReasons.values().find { it.id == reasonId }
//    val reasonId: Int = reason.id,
}


enum class ReportReasons(val id: Int) {
    SPAM(0),
    CHILD_PORNOGRAPHY(1),
    EXTREMISM(2),
    VIOLENCE(3),
    DRUG_PROPAGANDA(4),
    MATERIAL_FOR_ADULTS(5),
    INSULT(6),
    CALLS_FOR_SUICIDE(8),
}
