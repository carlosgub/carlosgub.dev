package carlosgub.dev.components.styles

import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.components.theme.WebColors.Black
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.selectors.link
import com.varabyte.kobweb.silk.style.selectors.visited
import org.jetbrains.compose.web.css.cssRem

val FooterStyle = CssStyle.base {
    Modifier
        .margin(top = 2.cssRem)
        .alignSelf(AlignSelf.Center)
        .fillMaxWidth()
}

val LinkFooterStyle = CssStyle {
    base {
        Modifier
            .fontSize(1.cssRem)
            .bold()
            .color(WebColors.Blue)
            .styleModifier {
                property("text-decoration", "underline 0.15em rgba(0,123,255, 0)")
                property("text-underline-offset", "0.3em")
            }
    }
    hover {
        Modifier
            .styleModifier {
                property("text-decoration", "underline 0.15em rgba(0,123,255, 1)")
            }
    }
}

val DevelopedByLink = CssStyle {
    base {
        Modifier
            .color(Black)
            .bold()
            .textDecorationLine(TextDecorationLine.None)
            .fontSize(1.cssRem)
    }

    link {
        Modifier
            .color(Black)
            .textDecorationLine(TextDecorationLine.None)
    }
    active {
        Modifier
            .color(Black)
            .textDecorationLine(TextDecorationLine.None)
    }
    visited {
        Modifier
            .color(Black)
            .textDecorationLine(TextDecorationLine.None)
    }
}