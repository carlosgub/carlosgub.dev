package carlosgub.dev.components.styles

import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val BackToTopButtonStyle = CssStyle {
    base {
        Modifier
            .margin(
                right = 40.px,
                bottom = 40.px
            )
            .backgroundColor(WebColors.Blue)
            .cursor(Cursor.Pointer)
            .styleModifier {
                property("pointer-events", "auto")
            }
            .transition(
                CSSTransition(
                    property = "translate",
                    duration = 200.ms, timingFunction = AnimationTimingFunction.Ease
                )
            )
    }
    cssRule(":hover") {
        Modifier.translateY((-10).px)
    }
}