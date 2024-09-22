package carlosgub.dev.components.keyframe

import carlosgub.dev.components.theme.WebColors.Black
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.animation.Keyframes
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val FadeInKeyFrames = Keyframes {
    0.percent {
        Modifier
            .opacity(0.1)
    }
    100.percent {
        Modifier
            .opacity(1)
    }
}

val Shake = Keyframes {
    0.percent {
        Modifier.margin(
            left = 0.px,
            top = 16.px
        )
    }
    50.percent {
        Modifier.margin(
            left = 20.px,
            top = 16.px
        )
    }
    100.percent {
        Modifier.margin(
            left = 0.px,
            top = 16.px
        )
    }
}

val WidthKeyFrames = Keyframes {
    0.percent {
        Modifier
            .backgroundColor(Black)
            .fillMaxWidth()
    }
    100.percent {
        Modifier
            .backgroundColor(Black)
            .width(0.px)
    }
}
