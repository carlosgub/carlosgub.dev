package carlosgub.dev.components.sections

import androidx.compose.runtime.*
import carlosgub.dev.components.keyframe.FadeInKeyFrames
import carlosgub.dev.components.models.Section
import carlosgub.dev.components.styles.BackgroundSectionStyle
import carlosgub.dev.components.styles.components.H3Style
import carlosgub.dev.components.styles.components.PStyle
import carlosgub.dev.components.styles.components.UlStyle
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun BackgroundSection() {
    var visible by remember { mutableStateOf(false) }
    ObserveViewportEntered(
        sectionId = Section.Experience.id,
        distanceFromTop = 800.0,
        onViewportEntered = {
            visible = true
        }
    )

    Box(
        modifier = Modifier
            .id(Section.Experience.id)
            .visibility(if (visible) Visibility.Visible else Visibility.Hidden)
            .then(
                if (visible) {
                    Modifier.animation(
                        FadeInKeyFrames.toAnimation(
                            colorMode = null,
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
                BackgroundSectionStyle
            ).toModifier()
        ) {
            BackgroundContent()
        }
    }
}

@Composable
private fun BackgroundContent() {
    H3(
        attrs = H3Style
            .toModifier()
            .fillMaxWidth()
            .textAlign(TextAlign.Start)
            .bold()
            .color(WebColors.Blue)
            .toAttrs()
    ) {
        SpanText(
            "About Me"
        )
    }
    P(
        attrs = PStyle
            .toModifier()
            .padding(top = 16.px)
            .textAlign(TextAlign.Justify)
            .toAttrs()
    ) {
        Text(
            "Hello! I'm Carlos, a Senior Software Engineer, specializing in " +
                    "Android app development with Kotlin and Java. With seven years of experience, I've led " +
                    "teams in various industries including banking, education, e-commerce, and media."
        )
        P()
        Text(
            "I'm an Android enthusiast who thrives on exploring emerging technologies and staying " +
                    "at the cutting edge of the field. Let's collaborate to bring innovative " +
                    "Android solutions to life!"
        )
        P()
        Text(
            "If you're seeking a Senior Software Engineer with a deep passion for Android development, " +
                    "a track record of leadership, and a commitment to staying ahead of the curve, I'd love " +
                    "to connect and discuss how I can bring my skills and enthusiasm to your next project."
        )
        P()
        Text("Here are a few technologies I’ve been working recently:")
        Row(
            modifier = Modifier
                .padding(top = 8.px)
        ) {
            Ul(
                attrs = UlStyle
                    .toModifier()
                    .padding(left = 16.px)
                    .toAttrs()
            ) {
                Li {
                    Text("Kotlin")
                }
                Li {
                    Text("Jetpack Compose")
                }
                Li {
                    Text("Compose Multiplatform")
                }
                Li {
                    Text("REST")
                }
            }
            Ul(
                attrs = UlStyle
                    .toModifier()
                    .margin(left = 24.px)
                    .toAttrs()
            ) {
                Li {
                    Text("Android")
                }
                Li {
                    Text("Kotlin multiplatform")
                }
                Li {
                    Text("GraphQL")
                }
                Li {
                    Text("Offline data")
                }
            }
        }
    }
}
