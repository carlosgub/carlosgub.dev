package carlosgub.dev.components.styles

import carlosgub.dev.components.styles.font.regular
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto

val GoToContactMeButton = CssStyle {
    base {
        Modifier
            .regular()
            .fontSize(1.cssRem)
            .width(auto)
            .padding(leftRight = 18.px, topBottom = 12.px)
            .styleModifier {
                property("--silk-button-height", "auto")
            }
    }

    Breakpoint.MD {
        Modifier
            .fontSize(1.2.cssRem)
    }
}

val IntroContainerStyle = CssStyle.base {
    Modifier
        .width(100.percent)
        .background(Color.floralwhite)
}

val IntroDesktopStyle = CssStyle.base {
    Modifier
        .maxWidth(1280.px)
        .padding(
            topBottom = 50.px,
            leftRight = 50.px
        )
}

val IntroMobileStyle = CssStyle {
    base {
        Modifier
            .width(100.percent)
            .margin(top = toolbarHeight) // 92 px of the toolbar
            .padding(
                topBottom = 30.px,
                leftRight = 24.px
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