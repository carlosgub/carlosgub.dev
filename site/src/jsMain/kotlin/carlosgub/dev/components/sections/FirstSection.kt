package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.stevdza.san.kotlinbs.components.BSIcon
import com.stevdza.san.kotlinbs.forms.BSSwitch
import com.stevdza.san.kotlinbs.icons.BSIcons
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.*

@Composable
fun FirstSection(modifier: Modifier = Modifier) {
    var colorMode by ColorMode.currentState
    val breakpoint = rememberBreakpoint()
    val themeColor = if (colorMode.isDark) {
        Colors.White
    } else {
        Colors.Black
    }
    val actionColor = if (colorMode.isDark) {
        Colors.Blue
    } else {
        Colors.DarkGray
    }
    Box(
        modifier = Modifier.width(100.vw).then(modifier),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = SectionModifier.toModifier()
                .padding(
                    topBottom = if (breakpoint < Breakpoint.LG) 50.px else 100.px,
                    leftRight = if (breakpoint < Breakpoint.LG) 70.px else 120.px
                ),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            H1(
                attrs = getH1Modifier(breakpoint)
                    .toAttrs()
            ) {
                SpanText(
                    "Hi!"
                )
            }
            H2(
                attrs = getH2Modifier(breakpoint)
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
                attrs = getH3Modifier(breakpoint)
                    .toAttrs()
            ) {
                SpanText("Get in touch ")
                Link("mailto:carlosgabrielugazburga@gmail.com", "carlosgabrielugazburga@gmail.com")
                P()
                A(
                    href = "/resume.pdf",
                    attrs = Modifier
                        .color(themeColor)
                        .fontSize(1.25.cssRem)
                        .fontWeight(FontWeight.SemiBold)
                        .textDecorationLine(TextDecorationLine.None)
                        .toAttrs()

                ) {
                    Text(
                        "View My Resume"
                    )
                    BSIcon(
                        icon = BSIcons.ARROW_RIGHT_SQUARE,
                        size = 20.px,
                        color = actionColor,
                        modifier = Modifier
                            .padding(left = 16.px)
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
            horizontalArrangement = Arrangement.End
        ) {
            BSIcon(
                icon = BSIcons.SUN,
                size = 1.cssRem,
                color = themeColor,
                modifier = Modifier.padding(right = 8.px)
            )
            BSSwitch(
                label = "",
                defaultChecked = colorMode.isDark,
                onClick = {
                    colorMode = colorMode.opposite
                },
                modifier = Modifier
                    .height(45.px)
            )
            BSIcon(
                icon = BSIcons.MOON,
                size = 1.cssRem,
                color = themeColor
            )
        }
    }
}
