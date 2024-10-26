package carlosgub.dev.components.styles

import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.styles.font.regular
import carlosgub.dev.components.styles.font.semiBold
import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val ContactMeSectionStyle = CssStyle {
    base {
        Modifier
            .width(100.percent)
            .background()
            .maxWidth(1280.px)
            .padding(
                topBottom = 50.px,
                leftRight = 24.px
            )

    }
    Breakpoint.LG {
        Modifier
            .padding(
                topBottom = 80.px,
                leftRight = 120.px
            )
    }
}

val ContactMeButton = CssStyle {
    base {
        Modifier
            .regular()
            .fontSize(1.cssRem)
            .padding(12.px  )
            .styleModifier {
                property("--silk-button-height","auto")
            }
    }

    Breakpoint.MD {
        Modifier
            .fontSize(1.2.cssRem)
    }
}

val MessageContactMeStyle = CssStyle {
    base {
        Modifier
            .margin(bottom = 8.px)
            .lineHeight(1.2)
            .bold()
            .fontSize(2.5.cssRem)
            .fillMaxWidth()
            .textAlign(TextAlign.Start)
            .semiBold()
            .color(WebColors.Black)
            .textAlign(TextAlign.Center)
            .padding(topBottom = 16.px)

    }

    Breakpoint.LG {
        Modifier
            .fontSize(4.cssRem)
    }
}