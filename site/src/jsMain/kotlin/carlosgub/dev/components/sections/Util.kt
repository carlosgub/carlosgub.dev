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
}

val FirstSectionModifier by ComponentStyle {
    base {
        Modifier
            .width(100.percent)
            .height(100.vh)
            .maxWidth(1440.px)
            .padding(
                topBottom = 50.px,
                leftRight = 70.px
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
    0.percent {
        Modifier
            .margin(top = 50.px)
            .opacity(0)
    }
    100.percent {
        Modifier
            .margin(top = 0.px)
            .opacity(1)
    }
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

val H1Style by ComponentStyle {
    base {
        Modifier
            .fontWeight(FontWeight.Light)
            .textAlign(TextAlign.Start)
            .fontSize(1.75.cssRem)

    }

    Breakpoint.LG {
        Modifier
            .fontSize(2.5.cssRem)
    }
}

val H2Style by ComponentStyle {
    base {
        Modifier
            .fontWeight(FontWeight.Light)
            .textAlign(TextAlign.Start)
            .fontSize(1.75.cssRem)

    }

    Breakpoint.LG {
        Modifier
            .fontSize(2.5.cssRem)
    }
}

val H3Style by ComponentStyle {
    base {
        Modifier
            .fontWeight(FontWeight.Light)
            .textAlign(TextAlign.Start)
            .fontSize(1.cssRem)

    }

    Breakpoint.LG {
        Modifier
            .fontSize(1.25.cssRem)
    }
}