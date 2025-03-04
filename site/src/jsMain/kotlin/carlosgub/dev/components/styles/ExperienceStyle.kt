package carlosgub.dev.components.styles

import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.styles.font.light
import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.link
import com.varabyte.kobweb.silk.style.selectors.visited
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val ExperienceSectionStyle = CssStyle {
    base {
        Modifier
            .width(100.percent)
            .maxWidth(1280.px)
            .padding(
                topBottom = 30.px,
                leftRight = 24.px
            )
    }
    Breakpoint.LG {
        Modifier
            .padding(
                topBottom = 50.px,
                leftRight = 120.px
            )
    }
}

val CompanyLink = CssStyle {
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

val PExperienceStyle = CssStyle {
    base {
        Modifier
            .light()
            .margin(bottom = 8.px)
            .fontSize(0.9.cssRem)
            .lineHeight(1.5)
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
