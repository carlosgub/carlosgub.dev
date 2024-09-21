package carlosgub.dev.components.styles.components

import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.styles.font.regular
import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssLayer
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.selectors.link
import com.varabyte.kobweb.silk.style.selectors.visited
import org.jetbrains.compose.web.css.cssRem

val LinkStyle = CssStyle {
    base {
        Modifier
            .margin(all = 0.cssRem)
            .fontSize(1.25.cssRem)
            .regular()
            .color(WebColors.Blue)
            .styleModifier {
                property("text-decoration", "underline 0.1em rgba(0,123,255, 0)")
                property("transition", "text-decoration-color .2s ease-in-out")
                property("text-underline-offset", "0.1em")
            }
    }
    hover {
        Modifier.color(WebColors.Blue)
            .styleModifier {
                property("text-decoration-color", "rgba(0,123,255, 1)")
            }
    }
    link {
        Modifier.color(WebColors.Blue)
    }
    active {
        Modifier.color(WebColors.Blue)
    }
    visited {
        Modifier.color(WebColors.Blue)
    }
}

val LinkTalkStyle = CssStyle {
    base {
        Modifier
            .fontSize(0.85.cssRem)
            .bold()
    }
    Breakpoint.MD {
        Modifier
            .fontSize(0.85.cssRem)
    }
    Breakpoint.LG {
        Modifier
            .fontSize(0.95.cssRem)
    }
    Breakpoint.XL {
        Modifier
            .fontSize(1.cssRem)
    }
}
