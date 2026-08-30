package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.styles.CompanyLink
import carlosgub.dev.components.styles.PExperienceStyle
import carlosgub.dev.components.styles.PostSectionStyle
import carlosgub.dev.components.styles.components.H4Style
import carlosgub.dev.components.styles.components.H6Style
import carlosgub.dev.components.styles.components.HRStyle
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.model.Language
import carlosgub.dev.model.Section
import carlosgub.dev.model.post.Post
import carlosgub.dev.model.post.PostEnglish
import carlosgub.dev.model.post.PostSection
import carlosgub.dev.model.post.PostSpanish
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P
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
        Column(
            modifier = listOf(
                PostSectionStyle
            ).toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PostContent(postSection)
        }
    }
}

@Composable
private fun PostContent(postSection: PostSection) {
    H4(
        attrs = H4Style
            .toModifier()
            .fillMaxWidth()
            .textAlign(TextAlign.Start)
            .bold()
            .color(WebColors.Blue)
            .toAttrs()
    ) {
        SpanText(
            postSection.title
        )
    }

    postSection.posts.forEachIndexed { index, post ->
        PostItem(post)
        if (index != postSection.posts.lastIndex) {
            HorizontalDivider(HRStyle.toModifier())
        }
    }
}

@Composable
private fun PostItem(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .margin(topBottom = 12.px)
    ) {
        A(
            href = post.link,
            attrs = H6Style
                .toModifier()
                .fillMaxWidth()
                .textDecorationLine(TextDecorationLine.None)
                .bold()
                .color(WebColors.Blue)
                .margin(0.px)
                .toAttrs()
        ) {
            SpanText(
                text = post.title,
                modifier = CompanyLink.toModifier()
            )
        }
        P(
            attrs = PExperienceStyle
                .toModifier()
                .toAttrs()
        ) {
            Text("${post.date} · 👏 ${post.claps}")
        }
    }
}
