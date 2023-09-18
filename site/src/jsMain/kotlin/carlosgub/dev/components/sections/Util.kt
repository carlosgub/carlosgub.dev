package carlosgub.dev.components.sections

import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.vw

val SectionModifier by ComponentStyle.base {
    Modifier
        .width(100.vw)
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
        Modifier.color(WebColors.Blue)
    }
    hover {
        Modifier.color(WebColors.Blue)
    }
    link {
        Modifier.color(WebColors.Blue)
    }
    active {
        Modifier.color(WebColors.Blue)
    }
    visited  {
        Modifier.color(WebColors.Blue)
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