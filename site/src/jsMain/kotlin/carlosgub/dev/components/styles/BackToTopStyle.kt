package carlosgub.dev.components.styles

import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.*

val BackToTopButtonStyle = CssStyle {
    base {
        Modifier
            .margin(
                right = 40.px,
                bottom = 40.px
            )
            .background(WebColors.Blue)
            .cursor(Cursor.Pointer)
            .color(Color.white)
            .padding(topBottom = 1.5.cssRem, leftRight = 1.25.cssRem)
            .borderRadius(0.8.em)
            .background(WebColors.Blue)
            .styleModifier {
                property("pointer-events", "auto")
            }
            .transition(
                Transition.of(
                    property = "translate",
                    duration = 200.ms, timingFunction = AnimationTimingFunction.Ease
                )
            )
    }
    hover {
        Modifier
            .translateY((-10).px)
    }
}