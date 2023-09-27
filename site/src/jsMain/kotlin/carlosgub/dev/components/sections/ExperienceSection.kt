package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import carlosgub.dev.components.keyframe.WidthKeyFrames
import carlosgub.dev.components.models.Section
import carlosgub.dev.components.models.Stack
import carlosgub.dev.components.styles.CompanyLink
import carlosgub.dev.components.styles.ExperienceSectionStyle
import carlosgub.dev.components.styles.PExperienceStyle
import carlosgub.dev.components.styles.ReadMyResumeStyle
import carlosgub.dev.components.styles.components.H3Style
import carlosgub.dev.components.styles.components.H6Style
import carlosgub.dev.components.styles.components.PStyle
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.styles.font.light
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.components.theme.WebColors.colorOpposite
import carlosgub.dev.util.ObserveViewportEntered
import carlosgub.dev.util.text.*
import com.stevdza.san.kotlinbs.components.BSBadge
import com.stevdza.san.kotlinbs.models.BadgeVariant
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.layout.Divider
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun ExperienceSection() {
    val visible = remember { mutableStateOf(false) }
    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 800.0,
        onViewportEntered = {
            visible.value = true
        }
    )

    Box(
        modifier = Modifier
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
        SlidingContainers(visible)
    }
}

@Composable
fun SlidingContainers(visible: MutableState<Boolean>) {
    val containerVisibility = remember { mutableStateOf(DisplayStyle.Flex) }
    Column(
        Modifier
            .fillMaxSize()
            .display(containerVisibility.value)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .setVariable(colorOpposite, WebColors.colorOppositeValue)
                .weight(1f)
                .then(
                    if (visible.value) {
                        Modifier.animation(
                            WidthKeyFrames.toAnimation(
                                null,
                                duration = 800.ms,
                                timingFunction = AnimationTimingFunction.Linear
                            )
                        )
                    } else {
                        Modifier
                    }
                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .setVariable(colorOpposite, WebColors.colorOppositeValue)
                .weight(1f)
                .then(
                    if (visible.value) {
                        Modifier.animation(
                            WidthKeyFrames.toAnimation(
                                null,
                                duration = 800.ms,
                                timingFunction = AnimationTimingFunction.Linear,
                                delay = 100.ms
                            )
                        )
                    } else {
                        Modifier
                    }
                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .setVariable(colorOpposite, WebColors.colorOppositeValue)
                .weight(1f)
                .then(
                    if (visible.value) {
                        Modifier.animation(
                            WidthKeyFrames.toAnimation(
                                null,
                                duration = 800.ms,
                                timingFunction = AnimationTimingFunction.Linear,
                                delay = 200.ms
                            )
                        ).onAnimationEnd {
                            containerVisibility.value = DisplayStyle.None
                        }
                    } else {
                        Modifier
                    }
                )
        )
    }
}

@Composable
fun ExperienceContent() {
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
    Divider(Modifier.fillMaxWidth())
    WorkContainer(
        workName = rappi,
        workUrl = rappiUrl,
        time = rappiTime,
        description = rappiDescription,
        stackList = rappiStack
    )
    A(
        href = "/resume.pdf",
        attrs = ReadMyResumeStyle
            .toModifier()
            .color(WebColors.Blue)
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
    workUrl:String,
    time: String,
    description: String,
    stackList: List<Stack>
) {
    Column(
        Modifier
            .fillMaxWidth()
            .margin(topBottom = 12.px)
    ) {
        H6(
            attrs = H6Style
                .toModifier()
                .fillMaxWidth()
                .bold()
                .color(WebColors.Blue)
                .margin(0.px)
                .toAttrs()
        ) {
            Link(
                path = workUrl,
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
                .margin(bottom = 8.px)
                .fillMaxWidth()
                .textAlign(TextAlign.Justify)
                .toAttrs()
        ) {
            Text(
                description
            )
        }
        Row(
            Modifier
                .display(DisplayStyle.Block)
        ) {
            stackList.forEach { stack ->
                BSBadge(
                    modifier = Modifier
                        .margin(
                            top = 6.px,
                            bottom = 6.px,
                            right = 12.px
                        ),
                    text = stack.id,
                    variant = BadgeVariant.Rounded,
                    fontFamily = "PPMoriLight"
                )
            }
        }
    }
}
