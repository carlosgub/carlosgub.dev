package carlosgub.dev.model.post

interface PostSection {
    val eyebrow: String
    val title: String
    val readLabel: String
    val seeAllLabel: String
    val posts: List<Post>
}
