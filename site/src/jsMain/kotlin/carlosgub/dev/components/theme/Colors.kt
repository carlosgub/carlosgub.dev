package carlosgub.dev.components.theme

import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.ui.graphics.Colors
import org.jetbrains.compose.web.css.CSSColorValue

object WebColors {
    val Blue get() = com.varabyte.kobweb.compose.ui.graphics.Color.rgb(0x00, 0x5A, 0xFF)


    val colorOpposite by StyleVariable<CSSColorValue>(Colors.Black)
    var colorOppositeValue = colorOpposite.value()
}