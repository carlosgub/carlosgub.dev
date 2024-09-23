package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.models.Section
import carlosgub.dev.components.styles.AboutMeSectionStyle
import carlosgub.dev.components.styles.components.H3Style
import carlosgub.dev.components.styles.components.PStyle
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
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
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutMeSection() {
    Box(
        modifier = Modifier
            .id(Section.Experience.id)
    ) {
        Column(
            modifier = listOf(
                AboutMeSectionStyle
            ).toModifier()
        ) {
            BackgroundContent()
        }
    }
}

@Composable
private fun BackgroundContent() {
    H3(
        attrs = H3Style
            .toModifier()
            .fillMaxWidth()
            .textAlign(TextAlign.Start)
            .bold()
            .color(WebColors.Blue)
            .textAlign(TextAlign.Center)
            .toAttrs()
    ) {
        SpanText(
            "About Me"
        )
    }
    P(
        attrs = PStyle
            .toModifier()
            .padding(top = 16.px)
            .toAttrs()
    ) {
        Text(
            "Hello! I'm Carlos, a Senior Software Engineer, specializing in Mobile app " +
                    "development and creating cross-platform solutions using Kotlin Multiplatform. " +
                    "With seven years of experience, I've led teams in various industries including " +
                    "banking, education, e-commerce, and media."
        )
        Br()
        Br()
        Text(
            "I'm an person enthusiast who thrives on exploring emerging technologies and staying " +
                    "at the cutting edge of the field. Let's collaborate to bring innovative " +
                    "mobile solutions to life!"
        )
        Br()
        Br()
        Text(
            "If you're seeking a Senior Software Engineer with a deep passion for Mobile development, " +
                    "a track record of leadership, and commitment to staying ahead of the curve, I'd love " +
                    "to connect and discuss how I can bring my skills and enthusiasm to your next project."
        )
    }
}
