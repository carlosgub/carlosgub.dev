package carlosgub.dev.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import carlosgub.dev.components.sections.FirstSection
import carlosgub.dev.components.sections.Footer
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.core.Page
import kotlinx.browser.document


@Page
@Composable
fun HomePage() {
    val title = "Welcome to my website!"
    LaunchedEffect(title) {
        document.title = title
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FirstSection()
//        SecondSection()
        Footer(Modifier)
    }
}
