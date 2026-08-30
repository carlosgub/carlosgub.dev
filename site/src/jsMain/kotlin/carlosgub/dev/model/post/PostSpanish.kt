package carlosgub.dev.model.post

import carlosgub.dev.model.Section

data object PostSpanish : PostSection {
    override val eyebrow: String = "Escritura técnica"
    override val title: String = Section.Posts.spanishText
    override val readLabel: String = "Leer →"
    override val posts: List<Post> = MediumPosts.all
}
