package carlosgub.dev.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val ProjectsSectionStyle = CssStyle {
    base {
        Modifier
            .width(100.percent)
            .padding(
                topBottom = 30.px
            )
    }
    Breakpoint.LG {
        Modifier
            .padding(
                topBottom = 50.px
            )
    }
}

val ProjectContentStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(top = 30.px)
    }
    Breakpoint.LG {
        Modifier.padding(top = 50.px)
    }
}

val ProjectContentTextStyle = CssStyle {
    base {
        Modifier.padding(
            topBottom = 50.px,
            leftRight = 24.px
        )
    }
    Breakpoint.LG {
        Modifier.padding(
            topBottom = 50.px,
            leftRight = 80.px
        )
    }
}