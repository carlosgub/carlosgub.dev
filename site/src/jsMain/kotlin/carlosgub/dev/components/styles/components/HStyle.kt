package carlosgub.dev.components.styles.components

import carlosgub.dev.components.styles.font.light
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem

val H1Style by ComponentStyle {
    base {
        Modifier
            .light()
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
            .light()
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
            .light()
            .textAlign(TextAlign.Start)
            .fontSize(1.25.cssRem)

    }

    Breakpoint.LG {
        Modifier
            .fontSize(1.75.cssRem)
    }
}

val H6Style by ComponentStyle {
    base {
        Modifier
            .light()
            .textAlign(TextAlign.Start)
            .fontSize(1.cssRem)

    }

    Breakpoint.LG {
        Modifier
            .fontSize(1.25.cssRem)
    }
}