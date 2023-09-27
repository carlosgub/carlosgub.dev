package carlosgub.dev.components.styles.components

import carlosgub.dev.components.styles.font.regular
import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.*
import org.jetbrains.compose.web.css.cssRem

val LinkStyle by ComponentStyle {
    base {
        Modifier
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