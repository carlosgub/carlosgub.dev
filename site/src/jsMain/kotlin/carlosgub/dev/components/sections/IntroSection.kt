package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.components.styles.*
import carlosgub.dev.components.styles.components.H1Style
import carlosgub.dev.components.styles.components.H3Style
import carlosgub.dev.components.styles.components.H6Style
import carlosgub.dev.components.styles.components.LinkStyle
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WordBreak
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun IntroSection(breakpoint: Breakpoint) {
    if (breakpoint >= Breakpoint.MD) {
        IntroSectionDesktop()
    } else {
        IntroSectionMobile()
    }
}

@Composable
private fun IntroSectionDesktop() {
    Column(
        modifier = SectionModifier
            .toModifier()
            .width(100.percent),
    ) {
        Row(
            modifier = IntroSectionStyle.toModifier(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.margin(right = 12.px)
            ) {
                FirstParagraph()
                TagLine(
                    modifier = Modifier.fillMaxWidth()
                )
                ThirdParagraph()
            }
            ProfileImage()
        }
    }
}

@Composable
private fun IntroSectionMobile() {
    Column(
        modifier = IntroSectionStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FirstParagraph()
        TagLine(modifier = Modifier.fillMaxWidth(100.percent).textAlign(TextAlign.Center))
        ThirdParagraph(
            modifier = Modifier
                .fillMaxWidth(100.percent)
                .textAlign(TextAlign.Center)
                .justifyContent(JustifyContent.Center)
        )
        ProfileImage(
            modifier = Modifier.maxSize(300.px)
                .margin(top = 24.px)
        )
    }
}

@Composable
private fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.black)
            .padding(
                leftRight = 132.px,
                topBottom = 20.px
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            src = "/logo.webp",
            alt = "Logo",
            modifier = Modifier
                .height(55.px)
        )
        Spacer()

        Row(
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            P(
                attrs = ToolbarOptionStyle
                    .toModifier()
                    .toAttrs()
            ) {
                Text("About me")
            }
        }
    }
}

@Composable
private fun FirstParagraph(modifier: Modifier = Modifier) {
    H3(
        attrs = modifier
            .then(H3Style.toModifier())
            .toAttrs()
    ) {
        SpanText(
            "Hi, my name is Carlos Ugaz."
        )
    }
}

@Composable
private fun TagLine(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.then(TagLineStyle.toModifier())
    ) {
        H1(
            attrs = H1Style.toAttrs()
        ) {
            SpanText(
                "I DEVELOP IDEAS WITH PASSION"
            )
        }
    }
}

@Composable
private fun ThirdParagraph(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.then(H6Style.toModifier()),
    ) {
        SpanText(
            "I'm a software engineer, Senior Android developer at Globant",
            modifier = modifier
        )
        Row(modifier = modifier) {
            SpanText("Get in touch ")
            Link(
                path = "mailto:carlosgub.dev@gmail.com",
                text = "carlosgub.dev@gmail.com",
                modifier = LinkStyle.toModifier()
                    .wordBreak(WordBreak.BreakAll)
            )
        }
    }
}

@Composable
private fun ProfileImage(modifier: Modifier = Modifier) {
    Image(
        "/photo_personal.png",
        modifier = modifier.then(ProfilePhotoStyle.toModifier())
    )
}
