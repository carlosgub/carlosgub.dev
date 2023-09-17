package carlosgub.dev.components.layouts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import carlosgub.dev.components.sections.Footer
import com.stevdza.san.kotlinbs.components.BSIcon
import com.stevdza.san.kotlinbs.forms.BSSwitch
import com.stevdza.san.kotlinbs.icons.BSIcons
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.document
import org.jetbrains.compose.web.css.*

@Composable
fun PageLayout(title: String, content: @Composable () -> Unit) {
    LaunchedEffect(title) {
        document.title = title
    }
    var colorMode by ColorMode.currentState
    Box(
        Modifier
            .fillMaxWidth()
            .minHeight(100.percent)
            // Create a box with two rows: the main content (fills as much space as it can) and the footer (which reserves
            // space at the bottom). "min-content" means the use the height of the row, which we use for the footer.
            // Since this box is set to *at least* 100%, the footer will always appear at least on the bottom but can be
            // pushed further down if the first row grows beyond the page.
            .gridTemplateRows { size(1.fr); size(minContent) }
    ) {

        Column(
            modifier = Modifier.fillMaxSize().textAlign(TextAlign.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.align(Alignment.End).padding(20.px)
            ) {
                val color = if (colorMode.isDark) {
                    Colors.White
                } else {
                    Colors.Black
                }
                BSIcon(
                    icon = BSIcons.SUN,
                    size = 1.cssRem,
                    color = color,
                    modifier = Modifier.padding(right = 8.px)
                )
                BSSwitch(
                    label = "",
                    defaultChecked = colorMode.isDark,
                    onClick = {
                        colorMode = colorMode.opposite
                    }
                )
                BSIcon(
                    icon = BSIcons.MOON,
                    size = 1.cssRem,
                    color = color
                )
            }
            content()
        }
        // Associate the footer with the row that will get pushed off the bottom of the page if it can't fit.
        Footer(Modifier.align(Alignment.Center).gridRow(2, 3))
    }
}


