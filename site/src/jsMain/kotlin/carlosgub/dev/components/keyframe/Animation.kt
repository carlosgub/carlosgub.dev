package carlosgub.dev.components.keyframe

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.silk.components.animation.Keyframes
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val FadeInKeyFrames by Keyframes {
    0.percent {
        Modifier
            .opacity(0)
    }
    100.percent {
        Modifier
            .opacity(1)
    }
}

val Shake by Keyframes {
    0.percent { Modifier.margin(left = 0.px) }
    50.percent { Modifier.margin(left = 20.px) }
    100.percent { Modifier.margin(left = 0.px) }
}
