@file:OptIn(ExperimentalComposeWebApi::class)

package carlosgub.dev.components.sections

import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

val SectionModifier by ComponentStyle.base {
    Modifier
        .width(100.percent)
        .height(100.vh)
        .maxWidth(1440.px)
}

val FormCheckInput by ComponentStyle.base {
    Modifier
        .minWidth(45.px)
        .height(25.px)
}

val FormCheck by ComponentStyle.base {
    Modifier
        .margin(leftRight = 12.px)
}

val LinkStyle by ComponentStyle {
    base {
        Modifier
            .color(WebColors.Blue)
            .styleModifier {
                property("text-decoration", "underline 0.1em rgba(0,123,255, 0)")
                property("transition", "text-decoration-color 300ms ease-in-out")
                property("text-underline-offset", "0.3em")
            }
    }
    hover {
        Modifier.color(WebColors.Blue)
            .styleModifier {
                property("text-decoration-color", "rgba(0,123,255, 1)")
            }
    }
    link {
        Modifier.color(WebColors.Blue)
    }
    active {
        Modifier.color(WebColors.Blue)
    }
    visited {
        Modifier.color(WebColors.Blue)
    }
}

val LinkFooterStyle by ComponentStyle {
    base {
        Modifier
            .fontWeight(FontWeight.SemiBold)
            .styleModifier {
                property("text-decoration", "underline 0.15em rgba(0,123,255, 0)")
            }
    }
}

val FadeContainerKeyFrames by Keyframes {
    0.percent { Modifier.opacity(0) }
    100.percent { Modifier.opacity(1) }
}

val FadeContainerStyle by ComponentStyle {
    base {
        Modifier
            .animation(
                FadeContainerKeyFrames.toAnimation(
                    colorMode,
                    duration = 1.s,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
}

val Shake by Keyframes {
    0.percent { Modifier.margin(left = 0.px) }
    50.percent { Modifier.margin(left = 20.px) }
    100.percent { Modifier.margin(left = 0.px) }
}

val ReadMyResumeStyle by ComponentStyle {
    base {
        Modifier
            .fontSize(1.25.cssRem)
            .fontWeight(FontWeight.SemiBold)
            .textDecorationLine(TextDecorationLine.None)
    }
    hover {
        Modifier
            .animation(
                Shake.toAnimation(
                    colorMode,
                    duration = 1.s,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
}

fun getH1Modifier(breakpoint: Breakpoint): Modifier {
    return Modifier
        .fontWeight(FontWeight.Light)
        .textAlign(TextAlign.Start)
        .fontSize(
            if (breakpoint < Breakpoint.LG) 1.75.cssRem else 2.5.cssRem
        )
}

fun getH2Modifier(breakpoint: Breakpoint): Modifier {
    return Modifier
        .fontWeight(FontWeight.Light)
        .textAlign(TextAlign.Start)
        .fontSize(
            if (breakpoint < Breakpoint.LG) 1.75.cssRem else 2.5.cssRem
        )
}

fun getH3Modifier(breakpoint: Breakpoint): Modifier {
    return Modifier
        .fontWeight(FontWeight.Light)
        .textAlign(TextAlign.Start)
        .fontSize(
            if (breakpoint < Breakpoint.LG) 1.cssRem else 1.25.cssRem
        )
}