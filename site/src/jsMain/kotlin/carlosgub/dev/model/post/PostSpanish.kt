package carlosgub.dev.model.post

import carlosgub.dev.model.Section

data object PostSpanish : PostSection {
    override val title: String = Section.Posts.spanishText
    override val posts: List<Post> = MediumPosts.all
}
