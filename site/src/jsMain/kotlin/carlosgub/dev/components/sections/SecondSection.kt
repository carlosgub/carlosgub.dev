package carlosgub.dev.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.dom.Text

@Composable
fun SecondSection(modifier: Modifier = Modifier) {
    Column(
        modifier = SectionModifier.toModifier().then(modifier)
    ) {
        Text("Working on progress")
    }
}
