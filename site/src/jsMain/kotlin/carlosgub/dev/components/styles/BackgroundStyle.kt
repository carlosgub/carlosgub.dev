package carlosgub.dev.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val BackgroundSectionStyle by ComponentStyle {
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