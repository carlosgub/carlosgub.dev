package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignSelf
import com.varabyte.kobweb.compose.ui.modifiers.borderTop
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.SilkTheme
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

val FooterStyle by ComponentStyle.base {
    Modifier
        .margin(top = 2.cssRem)
        .borderTop(1.px, LineStyle.Solid, SilkTheme.palettes[colorMode].border)
        .padding(topBottom = 1.cssRem, leftRight = 4.cssRem)
        .alignSelf(AlignSelf.Center)
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Column(FooterStyle.toModifier().then(modifier)) {
        Row {
            SpanText("Made with ")
            Link("https://github.com/varabyte/kobweb", "Kobweb")
        }
    }
}
