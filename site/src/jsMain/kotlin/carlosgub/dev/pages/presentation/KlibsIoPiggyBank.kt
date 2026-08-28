package carlosgub.dev.pages.presentation

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Iframe


@Page("klibs-io-piggybank")
@Composable
fun KlibsIoPiggyBankPage() {
    Iframe(
        attrs = Modifier.width(100.percent)
            .height(100.percent)
            .top(0.px)
            .left(0.px)
            .right(0.px)
            .bottom(0.px)
            .position(Position.Absolute)
            .toAttrs {
                attr(
                    "src",
                    "/klibs-io-piggybank-slides.html"
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
