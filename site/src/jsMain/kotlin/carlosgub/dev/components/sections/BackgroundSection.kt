package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text

@Composable
fun BackgroundSection() {
    Column(
        modifier = listOf(
            BackgroundSectionModifier
        ).toModifier()
    ) {
        H1(
            attrs = H3Style
                .toModifier()
                .fillMaxWidth()
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            SpanText(
                "About"
            )
        }
        P{
            Text("I'm currently a Senior Android Developer at ")
            Link(
                path = "https://www.globant.com/",
                text = "Globant",
                modifier = LinkStyle.toModifier()
            )
            Text(". I have six years of experience in Android application development using Kotlin and Java programming languages." +
                    "He is an Android Leader" +
                    "in his current workplace who has led up to three developers and is interested in researching emerging\n" +
                    "technologies. He has experience in banking, education, e-commerce, and media industries.")
             /*System Engineering from the Universidad de Lima, with six years of experience in\n" +
                    "Android application development using Kotlin and Java programming languages. He is an Android Leader\n" +
                    "in his current workplace who has led up to three developers and is interested in researching emerging\n" +
                    "technologies. He has experience in banking, education, e-commerce, and media industries.")*/
        }
    }
}
