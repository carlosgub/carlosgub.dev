package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.chip.Chip
import carlosgub.dev.components.styles.ProjectContentStyle
import carlosgub.dev.components.styles.ProjectContentTextStyle
import carlosgub.dev.components.styles.ProjectsSectionStyle
import carlosgub.dev.components.styles.components.H3Style
import carlosgub.dev.components.styles.components.H4Style
import carlosgub.dev.components.styles.components.MovingText
import carlosgub.dev.components.styles.components.PStyle
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.model.Language
import carlosgub.dev.model.Section
import carlosgub.dev.model.project.Project
import carlosgub.dev.model.project.ProjectEnglish
import carlosgub.dev.model.project.ProjectSection
import carlosgub.dev.model.project.ProjectSpanish
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun ProjectsSection(language: Language) {
    val project = if (language == Language.English) ProjectEnglish else ProjectSpanish
    Box(
        modifier = Modifier
            .id(Section.Projects.id)
    ) {
        Column(
            modifier = listOf(
                ProjectsSectionStyle
            ).toModifier()
        ) {
            ProjectsContent(project)
        }
    }
}

@Composable
private fun ProjectsContent(projectSection: ProjectSection) {
    H4(
        attrs = H4Style
            .toModifier()
            .fillMaxWidth()
            .textAlign(TextAlign.Center)
            .bold()
            .color(WebColors.Blue)
            .toAttrs()
    ) {
        /*SpanText(
            Section.Projects.text
        )*/
    }
    ProjectsHorizontal(projectSection)
    ProjectsVertical(projectSection)
}

@Composable
private fun ProjectsHorizontal(projectSection: ProjectSection) {
    Column(
        modifier = Modifier.displayIfAtLeast(Breakpoint.MD)
    ) {
        PiggyBankHorizontal(projectSection.firstProject)
        PersonalWebsiteHorizontal(projectSection.secondProject)
    }
}

@Composable
private fun ProjectsVertical(projectSection: ProjectSection) {
    Column(
        modifier = Modifier.displayUntil(Breakpoint.MD)
    ) {
        PiggyBankVertical(projectSection.firstProject)
        PersonalWebsiteVertical(projectSection.secondProject)
    }
}

@Composable
private fun PiggyBankHorizontal(project: Project) {
    Row(
        modifier = ProjectContentStyle.toModifier(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageHorizontal(
            src = "/piggybank_project.webp",
            alt = "Piggy Bank Banner Project"
        )
        PiggyBankText(
            project = project,
            modifier = Modifier
                .fillMaxWidth(50.percent)
        )
    }
}


@Composable
private fun PersonalWebsiteHorizontal(project: Project) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PersonalWebsiteText(
            project = project,
            modifier = Modifier
                .fillMaxWidth(50.percent)
        )
        ImageHorizontal(
            src = "/carlosgub_project.webp",
            alt = "Personal Website Banner Project"
        )
    }
}

@Composable
private fun PiggyBankVertical(project: Project) {
    Column(
        modifier = ProjectContentStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageVertical(
            src = "/piggybank_project.webp",
            alt = "Piggy Bank Banner Image"
        )
        PiggyBankText(
            project = project,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
private fun PersonalWebsiteVertical(project: Project) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageVertical(
            "/carlosgub_project.webp",
            "Personal Website Banner Project"
        )
        PersonalWebsiteText(
            project = project,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
private fun PiggyBankText(
    project: Project,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .then(ProjectContentTextStyle.toModifier()),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .display(DisplayStyle.InlineBlock)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            project.stackList.forEach { stack ->
                ProjectChip(stack.id)
            }
        }
        H3(
            attrs = H3Style
                .toModifier()
                .fillMaxWidth()
                .textAlign(TextAlign.Start)
                .bold()
                .color(WebColors.Blue)
                .padding(top = 16.px)
                .toAttrs()
        ) {
            SpanText(
                project.name
            )
        }
        P(
            attrs = PStyle
                .toModifier()
                .padding(top = 16.px)
                .toAttrs()
        ) {
            Text(
                project.description
            )
        }
        A(
            href = "https://github.com/carlosgub/PiggyBank",
            attrs = MovingText.toAttrs()

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpanText(
                    project.actionButtonText
                )
                FaArrowRight(
                    size = IconSize.SM
                )
            }
        }
    }
}

@Composable
private fun PersonalWebsiteText(
    project: Project,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .then(ProjectContentTextStyle.toModifier()),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .display(DisplayStyle.InlineBlock)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            project.stackList.forEach { stack ->
                ProjectChip(stack.id)
            }
        }
        H3(
            attrs = H3Style
                .toModifier()
                .fillMaxWidth()
                .textAlign(TextAlign.Start)
                .bold()
                .color(WebColors.Blue)
                .padding(top = 16.px)
                .toAttrs()
        ) {
            SpanText(project.name)
        }
        P(
            attrs = PStyle
                .toModifier()
                .padding(top = 16.px)
                .toAttrs()
        ) {
            Text(project.description)
        }
        A(
            href = "https://github.com/carlosgub/carlosgub.dev",
            attrs = MovingText
                .toAttrs()

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpanText(project.actionButtonText)
                FaArrowRight(
                    size = IconSize.SM
                )
            }
        }
    }
}

@Composable
private fun ProjectChip(text: String) {
    Chip(
        modifier = Modifier
            .margin(
                top = 10.px,
                bottom = 10.px,
                right = 16.px
            )
            .padding(
                leftRight = 16.px,
                topBottom = 10.px
            ),
        fontSize = 1.25.cssRem,
        text = text,
    )
}

@Composable
private fun ImageHorizontal(
    src: String,
    alt: String
) {
    Image(
        src = src,
        alt = alt,
        modifier = Modifier
            .fillMaxWidth(50.percent)

    )
}

@Composable
private fun ImageVertical(
    src: String,
    alt: String
) {
    Image(
        src = src,
        alt = alt,
        modifier = Modifier
            .fillMaxWidth()
    )
}