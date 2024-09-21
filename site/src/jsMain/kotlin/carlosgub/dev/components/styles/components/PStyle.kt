package carlosgub.dev.components.styles.components

import carlosgub.dev.components.styles.font.regular
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

val PStyle = CssStyle {
    base {
        Modifier
            .margin(bottom = 16.px)
            .regular()
            .fontSize(0.9.cssRem)
            .lineHeight(1.5)
    }
    Breakpoint.MD {
        Modifier
            .fontSize(0.95.cssRem)
    }
    Breakpoint.LG {
        Modifier
            .fontSize(1.cssRem)
    }
    Breakpoint.XL {
        Modifier
            .fontSize(1.cssRem)
    }
}