package carlosgub.dev.components.chip

import androidx.compose.runtime.Composable
import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.*

@Composable
internal fun Chip(
    text: String,
    fontFamily: String,
    fontSize: CSSSizeValue<CSSUnit.rem>,
    modifier: Modifier = Modifier,
) {
    SpanText(
        text = text,
        modifier = Modifier
            .styleModifier {
                property(
                    "display",
                    "-webkit-inline-box"
                )
            }
            .fontFamily(fontFamily)
            .fontSize(fontSize)
            .background(WebColors.Blue)
            .color(Color.white)
            .borderRadius(1.em)
            .padding(
                leftRight = 0.65.em,
                topBottom = 0.35.em
            ).then(modifier)
    )
}