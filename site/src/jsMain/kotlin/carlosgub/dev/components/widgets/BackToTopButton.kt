package carlosgub.dev.components.widgets

import androidx.compose.runtime.*
import carlosgub.dev.components.sections.FadeInKeyFrames
import carlosgub.dev.components.styles.BackToTopButtonStyle
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.toModifier
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.s

@Composable
fun BackToTopButton() {
    var scroll: Double? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        window.addEventListener(type = "scroll", callback = {
            scroll = document.documentElement?.scrollTop
        })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .position(Position.Fixed)
            .zIndex(1)
            .styleModifier {
                property("pointer-events", "none")
            },
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        val show = scroll != null && scroll!! > 400.0
        Box(
            modifier = BackToTopButtonStyle
                .toModifier()
                .visibility(
                    if (show) {
                        Visibility.Visible
                    } else {
                        Visibility.Hidden
                    }
                )
                .onClick {
                    document.documentElement?.scroll(x = 0.0, y = 0.0)
                }
                .then(
                    if (show) {
                        Modifier.animation(
                            FadeInKeyFrames.toAnimation(
                                null,
                                duration = 1.5.s,
                                timingFunction = AnimationTimingFunction.EaseInOut
                            )
                        )
                    } else {
                        Modifier
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            FaArrowUp(
                modifier = Modifier
                    .color(Colors.White),
                size = IconSize.LG
            )
        }
    }
}