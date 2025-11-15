package carlosgub.dev.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import carlosgub.dev.components.sections.*
import carlosgub.dev.components.toolbar.Toolbar
import carlosgub.dev.components.widgets.BackToTopButton
import carlosgub.dev.model.Language
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import kotlinx.browser.document
import org.jetbrains.compose.web.css.percent


@Page
@Composable
fun HomePage() {
    val title = "Carlos Ugaz | Mobile Software Engineer"
    LaunchedEffect(title) {
        document.title = title
    }
    var language: Language by remember { mutableStateOf(Language.English) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(100.percent)
        ) {
            Toolbar(language, onLanguageSelected = { languageSelected ->
                language = languageSelected
            })
            IntroSection(language)
            AboutMeSection(language)
            ExperienceSection(language)
            ProjectsSection(language)
            TalkSection()
            ContactMeSection()
            Footer()
        }
        BackToTopButton()

    }

}
