package carlosgub.dev.components.styles

import carlosgub.dev.components.styles.font.semiBold
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.CSSAutoKeyword

val ToolbarContainerStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(Color.floralwhite)
            .fillMaxWidth(100.percent)
            .position(Position.Fixed)
            .height(92.px)
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
            .fontSize(0.9.cssRem)
            .lineHeight(1.5)
            .padding(8.px)
            .textDecorationLine(TextDecorationLine.None)
            .fillMaxWidth()
    }
    Breakpoint.MD {
        Modifier
            .width(Width.FitContent)
            .fontSize(0.95.cssRem)
    }
    Breakpoint.LG {
        Modifier
            .width(Width.FitContent)
            .fontSize(1.cssRem)
    }
    Breakpoint.XL {
        Modifier
            .width(Width.FitContent)
            .fontSize(1.cssRem)
    }
}
