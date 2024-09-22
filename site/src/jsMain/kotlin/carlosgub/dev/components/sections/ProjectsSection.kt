package carlosgub.dev.components.sections

import androidx.compose.runtime.*
import carlosgub.dev.components.chip.Chip
import carlosgub.dev.components.keyframe.FadeInKeyFrames
import carlosgub.dev.components.models.Section
import carlosgub.dev.components.styles.ProjectContentStyle
import carlosgub.dev.components.styles.ProjectContentTextStyle
import carlosgub.dev.components.styles.ProjectsSectionStyle
import carlosgub.dev.components.styles.components.H1Style
import carlosgub.dev.components.styles.components.H3Style
import carlosgub.dev.components.styles.components.MovingText
import carlosgub.dev.components.styles.components.PStyle
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.util.ObserveViewportEntered
import carlosgub.dev.util.text.personalWebDescription
import carlosgub.dev.util.text.personalWebsiteStack
import carlosgub.dev.util.text.piggyBankDescription
import carlosgub.dev.util.text.piggyBankStack
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ProjectsSection(breakpoint: Breakpoint) {
    var visible by remember { mutableStateOf(false) }
    ObserveViewportEntered(
        sectionId = Section.Projects.id,
        distanceFromTop = 800.0,
        onViewportEntered = {
            visible = true
        }
    )

    Box(
        modifier = Modifier
            .id(Section.Projects.id)
            .visibility(if (visible) Visibility.Visible else Visibility.Hidden)
            .then(
                if (visible) {
                    Modifier.animation(
                        FadeInKeyFrames.toAnimation(
                            null,
                            duration = 800.ms,
                            timingFunction = AnimationTimingFunction.EaseInOut
                        )
                    )
                } else {
                    Modifier
                }
            )
    ) {
        Column(
            modifier = listOf(
                ProjectsSectionStyle
            ).toModifier()
        ) {
            ProjectsContent(breakpoint)
        }
    }
}

@Composable
private fun ProjectsContent(breakpoint: Breakpoint) {
    H1(
        attrs = H1Style
            .toModifier()
            .fillMaxWidth()
            .textAlign(TextAlign.Center)
            .bold()
            .color(WebColors.Blue)
            .toAttrs()
    ) {
        SpanText(
            "Featured projects"
        )
    }
    if (breakpoint >= Breakpoint.MD) {
        ProjectsHorizontal()
    } else {
        ProjectsVertical()
    }
}

@Composable
private fun ProjectsHorizontal() {
    PiggyBankHorizontal()
    PersonalWebsiteHorizontal()
}

@Composable
private fun ProjectsVertical() {
    PiggyBankVertical()
    PersonalWebsiteVertical()
}

@Composable
private fun PiggyBankHorizontal() {
    Row(
        modifier = ProjectContentStyle.toModifier(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageHorizontal(
            src = "/piggybank_project.jpg",
            alt = "Piggy Bank Banner Project"
        )
        PiggyBankText(
            modifier = Modifier
                .fillMaxWidth(50.percent)
        )
    }
}


@Composable
private fun PersonalWebsiteHorizontal() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PersonalWebsiteText(
            modifier = Modifier
                .fillMaxWidth(50.percent)
        )
        ImageHorizontal(
            src = "/carlosgub_project.jpg",
            alt = "Personal Website Banner Project"
        )
    }
}

@Composable
private fun PiggyBankVertical() {
    Column(
        modifier = ProjectContentStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageVertical(
            src = "/piggybank_project.jpg",
            alt = "Piggy Bank Banner Image"
        )
        PiggyBankText(
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
private fun PersonalWebsiteVertical() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageVertical(
            "/carlosgub_project.jpg",
            "Personal Website Banner Project"
        )
        PersonalWebsiteText(
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
private fun PiggyBankText(
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
            piggyBankStack.forEach { stack ->
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
                "Piggy Bank"
            )
        }
        P(
            attrs = PStyle
                .toModifier()
                .padding(top = 16.px)
                .toAttrs()
        ) {
            Text(
                piggyBankDescription
            )
        }
        A(
            href = "https://play.google.com/store/apps/details?id=com.carlosgub.myfinance.app"
        ) {
            Image(
                src = "https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png",
                alt = "Get it on Google Play",
                modifier = Modifier.height(80.px)
                    .margin(left = (-13).px)
            )
        }
        A(
            href = "https://github.com/carlosgub/PiggyBank",
            attrs = MovingText
                .toAttrs()

        ) {
            SpanText(
                "See project →"
            )
        }
    }
}

@Composable
private fun PersonalWebsiteText(
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
            personalWebsiteStack.forEach { stack ->
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
                "Personal website"
            )
        }
        P(
            attrs = PStyle
                .toModifier()
                .padding(top = 16.px)
                .toAttrs()
        ) {
            Text(
                personalWebDescription
            )
        }
        A(
            href = "https://github.com/carlosgub/carlosgub.dev",
            attrs = MovingText
                .toAttrs()

        ) {
            SpanText(
                "See project →"
            )
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
        fontFamily = "PPMoriLight"
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