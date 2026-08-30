package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.model.Section
import carlosgub.dev.components.styles.ContactMeButton
import carlosgub.dev.components.styles.ContactMeSectionStyle
import carlosgub.dev.components.styles.MessageContactMeStyle
import carlosgub.dev.components.styles.components.H4Style
import carlosgub.dev.components.styles.font.regular
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.components.widgets.Button
import carlosgub.dev.model.Language
import carlosgub.dev.model.contactme.ContactMeEnglish
import carlosgub.dev.model.contactme.ContactMeSection
import carlosgub.dev.model.contactme.ContactMeSpanish
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P

@Composable
fun ContactMeSection(language: Language) {
    val contactMeSection = if (language == Language.English) ContactMeEnglish else ContactMeSpanish
    Box(
        modifier = Modifier
            .background(Color.floralwhite)
            .fillMaxWidth()
            .id(Section.ContactMe.id)
    ) {
        Column(
            modifier = listOf(
                ContactMeSectionStyle
            ).toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactMeContent(contactMeSection)
        }
    }
}

@Composable
private fun ContactMeContent(contactMeSection: ContactMeSection) {
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
        SpanText(contactMeSection.firstParagraph)
    }
    P(
        attrs = MessageContactMeStyle
            .toAttrs()
    ) {
        SpanText(contactMeSection.secondParagraph)
    }

    A(href = "mailto:carlosgub.dev@gmail.com") {
        Button(
            modifier = ContactMeButton.toModifier(),
            text = contactMeSection.buttonText,
            primary = true,
        )
    }
}
