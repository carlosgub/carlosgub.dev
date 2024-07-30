package carlosgub.dev.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.vh

val SectionModifier = CssStyle.base {
    Modifier
        .width(100.percent)
        .height(100.vh)
}