package carlosgub.dev.components.styles

import carlosgub.dev.components.styles.font.semiBold
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.css.boxShadow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*

val toolbarHeight = 92.px

val ToolbarContainerStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(Color.floralwhite)
            .fillMaxWidth(100.percent)
            .position(Position.Fixed)
            .height(toolbarHeight)
            .padding(16.px)
            .top(0.px)
            .justifyContent(JustifyContent.Center)
            .zIndex(1)
            .display(DisplayStyle.Inline)

    }
    Breakpoint.LG {
        Modifier
            .padding(leftRight = 16.px, topBottom = 0.px)
            .display(DisplayStyle.Inherit)
            .position(Position.Relative)
    }
    Breakpoint.XL {
        Modifier
            .display(DisplayStyle.Inherit)
            .padding(leftRight = 16.px, topBottom = 0.px)
            .position(Position.Relative)
    }

}

val ToolbarStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth(100.percent)
            .maxWidth(1200.px)
            .justifyContent(JustifyContent.SpaceBetween)
    }
}

val ToolbarItemStyle = CssStyle {
    base {
        Modifier
            .color(Color.black)
            .semiBold()
            .fontSize(1.1.cssRem)
            .lineHeight(1.5)
            .padding(16.px)
            .textDecorationLine(TextDecorationLine.None)
            .fillMaxWidth()
    }
    Breakpoint.MD {
        Modifier
            .padding(8.px)
            .width(Width.FitContent)
    }
}

val ToolbarMenuMobileStyle = CssStyle {
    base {
        Modifier
            .border(
                2.px,
                style = LineStyle.Solid,
                color = Color.black
            )
            .styleModifier {
                boxShadow("6px 6px 0 0 black")
            }
            .fillMaxWidth()
            .backgroundColor(Color.floralwhite)
            .borderRadius(12.px)
            .margin(top = 8.px)
    }
}
