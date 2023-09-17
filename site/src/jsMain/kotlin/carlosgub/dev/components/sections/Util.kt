package carlosgub.dev.components.sections

import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
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