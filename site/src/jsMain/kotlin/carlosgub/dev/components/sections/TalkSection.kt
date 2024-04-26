package carlosgub.dev.components.sections

import androidx.compose.runtime.*
import carlosgub.dev.components.keyframe.FadeInKeyFrames
import carlosgub.dev.components.models.Section
import carlosgub.dev.components.styles.BackgroundSectionStyle
import carlosgub.dev.components.styles.components.H3Style
import carlosgub.dev.components.styles.components.LinkStyle
import carlosgub.dev.components.styles.components.LinkTalkStyle
import carlosgub.dev.components.styles.components.UlStyle
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Composable
fun TalkSection() {
    var visible by remember { mutableStateOf(false) }
    ObserveViewportEntered(
        sectionId = Section.Speaker.id,
        distanceFromTop = 800.0,
        onViewportEntered = {
            visible = true
        }
    )

    Box(
        modifier = Modifier
            .id(Section.Speaker.id)
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
                BackgroundSectionStyle
            ).toModifier()
        ) {
            TalkContent()
        }
    }
}

@Composable
private fun TalkContent() {
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
            "Talks"
        )
    }

    Ul(
        attrs = UlStyle
            .toModifier()
            .margin(left = 24.px)
            .toAttrs()
    ) {
        Li {
            Text(
                "\uD83C\uDDF5\uD83C\uDDEA Android Dev Peru #61 - How create your first website w/ kobweb - "
            )
            Link(
                path = "/presentation/create-kobweb",
                text = "slides",
                modifier = listOf(
                    LinkStyle,
                    LinkTalkStyle
                ).toModifier()

            )
            Text(" - ")
            Link(
                path = "https://youtu.be/avs8Zros4HI?t=65",
                text = "video",
                modifier = listOf(
                    LinkStyle,
                    LinkTalkStyle
                ).toModifier()

            )
        }
        Li {
            Text(
                "\uD83C\uDDF5\uD83C\uDDEA GDG DevFest 2023 - How Implement Firestore in Kotlin Multiplatform Mobile - "
            )
            Link(
                path = "/presentation/firestore-kmm",
                text = "slides",
                modifier = listOf(
                    LinkStyle,
                    LinkTalkStyle
                ).toModifier()

            )
            Text(" - ")
            Link(
                path = "https://www.youtube.com/watch?v=tb5h2XXAq6A",
                text = "video",
                modifier = listOf(
                    LinkStyle,
                    LinkTalkStyle
                ).toModifier()

            )
        }
        Li {
            Text("\uD83C\uDDEE\uD83C\uDDF3 2021 5th ICOEI - Blockchain and smart contract for donation traceability - ")
            Link(
                path = "https://ieeexplore.ieee.org/document/9453016/",
                text = "paper",
                modifier = listOf(
                    LinkStyle,
                    LinkTalkStyle
                ).toModifier()

            )
        }

        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA Firebase Peru #6 2020 - Firebase ML Kit Barcode w/ Camera X")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA GDG DevFest 2019 - AutoML Vision Edge")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA Firebase Peru #5 2019 - Realtime chat w/ Firestore")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA Kotlin Everywhere Lima 2019 - Kotlin DSL")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA Firebase Day 2019 - Realtime chat w/ Firestore.")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA GDG Open MeetupMobile #2 2019 - AutoML Vision Edge")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA IO Extended Lima 2019 - Reconocimiento de Objetos en tiempo real con MLKit")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA Firebase Perú #4 2019 - Firebase AutoML Vision Edge")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA Firebase Perú #2 2019 - Firebase Analytics, migrando de GA a FA.")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA Firebase Perú #1 2019 - Reconocimiento Facial con ML KIT")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA GDG Lima 2018 - Android App Bundle Dynamic Delivery")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA Android Dev Perú MeetUp #19 2018 - Reconocimiento Facial con ML KIT")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA Google I/O Extended 18 - Creando un cuarto inteligente con Android Things")
        }
        Li {
            Text("\uD83C\uDDF5\uD83C\uDDEA Android Dev Perú MeetUp #18 2018 - Android Things Example")
        }
    }
}
