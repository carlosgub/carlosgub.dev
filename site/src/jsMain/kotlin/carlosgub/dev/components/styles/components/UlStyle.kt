package carlosgub.dev.components.styles.components

import carlosgub.dev.components.styles.font.regular
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem

val UlStyle by ComponentStyle {
    base {
        Modifier
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