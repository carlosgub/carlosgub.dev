package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.styles.DevelopedByLink
import carlosgub.dev.components.styles.FooterStyle
import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A

@Composable
fun Footer(breakpoint: Breakpoint) {
    if (breakpoint >= Breakpoint.MD) {
        FooterHorizontal()
    } else {
        FooterVertical()
    }
}

@Composable
private fun FooterHorizontal() {
    val iconSize = IconSize.XXL
    Row(
        FooterStyle.toModifier()
            .padding(
                leftRight = 80.px,
                topBottom = 50.px
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1)) {
            DevelopedByFooter()
        }
        Row(
            modifier = Modifier.weight(1),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            GithubIcon(iconSize = iconSize)
            YoutubeIcon(iconSize = iconSize)
            TwitterIcon(iconSize = iconSize)
            LinkedinIcon(iconSize = iconSize)
            MediumIcon(iconSize = iconSize)
        }
    }
}


@Composable
private fun FooterVertical() {
    val iconSize = IconSize.LG
    Column(
        FooterStyle
            .toModifier()
            .padding(
                leftRight = 50.px,
                topBottom = 30.px
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DevelopedByFooter()
        Row(
            modifier = Modifier.fillMaxWidth()
                .margin(top = 25.px, bottom = 30.px),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            GithubIcon(iconSize = iconSize)
            YoutubeIcon(iconSize = iconSize)
            TwitterIcon(iconSize = iconSize)
            LinkedinIcon(iconSize = iconSize)
            MediumIcon(iconSize = iconSize)
        }
    }
}

@Composable
private fun DevelopedByFooter() {
    Link(
        path = "https://github.com/carlosgub/carlosgub.dev",
        text = "Developed by Carlos Ugaz 2024",
        modifier = DevelopedByLink.toModifier()
    )
}

@Composable
private fun GithubIcon(iconSize: IconSize) {
    A(
        href = "https://github.com/carlosgub",
        attrs = Modifier
            .ariaLabel("Go to my github")
            .toAttrs(),
    ) {
        FaGithub(
            size = iconSize,
            modifier = Modifier.color(WebColors.Blue)
        )
    }
}

@Composable
private fun YoutubeIcon(iconSize: IconSize) {
    A(
        href = "https://www.youtube.com/@carlosgub",
        attrs = Modifier
            .ariaLabel("Go to my youtube channel")
            .toAttrs(),
    ) {
        FaYoutube(
            size = iconSize,
            modifier = Modifier.color(WebColors.Blue)
        )
    }
}

@Composable
private fun TwitterIcon(iconSize: IconSize) {
    A(
        href = "https://twitter.com/carlosgub",
        attrs = Modifier
            .ariaLabel("Go to my twitter profile")
            .toAttrs(),
    ) {
        FaTwitter(
            size = iconSize,
            modifier = Modifier.color(WebColors.Blue)
        )
    }
}

@Composable
private fun LinkedinIcon(iconSize: IconSize) {
    A(
        href = "https://linkedin.com/in/carlosgub",
        attrs = Modifier
            .ariaLabel("Go to my linkedin profile")
            .toAttrs(),
    ) {
        FaLinkedin(
            size = iconSize,
            modifier = Modifier.color(WebColors.Blue)
        )
    }
}

@Composable
private fun MediumIcon(iconSize: IconSize) {
    A(
        href = "https://medium.com/@carlosgub",
        attrs = Modifier
            .ariaLabel("Go to my medium profile")
            .toAttrs(),
    ) {
        FaMedium(
            size = iconSize,
            modifier = Modifier.color(WebColors.Blue)
        )
    }
}
