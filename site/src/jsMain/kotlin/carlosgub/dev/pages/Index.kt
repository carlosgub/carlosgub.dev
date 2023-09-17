package carlosgub.dev.pages

import androidx.compose.runtime.Composable
import carlosgub.dev.components.layouts.PageLayout
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.numericAuto
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.CSSUnit.Companion.rem
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Text

val SectionModifier by ComponentStyle.base {
    Modifier
        .width(100.vw)
        .height(98.vh)
        .maxWidth(1440.px)
}

@Page
@Composable
fun HomePage() {
    PageLayout("Welcome to my website!") {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = SectionModifier.toModifier()
                    .padding(
                        topBottom = 100.px,
                        leftRight = 120.px
                    ),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                H1(
                    attrs = Modifier
                        .fontWeight(FontWeight.Light)
                        .textAlign(TextAlign.Start)
                        .fontSize(2.5.cssRem)
                        .toAttrs()
                ) {
                    SpanText(
                        "Hi!"
                    )
                }
                H2(
                    attrs = Modifier
                        .fontWeight(FontWeight.Light)
                        .maxWidth(700.px)
                        .textAlign(TextAlign.Start)
                        .fontSize(2.5.cssRem)
                        .toAttrs()
                ) {
                    SpanText(
                        "I'm "
                    )
                    SpanText(
                        "Carlos Ugaz",
                        modifier = Modifier.fontWeight(FontWeight.SemiBold)
                    )
                    SpanText(
                        ", a front-end software engineer focused on building beautiful mobile applications"
                    )
                }
                H3(
                    attrs = Modifier
                        .fontWeight(FontWeight.Normal)
                        .textAlign(TextAlign.Start)
                        .fontSize(1.25.cssRem)
                        .toAttrs()
                ) {
                    SpanText("Get in touch")
                }
            }
            /*Column(
                modifier = SectionModifier.toModifier()
            ) {
                Text("Hello")
            }*/
        }
    }
}
