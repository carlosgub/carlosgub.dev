package carlosgub.dev.components.styles

import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val BackToTopButtonStyle by ComponentStyle {
    base {
        Modifier
            .size(50.px)
            .margin(
                right = 40.px,
                bottom = 40.px
            )
            .borderRadius(20.percent)
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
    hover {
        Modifier.translateY((-10).px)
    }
}