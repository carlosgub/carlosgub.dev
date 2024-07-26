package carlosgub.dev.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val BackgroundSectionStyle = CssStyle {
    base {
        Modifier
            .width(100.percent)
            .maxWidth(1280.px)
            .padding(
                topBottom = 30.px,
                leftRight = 70.px
            )
    }
    Breakpoint.LG {
        Modifier
            .padding(
                topBottom = 70.px,
                leftRight = 120.px
            )
    }
    Breakpoint.XL {
        Modifier
            .padding(
                topBottom = 100.px,
                leftRight = 150.px
            )
    }
}