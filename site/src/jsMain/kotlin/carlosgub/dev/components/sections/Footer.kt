package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.styles.FooterStyle
import carlosgub.dev.components.styles.components.H6Style
import carlosgub.dev.components.styles.components.HRStyle
import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.Text

@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .background(Color.floralwhite)
            .fillMaxWidth()
    ) {
        HorizontalDivider(HRStyle.toModifier())
        FooterHorizontal()
        FooterVertical()
    }
}

@Composable
private fun FooterHorizontal() {
    val iconSize = IconSize.XXL
    Row(
        modifier = FooterStyle
            .toModifier()
            .displayIfAtLeast(Breakpoint.MD)
            .padding(
                leftRight = 80.px,
                topBottom = 50.px
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.weight(1).alignItems(AlignItems.Center)) {
            FooterBrandImage()
            DevelopedByFooter(
                modifier = Modifier.fillMaxHeight().margin(left = 8.px)
            )
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
            .displayUntil(Breakpoint.MD)
            .padding(
                leftRight = 50.px,
                topBottom = 30.px
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FooterBrandImage()
        DevelopedByFooter(
            modifier = Modifier
                .margin(top = 8.px)
                .textAlign(TextAlign.Center)
        )
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
private fun DevelopedByFooter(
    modifier: Modifier = Modifier,
) {
    H6(
        attrs = H6Style.toModifier().then(modifier).toAttrs()
    ) {
        Text("Carlos Ugaz")
        Br()
        Text("Senior Software Engineer")
    }
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

@Composable
private fun FooterBrandImage() {
    Image(
        src = "logo.webp",
        alt = "Brand Image",
        modifier = Modifier.size(64.px)
    )
}
