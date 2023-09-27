package carlosgub.dev.components.styles

import carlosgub.dev.components.keyframe.Shake
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.styles.font.light
import carlosgub.dev.components.styles.font.regular
import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*

val ExperienceSectionStyle by ComponentStyle {
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

val ReadMyResumeStyle by ComponentStyle {
    base {
        Modifier
            .fontSize(1.cssRem)
            .bold()
            .textDecorationLine(TextDecorationLine.None)
    }
    hover {
        Modifier
            .animation(
                Shake.toAnimation(
                    colorMode,
                    duration = 800.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
}

val CompanyLink by ComponentStyle {
    base {
        Modifier
            .color(WebColors.Blue)
            .bold()
            .textDecorationLine(TextDecorationLine.None)
            .fontSize(1.cssRem)

    }

    Breakpoint.LG {
        Modifier
            .fontSize(1.25.cssRem)
            .textDecorationLine(TextDecorationLine.None)
    }

    link {
        Modifier
            .color(WebColors.Blue)
            .textDecorationLine(TextDecorationLine.None)
    }
    active {
        Modifier
            .color(WebColors.Blue)
            .textDecorationLine(TextDecorationLine.None)
    }
    visited {
        Modifier
            .color(WebColors.Blue)
            .textDecorationLine(TextDecorationLine.None)
    }
}

val PExperienceStyle by ComponentStyle {
    base {
        Modifier
            .light()
            .fontSize(0.9.cssRem)
    }
    Breakpoint.MD {
        Modifier
            .fontSize(0.9.cssRem)
    }
    Breakpoint.LG {
        Modifier
            .fontSize(0.95.cssRem)
    }
    Breakpoint.XL {
        Modifier
            .fontSize(0.95.cssRem)
    }
}
