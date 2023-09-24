package carlosgub.dev.components.styles

import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.cssRem

val FooterStyle by ComponentStyle.base {
    Modifier
        .margin(top = 2.cssRem)
        .alignSelf(AlignSelf.Center)
        .fillMaxWidth()
}

val LinkFooterStyle by ComponentStyle {
    base {
        Modifier
            .bold()
            .color(WebColors.Blue)
            .styleModifier {
                property("text-decoration", "underline 0.15em rgba(0,123,255, 0)")
                property("text-underline-offset", "0.3em")
            }
    }
    hover {
        Modifier
            .styleModifier {
                property("text-decoration", "underline 0.15em rgba(0,123,255, 1)")
            }
    }
}

val ArrowUpStyle by ComponentStyle.base {
    Modifier.bold()
        .color(Colors.White)
        .fontSize(1.4.cssRem)
}