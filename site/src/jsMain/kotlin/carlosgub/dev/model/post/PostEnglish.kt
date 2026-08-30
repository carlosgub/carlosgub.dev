package carlosgub.dev.model.post

import carlosgub.dev.model.Section

data object PostEnglish : PostSection {
    override val title: String = Section.Posts.englishText
    override val posts: List<Post> = MediumPosts.all
}
