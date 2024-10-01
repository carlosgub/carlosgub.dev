package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.models.Section
import carlosgub.dev.components.styles.TalkSectionStyle
import carlosgub.dev.components.styles.components.H3Style
import carlosgub.dev.components.styles.components.LinkStyle
import carlosgub.dev.components.styles.components.LinkTalkStyle
import carlosgub.dev.components.styles.components.UlStyle
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.dom.*

@Composable
fun TalkSection() {
    Box(
        modifier = Modifier
            .background(Color.floralwhite)
            .fillMaxWidth()
            .id(Section.Talks.id),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = listOf(
                TalkSectionStyle
            ).toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally
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
            .textAlign(TextAlign.Start)
            .bold()
            .color(WebColors.Blue)
            .toAttrs()
    ) {
        SpanText(
            Section.Talks.text
        )
    }

    Ul(
        attrs = UlStyle
            .toModifier()
            .toAttrs()
    ) {
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(
                " Android Dev Peru #61 - How create your first website w/ kobweb - "
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
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(
                " GDG DevFest 2023 - How Implement Firestore in Kotlin Multiplatform Mobile - "
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
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-in")
                    .ariaLabel("India Flag").toAttrs()
            )
            Text(" 2021 5th ICOEI - Blockchain and smart contract for donation traceability - ")
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
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" Firebase Peru #6 2020 - Firebase ML Kit Barcode w/ Camera X")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" GDG DevFest 2019 - AutoML Vision Edge")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" Firebase Peru #5 2019 - Realtime chat w/ Firestore")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" Kotlin Everywhere Lima 2019 - Kotlin DSL")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" Firebase Day 2019 - Realtime chat w/ Firestore.")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" GDG Open MeetupMobile #2 2019 - AutoML Vision Edge")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" IO Extended Lima 2019 - Reconocimiento de Objetos en tiempo real con MLKit")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" Firebase Perú #4 2019 - Firebase AutoML Vision Edge")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" Firebase Perú #2 2019 - Firebase Analytics, migrando de GA a FA.")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" Firebase Perú #1 2019 - Reconocimiento Facial con ML KIT")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" GDG Lima 2018 - Android App Bundle Dynamic Delivery")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" Android Dev Perú MeetUp #19 2018 - Reconocimiento Facial con ML KIT")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" Google I/O Extended 18 - Creando un cuarto inteligente con Android Things")
        }
        Li {
            I(
                attrs = Modifier
                    .classNames("em", "em-flag-pe")
                    .ariaLabel("Peru Flag").toAttrs()
            )
            Text(" Android Dev Perú MeetUp #18 2018 - Android Things Example")
        }
    }
}
