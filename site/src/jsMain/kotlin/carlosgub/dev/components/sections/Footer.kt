package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.styles.FooterStyle
import carlosgub.dev.components.styles.LinkFooterStyle
import carlosgub.dev.components.styles.components.LinkStyle
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.styles.font.regular
import carlosgub.dev.components.theme.WebColors
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
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
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
            MadeWithKobwebFooter()
            InspiredByFooter()
            DevelopedByFooter()
        }
        Row(
            modifier = Modifier.weight(1),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            if (breakpoint >= Breakpoint.LG) {
                Link(
                    path = "mailto:carlosgub.dev@gmail.com",
                    text = "EMAIL",
                    modifier = listOf(
                        LinkStyle,
                        LinkFooterStyle
                    ).toModifier()
                )
                Link(
                    path = "https://github.com/carlosgub",
                    text = "GITHUB",
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
                EmailIcon()
                GithubIcon()
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
        MadeWithKobwebFooter()
        InspiredByFooter()
        DevelopedByFooter()
        Row(
            modifier = Modifier.fillMaxWidth()
                .margin(top = 25.px, bottom = 30.px),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            EmailIcon()
            GithubIcon()
            TwitterIcon()
            LinkedinIcon()
            MediumIcon()
        }
    }
}

@Composable
private fun MadeWithKobwebFooter() {
    Row(
        Modifier.regular()
    ) {
        SpanText(
            text = "Made with "
        )
        Link(
            path = "https://github.com/varabyte/kobweb",
            text = "Kobweb",
            modifier = LinkStyle.toModifier()
        )
    }
}

@Composable
private fun InspiredByFooter() {
    Row(
        Modifier.regular()
    ) {
        SpanText(
            text = "Inspired by "
        )
        Link(
            path = "https://v3.brittanychiang.com",
            text = "Brittany Chiang",
            modifier = LinkStyle.toModifier()
        )
    }
}

@Composable
private fun DevelopedByFooter() {
    Row {
        SpanText(
            text = "Developed by Carlos Ugaz 2023",
            modifier = Modifier
                .bold()
        )
    }
}

@Composable
private fun EmailIcon() {
    A(
        href = "mailto:carlosgub.dev@gmail.com"
    ) {
        BSIcon(
            icon = BSIcons.ENVELOPE,
            size = 20.px,
            color = WebColors.Blue
        )
    }
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
