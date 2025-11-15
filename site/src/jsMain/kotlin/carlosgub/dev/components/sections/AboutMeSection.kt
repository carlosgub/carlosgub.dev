package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.model.Section
import carlosgub.dev.components.styles.AboutMeSectionStyle
import carlosgub.dev.components.styles.components.H4Style
import carlosgub.dev.components.styles.components.PStyle
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.model.Language
import carlosgub.dev.model.aboutme.AboutMeSection
import carlosgub.dev.model.aboutme.AboutMeEnglish
import carlosgub.dev.model.aboutme.AboutMeSpanish
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutMeSection(language: Language) {
    val aboutMe = if (language == Language.English) AboutMeEnglish else AboutMeSpanish
    Box(
        modifier = Modifier
            .id(Section.About.id)
    ) {
        Column(
            modifier = listOf(
                AboutMeSectionStyle
            ).toModifier()
        ) {
            BackgroundContent(aboutMe)
        }
    }
}

@Composable
private fun BackgroundContent(aboutMe: AboutMeSection) {
    H4(
        attrs = H4Style
            .toModifier()
            .fillMaxWidth()
            .textAlign(TextAlign.Start)
            .bold()
            .color(WebColors.Blue)
            .textAlign(TextAlign.Center)
            .toAttrs()
    ) {
        SpanText(
            aboutMe.title
        )
    }
    P(
        attrs = PStyle
            .toModifier()
            .padding(top = 16.px)
            .toAttrs()
    ) {
        Text(aboutMe.firstParagraph)
        Br()
        Br()
        Text(aboutMe.secondParagraph)
        Br()
        Br()
        Text(aboutMe.thirdParagraph)
    }
}
