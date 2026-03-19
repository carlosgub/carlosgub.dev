package carlosgub.dev.components.styles

import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.styles.font.regular
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.vh

val LinksPageStyle = CssStyle.base {
    Modifier
        .fillMaxSize()
        .minHeight(100.vh)
        .styleModifier {
            property("background-image", "url('kotlin_bg.png')")
            property("background-size", "cover")
            property("background-position", "center")
            property("background-repeat", "no-repeat")
            property("background-attachment", "fixed")
        }
        .padding(top = 50.px, bottom = 50.px)
}

val LinksSectionStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .maxWidth(500.px)
}

val LinkButtonStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .backgroundColor(Colors.White)
            .borderRadius(16.px)
            .padding(topBottom = 16.px, leftRight = 24.px)
            .margin(topBottom = 12.px)
            .cursor(Cursor.Pointer)
            .styleModifier {
                property("transition", "background-color 0.2s ease-in-out, transform 0.2s ease-in-out")
                property("text-decoration", "none")
                property("box-shadow", "0px 4px 12px rgba(0,0,0,0.08)")
            }
            .bold()
            .color(Color.rgb(30, 30, 30))
            .textAlign(com.varabyte.kobweb.compose.css.TextAlign.Center)
    }
    hover {
        Modifier
            .backgroundColor(Color.rgb(248, 248, 248))
            .styleModifier {
                property("transform", "translateY(-2px)")
                property("box-shadow", "0px 6px 16px rgba(0,0,0,0.12)")
            }
    }
}

val LinksTitleStyle = CssStyle.base {
    Modifier
        .color(Color.rgb(30, 30, 30))
        .margin(top = 16.px, bottom = 4.px)
        .bold()
}

val LinksSubtitleStyle = CssStyle.base {
    Modifier
        .color(Color.rgb(60, 60, 60))
        .margin(bottom = 32.px)
        .regular()
}
