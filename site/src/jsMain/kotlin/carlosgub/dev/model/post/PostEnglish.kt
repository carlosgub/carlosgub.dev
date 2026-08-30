package carlosgub.dev.model.post

import carlosgub.dev.model.Section

data object PostEnglish : PostSection {
    override val eyebrow: String = "Technical writing"
    override val title: String = Section.Posts.englishText
    override val readLabel: String = "Read →"
    override val seeAllLabel: String = "See all posts on Medium →"
    override val posts: List<Post> = MediumPosts.all
}
