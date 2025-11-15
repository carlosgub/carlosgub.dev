package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.chip.Chip
import carlosgub.dev.components.styles.CompanyLink
import carlosgub.dev.components.styles.ExperienceSectionStyle
import carlosgub.dev.components.styles.PExperienceStyle
import carlosgub.dev.components.styles.components.*
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.styles.font.light
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.model.Language
import carlosgub.dev.model.Section
import carlosgub.dev.model.experience.ExperienceSection
import carlosgub.dev.model.experience.ExperienceEnglish
import carlosgub.dev.model.experience.ExperienceSpanish
import carlosgub.dev.model.experience.Company
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceSection(language: Language) {
    val experience = if (language == Language.English) ExperienceEnglish else ExperienceSpanish
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
                    .id(Section.Experience.id)
        ) {
            ExperienceContent(experience)
        }
    }
}

@Composable
private fun ExperienceContent(experience: ExperienceSection) {
    H4(
        attrs = H4Style
            .toModifier()
            .fillMaxWidth()
            .bold()
            .color(WebColors.Blue)
            .textAlign(TextAlign.Center)
            .toAttrs()
    ) {
        SpanText(
            experience.title
        )
    }
    WorkContainer(experience.firstWork)
    HorizontalDivider(HRStyle.toModifier())
    WorkContainer(experience.secondWork)
    A(
        href = experience.resumeHref,
        attrs = MovingText
            .toAttrs()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            SpanText(experience.seeResume)
            FaArrowRight(size = IconSize.SM)
        }
    }
}

@Composable
private fun WorkContainer(
    work: Company
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
            href = work.url
        ) {
            SpanText(
                text = work.name,
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
            Text(work.time)
        }
        P(
            attrs = PExperienceStyle
                .toModifier()
                .fillMaxWidth()
                .toAttrs()
        ) {
            Text(
                work.description
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
            work.stackList.forEach { stack ->
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
