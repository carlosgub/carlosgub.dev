package carlosgub.dev.model.project

import carlosgub.dev.model.Stack

data class Project(
    val stackList: List<Stack>,
    val name: String,
    val description:String,
    val actionButtonText:String,
)
