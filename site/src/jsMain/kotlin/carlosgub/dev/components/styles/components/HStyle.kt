package carlosgub.dev.components.styles.components

import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.styles.font.light
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

val H1Style = CssStyle {
    base {
        Modifier
            .margin(bottom = 8.px)
            .lineHeight(1.2)
            .bold()
            .fontSize(4.cssRem)

    }

    Breakpoint.LG {
        Modifier
            .fontSize(6.cssRem)
    }
}

val H2Style = CssStyle {
    base {
        Modifier
            .margin(bottom = 8.px)
            .lineHeight(1.2)
            .light()
            .textAlign(TextAlign.Start)
            .fontSize(2.5.cssRem)

    }

    Breakpoint.MD {
        Modifier
            .fontSize(2.5.cssRem)
    }
}

val H3Style = CssStyle {
    base {
        Modifier
            .margin(bottom = 8.px)
            .light()
            .textAlign(TextAlign.Start)
            .fontSize(1.5.cssRem)

    }

    Breakpoint.LG {
        Modifier
            .fontSize(1.75.cssRem)
    }
}

val H4Style = CssStyle {
    base {
        Modifier
            .margin(bottom = 8.px)
            .light()
            .textAlign(TextAlign.Start)
            .fontSize(1.5.cssRem)

    }

    Breakpoint.LG {
        Modifier
            .fontSize(1.75.cssRem)
    }
}

val H6Style = CssStyle {
    base {
        Modifier
            .margin(all = 0.cssRem)
            .light()
            .textAlign(TextAlign.Start)
            .fontSize(1.25.cssRem)

    }
}