package carlosgub.dev.components.styles.components

import carlosgub.dev.components.keyframe.Shake
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val MovingText = CssStyle {
    base {
        Modifier
            .margin(all = 0.cssRem)
            .margin(top = 16.px)
            .color(WebColors.Blue)
            .fontSize(1.25.cssRem)
            .bold()
            .textDecorationLine(TextDecorationLine.None)
    }
    hover {
        Modifier
            .animation(
                Shake.toAnimation(
                    colorMode = colorMode,
                    duration = 800.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
}