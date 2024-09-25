package carlosgub.dev.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

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
            .width(100.percent)
            .margin(top = toolbarHeight) // 92 px of the toolbar
            .padding(
                topBottom = 30.px,
                leftRight = 24.px
            )
    }
    Breakpoint.MD {
        Modifier
            .height(90.percent)
            .maxWidth(1280.px)
            .margin(top = 0.px) // Remove margin from toolbar
            .padding(
                topBottom = 50.px,
                leftRight = 50.px
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

val ProfilePhotoStyle = CssStyle {
    base {
        Modifier
            .fillMaxHeight(80.percent)
            .maxWidth(300.px)
            .borderRadius(4.em)
            .aspectRatio(3, 4)
    }
    Breakpoint.LG {
        Modifier
            .maxWidth(400.px)
    }
}