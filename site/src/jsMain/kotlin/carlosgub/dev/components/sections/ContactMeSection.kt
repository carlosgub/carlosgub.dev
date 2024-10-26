package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.models.Section
import carlosgub.dev.components.styles.ContactMeButton
import carlosgub.dev.components.styles.ContactMeSectionStyle
import carlosgub.dev.components.styles.MessageContactMeStyle
import carlosgub.dev.components.styles.components.H4Style
import carlosgub.dev.components.styles.font.regular
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.components.widgets.Button
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P

@Composable
fun ContactMeSection() {
    Box(
        modifier = Modifier
            .id(Section.ContactMe.id)
    ) {
        Column(
            modifier = listOf(
                ContactMeSectionStyle
            ).toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BackgroundContent()
        }
    }
}

@Composable
private fun BackgroundContent() {
    H4(
        attrs = H4Style
            .toModifier()
            .fillMaxWidth()
            .textAlign(TextAlign.Start)
            .regular()
            .color(WebColors.Black)
            .textAlign(TextAlign.Center)
            .toAttrs()
    ) {
        SpanText(
            "Do you have an idea in mind?"
        )
    }
    P(
        attrs = MessageContactMeStyle
            .toAttrs()
    ) {
        SpanText(
            "Chat with me"
        )
    }

    A(href = "mailto:carlosgub.dev@gmail.com") {
        Button(
            modifier = ContactMeButton.toModifier(),
            text = "Write me an email",
            primary = true,
        )
    }
}
