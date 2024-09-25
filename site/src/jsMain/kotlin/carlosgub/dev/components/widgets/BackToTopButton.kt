package carlosgub.dev.components.widgets

import androidx.compose.runtime.*
import carlosgub.dev.components.keyframe.FadeInKeyFrames
import carlosgub.dev.components.styles.BackToTopButtonStyle
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUpLong
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toModifier
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
            .pointerEvents(PointerEvents.None),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        val show = scroll != null && scroll!! > 400.0
        FaArrowUpLong(
            size = IconSize.LG,
            modifier = BackToTopButtonStyle
                .toModifier()
                .visibility(if (show) Visibility.Visible else Visibility.Hidden)
                .then(
                    if (show) {
                        Modifier.animation(
                            FadeInKeyFrames.toAnimation(
                                colorMode = null,
                                duration = 1.5.s,
                                timingFunction = AnimationTimingFunction.EaseInOut
                            )
                        )
                    } else {
                        Modifier
                    }
                )
                .onClick {
                    document.documentElement?.scroll(x = 0.0, y = 0.0)
                },
        )
    }
}