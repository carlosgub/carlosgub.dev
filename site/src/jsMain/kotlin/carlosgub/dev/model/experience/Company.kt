package carlosgub.dev.model.experience

import carlosgub.dev.model.Stack

data class Company(
    val name: String,
    val url: String,
    val time: String,
    val description: String,
    val stackList: List<Stack>
)
