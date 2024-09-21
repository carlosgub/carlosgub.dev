package carlosgub.dev.components.styles.components

import carlosgub.dev.components.styles.font.regular
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem

val UlStyle = CssStyle {
    base {
        Modifier
            .margin(all = 0.cssRem)
            .regular()
            .fontSize(0.85.cssRem)
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