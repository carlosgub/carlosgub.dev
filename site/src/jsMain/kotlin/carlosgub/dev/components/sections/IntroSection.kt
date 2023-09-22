package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.stevdza.san.kotlinbs.components.BSIcon
import com.stevdza.san.kotlinbs.forms.BSSwitch
import com.stevdza.san.kotlinbs.icons.BSIcons
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.isExporting
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun IntroSection() {
    var colorMode by ColorMode.currentState
    val themeColor = if (colorMode.isDark) {
        Colors.White
    } else {
        Colors.Black
    }
    Box(
        modifier = SectionModifier
            .toModifier()
            .width(100.percent),
        contentAlignment = Alignment.TopCenter
    ) {
        /** The following section animates in, and if we include it in the export,
        the page will animate twice when it loads (once when you first visit
        the page, and again when it rebuilds itself) **/
        if (!rememberPageContext().isExporting) {
            Column(
                modifier = listOf(
                    IntroSectionModifier
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
                        modifier = Modifier.fontWeight(FontWeight.SemiBold)
                    )
                    SpanText(
                        ", a mobile software engineer focused on building awesome mobile applications"
                    )
                }
                H3(
                    attrs = H6Style
                        .toAttrs()
                ) {
                    SpanText("Get in touch ")
                    Link(
                        path = "mailto:carlosgub.dev@gmail.com",
                        text = "carlosgub.dev@gmail.com",
                        modifier = LinkStyle.toModifier()
                    )
                    P()
                    A(
                        href = "/resume.pdf",
                        attrs = ReadMyResumeStyle
                            .toModifier()
                            .color(themeColor)
                            .toAttrs()

                    ) {
                        Text(
                            "View My Resume"
                        )
                        BSIcon(
                            icon = BSIcons.ARROW_RIGHT,
                            size = 20.px,
                            color = themeColor,
                            modifier = Modifier
                                .padding(left = 16.px)
                        )
                    }
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
            BSIcon(
                icon = BSIcons.SUN,
                size = 1.cssRem,
                color = themeColor,
                modifier = Modifier
                    .size(17.px)
            )
            BSSwitch(
                label = "",
                defaultChecked = colorMode.isDark,
                onClick = {
                    colorMode = colorMode.opposite
                }
            )
            BSIcon(
                icon = BSIcons.MOON,
                size = 1.cssRem,
                color = themeColor,
                modifier = Modifier
                    .size(17.px)
            )
        }
    }
}
