package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import carlosgub.dev.components.styles.IntroSectionStyle
import carlosgub.dev.components.styles.SectionModifier
import carlosgub.dev.components.styles.components.H1Style
import carlosgub.dev.components.styles.components.H2Style
import carlosgub.dev.components.styles.components.H6Style
import carlosgub.dev.components.styles.components.LinkStyle
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors.colorOppositeValue
import com.varabyte.kobweb.compose.css.WordBreak
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.isExporting
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Switch
import com.varabyte.kobweb.silk.components.icons.fa.FaMoon
import com.varabyte.kobweb.silk.components.icons.fa.FaSun
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2

@Composable
fun IntroSection() {
    var colorMode by ColorMode.currentState
    Box(
        modifier = SectionModifier
            .toModifier()
            .width(100.percent),
        contentAlignment = Alignment.TopCenter
    ) {
        if (!rememberPageContext().isExporting) {
            Column(
                modifier = listOf(
                    IntroSectionStyle
                ).toModifier(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                H1(
                    attrs = H1Style
                        .toAttrs()
                ) {
                    SpanText(
                        "Hey there!"
                    )
                }
                H2(
                    attrs = H2Style
                        .toAttrs()
                ) {
                    SpanText(
                        "I'm "
                    )
                    SpanText(
                        "Carlos Ugaz",
                        modifier = Modifier.bold()
                    )
                    SpanText(
                        ", a mobile software engineer focused on building awesome mobile applications"
                    )
                }
                Row(
                    modifier = H6Style
                        .toModifier(),
                ) {
                    SpanText("Get in touch ")
                    Link(
                        path = "mailto:carlosgub.dev@gmail.com",
                        text = "carlosgub.dev@gmail.com",
                        modifier = LinkStyle.toModifier()
                            .wordBreak(WordBreak.BreakAll)
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(
                    top = 20.px,
                    right = 30.px
                ).fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaSun(
                size = IconSize.SM,
                modifier = Modifier.color(colorOppositeValue)
            )
            Switch(
                modifier = Modifier
                    .margin(leftRight = 12.px),
                checked = colorMode.isDark,
                onCheckedChange = { isDark ->
                    colorMode = colorMode.opposite
                    colorOppositeValue = if (isDark) {
                        Colors.White
                    } else {
                        Colors.Black
                    }
                },
            )
            FaMoon(
                size = IconSize.SM,
                modifier = Modifier.color(colorOppositeValue)
            )
        }
    }
}
