package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.styles.DevelopedByLink
import carlosgub.dev.components.styles.FooterStyle
import carlosgub.dev.components.styles.LinkFooterStyle
import carlosgub.dev.components.styles.components.LinkStyle
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.components.theme.WebColors.colorOpposite
import com.stevdza.san.kotlinbs.components.BSIcon
import com.stevdza.san.kotlinbs.icons.BSIcons
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A

@Composable
fun Footer(breakpoint: Breakpoint) {
    if (breakpoint >= Breakpoint.MD) {
        FooterHorizontal(breakpoint)
    } else {
        FooterVertical()
    }
}

@Composable
private fun FooterHorizontal(breakpoint: Breakpoint) {
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
            if (breakpoint >= Breakpoint.LG) {
                Link(
                    path = "https://github.com/carlosgub",
                    text = "GITHUB",
                    modifier = listOf(
                        LinkStyle,
                        LinkFooterStyle
                    ).toModifier()
                )
                Link(
                    path = "https://www.youtube.com/@carlosgub",
                    text = "YOUTUBE",
                    modifier = listOf(
                        LinkStyle,
                        LinkFooterStyle
                    ).toModifier()
                )
                Link(
                    path = "https://twitter.com/carlosgub",
                    text = "TWITTER",
                    modifier = listOf(
                        LinkStyle,
                        LinkFooterStyle
                    ).toModifier()
                )
                Link(
                    path = "https://linkedin.com/in/carlosgub",
                    text = "LINKEDIN",
                    modifier = listOf(
                        LinkStyle,
                        LinkFooterStyle
                    ).toModifier()
                )
                Link(
                    path = "https://medium.com/@carlosgub",
                    text = "MEDIUM",
                    modifier = listOf(
                        LinkStyle,
                        LinkFooterStyle
                    ).toModifier()
                )
            } else {
                GithubIcon()
                YoutubeIcon()
                TwitterIcon()
                LinkedinIcon()
                MediumIcon()
            }
        }
    }
}


@Composable
private fun FooterVertical() {
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
            GithubIcon()
            YoutubeIcon()
            TwitterIcon()
            LinkedinIcon()
            MediumIcon()
        }
    }
}

@Composable
private fun DevelopedByFooter() {
    Link(
        path = "https://github.com/carlosgub/carlosgub.dev",
        text = "Developed by Carlos Ugaz 2024",
        modifier = DevelopedByLink.toModifier()
            .setVariable(colorOpposite, WebColors.colorOppositeValue)
    )
}

@Composable
private fun GithubIcon() {
    A(
        href = "https://github.com/carlosgub"
    ) {
        BSIcon(
            icon = BSIcons.GITHUB,
            size = 20.px,
            color = WebColors.Blue
        )
    }
}

@Composable
private fun YoutubeIcon() {
    A(
        href = "https://www.youtube.com/@carlosgub"
    ) {
        BSIcon(
            icon = BSIcons.YOUTUBE,
            size = 20.px,
            color = WebColors.Blue
        )
    }
}

@Composable
private fun TwitterIcon() {
    A(
        href = "https://twitter.com/carlosgub"
    ) {
        BSIcon(
            icon = BSIcons.TWITTER,
            size = 20.px,
            color = WebColors.Blue
        )
    }
}

@Composable
private fun LinkedinIcon() {
    A(
        href = "https://linkedin.com/in/carlosgub"
    ) {
        BSIcon(
            icon = BSIcons.LINKEDIN,
            size = 20.px,
            color = WebColors.Blue
        )
    }
}

@Composable
private fun MediumIcon() {
    A(
        href = "https://medium.com/@carlosgub"
    ) {
        BSIcon(
            icon = BSIcons.MEDIUM,
            size = 20.px,
            color = WebColors.Blue
        )
    }
}
