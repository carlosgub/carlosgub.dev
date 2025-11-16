package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import carlosgub.dev.model.Section
import carlosgub.dev.components.styles.*
import carlosgub.dev.components.styles.components.H1Style
import carlosgub.dev.components.styles.components.H3Style
import carlosgub.dev.components.styles.components.H6Style
import carlosgub.dev.components.widgets.LinkButton
import carlosgub.dev.model.Language
import carlosgub.dev.model.intro.IntroSection
import carlosgub.dev.model.intro.IntroEnglish
import carlosgub.dev.model.intro.IntroSpanish
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
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H3

@Composable
fun IntroSection(language: Language) {
    val intro = if (language == Language.English) IntroEnglish else IntroSpanish
    Box(
        IntroContainerStyle
            .toModifier()
            .id(Section.Home.id),
        contentAlignment = Alignment.Center
    ) {
        IntroSectionDesktop(intro)
        IntroSectionMobile(intro)
    }
}

@Composable
private fun IntroSectionDesktop(intro: IntroSection) {
    Column(
        modifier = IntroDesktopStyle
            .toModifier()
            .displayIfAtLeast(Breakpoint.MD),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.margin(right = 12.px)
            ) {
                FirstParagraph(intro.firstParagraph)
                TagLine(
                    text = intro.tagLine,
                    modifier = Modifier.fillMaxWidth()
                )
                ThirdParagraph(intro.thirdParagraph)
                ContactButton(intro.buttonText)
            }
            ProfileImage()
        }
    }
}

@Composable
private fun IntroSectionMobile(intro: IntroSection) {
    Column(
        modifier = IntroMobileStyle
            .toModifier()
            .displayUntil(Breakpoint.MD),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FirstParagraph(intro.firstParagraph)
        TagLine(
            text = intro.tagLine,
            modifier = Modifier.fillMaxWidth(100.percent).textAlign(TextAlign.Center)
        )
        ThirdParagraph(
            text = intro.thirdParagraph,
            modifier = Modifier
                .fillMaxWidth(100.percent)
                .textAlign(TextAlign.Center)
                .justifyContent(JustifyContent.Center)
        )
        ContactButton(intro.buttonText)
        ProfileImage(
            modifier = Modifier.maxSize(300.px)
                .margin(top = 24.px)
        )
    }
}

@Composable
private fun FirstParagraph(text: String, modifier: Modifier = Modifier) {
    H3(
        attrs = modifier
            .then(H3Style.toModifier())
            .toAttrs()
    ) {
        SpanText(text)
    }
}

@Composable
private fun TagLine(
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.then(TagLineStyle.toModifier())
    ) {
        H1(
            attrs = H1Style.toAttrs()
        ) {
            SpanText(text)
        }
    }
}

@Composable
private fun ThirdParagraph(
    text: String,
    modifier: Modifier = Modifier
) {
    SpanText(
        text = text,
        modifier = modifier.then(
            H6Style
                .toModifier()
                .padding(bottom = 12.px)
        )
    )
}

@Composable
private fun ContactButton(text: String) {
    Div(attrs = Modifier.toAttrs()) {
        LinkButton(
            path = "#${Section.ContactMe.id}",
            text = text,
            modifier = GoToContactMeButton.toModifier()
        )
    }
}

@Composable
private fun ProfileImage(modifier: Modifier = Modifier) {
    Image(
        "/photo_personal.webp",
        modifier = modifier.then(ProfilePhotoStyle.toModifier())
    )
}
