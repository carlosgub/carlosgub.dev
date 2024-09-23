package carlosgub.dev.components.styles

import carlosgub.dev.components.styles.font.regular
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*

val IntroContainerKeyFrames = Keyframes {
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

val IntroSectionStyle = CssStyle {
    base {
        Modifier
            .background(Color.floralwhite)
            .width(100.percent)
            .padding(
                topBottom = 50.px,
                leftRight = 24.px
            )
    }
    Breakpoint.MD {
        Modifier
            .fillMaxHeight()
    }
    Breakpoint.LG {
        Modifier
            .fillMaxHeight()
            .padding(
                topBottom = 100.px,
                leftRight = 120.px
            )
    }
}

val TagLineStyle = CssStyle {
    base {
        Modifier
            .width(100.percent)
    }
    Breakpoint.LG {
        Modifier
            .width(70.percent)
    }
}

val ToolbarOptionStyle = CssStyle {
    base {
        Modifier
            .color(Color.white)
            .textAlign(TextAlign.Center)
            .regular()
            .fontSize(0.9.cssRem)
            .lineHeight(1.5)
    }
    Breakpoint.MD {
        Modifier
            .fontSize(0.95.cssRem)
    }
    Breakpoint.LG {
        Modifier
            .fontSize(1.cssRem)
    }
    Breakpoint.XL {
        Modifier
            .fontSize(1.cssRem)
    }
}

val ProfilePhotoStyle = CssStyle {
    base {
        Modifier
            .maxWidth(300.px)
            .borderRadius(4.em)
    }
    Breakpoint.LG {
        Modifier
            .maxWidth(400.px)
    }
}