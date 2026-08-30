package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.model.Language
import carlosgub.dev.model.Section
import carlosgub.dev.model.post.Post
import carlosgub.dev.model.post.PostEnglish
import carlosgub.dev.model.post.PostSection
import carlosgub.dev.model.post.PostSpanish
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun PostSection(language: Language) {
    val postSection = if (language == Language.English) PostEnglish else PostSpanish
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .id(Section.Posts.id),
        contentAlignment = Alignment.Center,
    ) {
        Div(attrs = { classes("blog-wrap") }) {
            P(attrs = { classes("blog-eyebrow") }) { Text(postSection.eyebrow) }
            H2(attrs = { classes("blog-h1") }) { Text(postSection.title) }
            Div(attrs = { classes("blog-grid") }) {
                postSection.posts.forEach { post ->
                    PostCard(post, postSection.readLabel)
                }
            }
            A(
                href = "https://medium.com/@carlosgub",
                attrs = {
                    classes("blog-footer-link")
                    attr("target", "_blank")
                    attr("rel", "noopener")
                }
            ) {
                Text(postSection.seeAllLabel)
            }
        }
    }
}

@Composable
private fun PostCard(post: Post, readLabel: String) {
    A(
        href = post.link,
        attrs = {
            classes("blog-card")
            attr("target", "_blank")
            attr("rel", "noopener")
        }
    ) {
        Div(attrs = { classes("blog-top-bar") }) {}
        Div(attrs = { classes("blog-thumb-wrap") }) {
            Span(attrs = { classes("blog-medium-tag") }) { Text("Medium") }
            Img(src = post.imageUrl, alt = "", attrs = { attr("loading", "lazy") })
        }
        Div(attrs = { classes("blog-body") }) {
            P(attrs = { classes("blog-title") }) { Text(post.title) }
            Div(attrs = { classes("blog-meta") }) {
                Span(attrs = { classes("blog-pill") }) { Text(post.date) }
                Span(attrs = { classes("blog-pill", "blog-claps") }) {
                    Text("👏 ")
                    B { Text("${post.claps}") }
                }
                Span(attrs = { classes("blog-arrow") }) { Text(readLabel) }
            }
        }
    }
}
