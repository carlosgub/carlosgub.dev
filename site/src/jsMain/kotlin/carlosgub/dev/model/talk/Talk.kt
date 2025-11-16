package carlosgub.dev.model.talk

data class Talk(
    val flag: String,
    val title: String,
    val slidePath: String? = null,
    val videoPath: String? = null,
    val paperPath: String? = null,
)
