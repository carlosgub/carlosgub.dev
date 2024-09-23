package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.chip.Chip
import carlosgub.dev.components.models.Section
import carlosgub.dev.components.models.Stack
import carlosgub.dev.components.styles.CompanyLink
import carlosgub.dev.components.styles.ExperienceSectionStyle
import carlosgub.dev.components.styles.PExperienceStyle
import carlosgub.dev.components.styles.components.*
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.styles.font.light
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.util.text.*
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceSection() {
    Box(
        modifier = Modifier
            .background(Color.floralwhite)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier =
            ExperienceSectionStyle
                .toModifier()
                .id(Section.About.id)
        ) {
            ExperienceContent()
        }
    }
}

@Composable
private fun ExperienceContent() {
    H3(
        attrs = H3Style
            .toModifier()
            .fillMaxWidth()
            .bold()
            .color(WebColors.Blue)
            .toAttrs()
    ) {
        SpanText(
            "My Experience"
        )
    }
    WorkContainer(
        workName = globant,
        workUrl = globantUrl,
        time = globantTime,
        description = globantDescription,
        stackList = globantStack
    )
    HorizontalDivider(HRStyle.toModifier())
    WorkContainer(
        workName = rappi,
        workUrl = rappiUrl,
        time = rappiTime,
        description = rappiDescription,
        stackList = rappiStack
    )
    A(
        href = "/resume.pdf",
        attrs = MovingText
            .toAttrs()

    ) {
        SpanText(
            "View Full Resume →"
        )
    }
}

@Composable
private fun WorkContainer(
    workName: String,
    workUrl: String,
    time: String,
    description: String,
    stackList: List<Stack>
) {
    Column(
        Modifier
            .fillMaxWidth()
            .margin(topBottom = 12.px)
    ) {
        A(
            attrs = H6Style
                .toModifier()
                .fillMaxWidth()
                .textDecorationLine(TextDecorationLine.None)
                .bold()
                .color(WebColors.Blue)
                .margin(0.px)
                .toAttrs(),
            href = workUrl
        ) {
            SpanText(
                text = workName,
                modifier = CompanyLink
                    .toModifier()
            )
        }
        P(
            attrs = PStyle
                .toModifier()
                .margin(bottom = 6.px)
                .light()
                .toAttrs()
        ) {
            Text(time)
        }
        P(
            attrs = PExperienceStyle
                .toModifier()
                .fillMaxWidth()
                .toAttrs()
        ) {
            Text(
                description
            )
        }
        Row(
            Modifier
                .display(DisplayStyle.Block)
                .fillMaxWidth()
                .margin(
                    topBottom = 6.px,
                )
        ) {
            stackList.forEach { stack ->
                Chip(
                    text = stack.id,
                    fontSize = 0.9.cssRem,
                    modifier = Modifier
                        .margin(
                            right = 12.px,
                            top = 8.px
                        ),
                )
            }
        }
    }
}
