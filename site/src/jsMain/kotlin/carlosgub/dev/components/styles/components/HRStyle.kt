package carlosgub.dev.components.styles.components

import com.varabyte.kobweb.compose.css.CSSColor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.cssRem

val HRStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .margin(topBottom = 1.cssRem)
            .color(CSSColor.Inherit)
            .opacity(0.25)
            .zIndex(0)

    }
}