package carlosgub.dev.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*

val IntroContainerKeyFrames by Keyframes {
    0.percent {
        Modifier
            .margin(top = 50.px)
            .opacity(0.1)
    }
    100.percent {
        Modifier
            .margin(top = 0.px)
            .opacity(1)
    }
}

val IntroSectionStyle by ComponentStyle {
    base {
        Modifier
            .width(100.percent)
            .height(100.vh)
            .maxWidth(1440.px)
            .padding(
                topBottom = 50.px,
                leftRight = 70.px
            )
            .animation(
                IntroContainerKeyFrames.toAnimation(
                    colorMode,
                    duration = 1.s,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
    Breakpoint.LG {
        Modifier
            .padding(
                topBottom = 100.px,
                leftRight = 120.px
            )
    }
}