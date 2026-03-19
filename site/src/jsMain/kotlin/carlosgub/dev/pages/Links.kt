package carlosgub.dev.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import carlosgub.dev.components.styles.*
import carlosgub.dev.model.Link
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.document
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun LinksPage() {
    val title = "Carlos Ugaz | Links"
    LaunchedEffect(title) {
        document.title = title
    }

    val links = listOf(
        Link("My Website", "/"),
        Link("YouTube", "https://www.youtube.com/@carlosgub"),
        Link("GitHub", "https://github.com/carlosgub"),
        Link("LinkedIn", "https://linkedin.com/in/carlosgub"),
        Link("Medium", "https://medium.com/@carlosgub"),
    )

    Box(
        modifier = LinksPageStyle.toModifier(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = LinksSectionStyle.toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                src = "logo.webp",
                modifier = Modifier
                    .size(120.px)
                    .borderRadius(16.px),
                alt = "Carlos Ugaz Logo"
            )

            Div(attrs = LinksTitleStyle.toModifier().toAttrs()) {
                Text("Carlos Ugaz")
            }

            Div(attrs = LinksSubtitleStyle.toModifier().toAttrs()) {
                Text("Mobile Software Engineer")
            }

            links.forEach { link ->
                LinkItem(link)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 32.px),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialIcon({ size, modifier -> FaYoutube(size = size, modifier = modifier) }, "https://www.youtube.com/@carlosgub")
                SocialIcon({ size, modifier -> FaGithub(size = size, modifier = modifier) }, "https://github.com/carlosgub")
                SocialIcon({ size, modifier -> FaTwitter(size = size, modifier = modifier) }, "https://twitter.com/carlosgub")
                SocialIcon({ size, modifier -> FaLinkedin(size = size, modifier = modifier) }, "https://linkedin.com/in/carlosgub")
            }
        }
    }
}

@Composable
fun LinkItem(link: Link) {
    A(
        href = link.url,
        attrs = LinkButtonStyle.toModifier().toAttrs()
    ) {
        Text(link.title)
    }
}

@Composable
fun SocialIcon(icon: @Composable (IconSize, Modifier) -> Unit, url: String) {
    A(
        href = url,
        attrs = Modifier
            .margin(leftRight = 12.px)
            .toAttrs()
    ) {
        icon(IconSize.XXL, Modifier.color(com.varabyte.kobweb.compose.ui.graphics.Colors.Black))
    }
}
