package carlosgub.dev.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import carlosgub.dev.components.sections.BackgroundSection
import carlosgub.dev.components.sections.ExperienceSection
import carlosgub.dev.components.sections.Footer
import carlosgub.dev.components.sections.IntroSection
import carlosgub.dev.components.widgets.BackToTopButton
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Iframe


@Page
@Composable
fun KMMPage() {
    Iframe(
        attrs = Modifier.width(100.percent)
            .height(100.percent)
            .top(0.px)
            .left(0.px)
            .right(0.px)
            .bottom(0.px)
            .position(Position.Absolute)
            .toAttrs{
                attr(
                    "src",
                    "https://docs.google.com/presentation/d/e/2PACX-1vTxHxDNJ37YDJWUEc7FGnV3maWJR6EIQyKOszBpdD5G5qxW9wue7PvNiy0zVt37goY276FYBzWcFlSj/embed?start=false&loop=false&delayms=3000"
                )
                attr(
                    "frameborder",
                    "0"
                )
                attr(
                    "allowfullscreen",
                    "true"
                )
                attr(
                    "mozallowfullscreen",
                    "true"
                )
                attr(
                    "webkitallowfullscreen",
                    "true"
                )
                attr(
                    "height",
                    "100%"
                )
            }
    )
}
