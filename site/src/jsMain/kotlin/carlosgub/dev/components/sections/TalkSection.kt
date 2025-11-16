package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.styles.TalkSectionStyle
import carlosgub.dev.components.styles.components.*
import carlosgub.dev.components.styles.font.bold
import carlosgub.dev.components.theme.WebColors
import carlosgub.dev.model.Language
import carlosgub.dev.model.Section
import carlosgub.dev.model.talk.TalkEnglish
import carlosgub.dev.model.talk.TalkSection
import carlosgub.dev.model.talk.TalkSpanish
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
fun TalkSection(language: Language) {
    val talkSection = if (language == Language.English) TalkEnglish else TalkSpanish
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
            TalkContent(talkSection)
        }
    }
}

@Composable
private fun TalkContent(talkSection: TalkSection) {
    H4(
        attrs = H4Style
            .toModifier()
            .textAlign(TextAlign.Start)
            .bold()
            .color(WebColors.Blue)
            .toAttrs()
    ) {
        SpanText(
            talkSection.title
        )
    }

    Ul(
        attrs = UlStyle
            .toModifier()
            .toAttrs()
    ) {
        talkSection.talks.forEach { talk ->
            Li {
                I(
                    attrs = Modifier
                        .classNames("em", talk.flag)
                        .toAttrs()
                )
                Text(
                    " ${talk.title}"
                )
                talk.paperPath?.let { paperPath ->
                    Text(" - ")
                    Link(
                        path = paperPath,
                        text = "paper",
                        modifier = listOf(
                            LinkStyle,
                            LinkTalkStyle
                        ).toModifier()
                    )
                }
                talk.slidePath?.let { slidePath ->
                    Text(" - ")
                    Link(
                        path = slidePath,
                        text = "slides",
                        modifier = listOf(
                            LinkStyle,
                            LinkTalkStyle
                        ).toModifier()

                    )
                }
                talk.videoPath?.let { videoPath ->
                    Text(" - ")
                    Link(
                        path = videoPath,
                        text = "video",
                        modifier = listOf(
                            LinkStyle,
                            LinkTalkStyle
                        ).toModifier()
                    )
                }
            }
        }
    }
}
