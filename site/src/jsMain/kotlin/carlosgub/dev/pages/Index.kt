package carlosgub.dev.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import carlosgub.dev.components.sections.BackgroundSection
import carlosgub.dev.components.sections.IntroSection
import carlosgub.dev.components.sections.Footer
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.percent


@Page
@Composable
fun HomePage() {
    val title = "Carlos Ugaz | Mobile Software Engineer"
    val breakpoint = rememberBreakpoint()
    LaunchedEffect(title) {
        document.title = title
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(100.percent)
    ) {
        IntroSection()
        BackgroundSection()
        Footer(breakpoint)
    }
}
