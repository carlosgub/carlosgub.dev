package carlosgub.dev.components.keyframe

import carlosgub.dev.components.theme.WebColors.colorOpposite
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
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

val WidthKeyFrames by Keyframes {
    0.percent {
        Modifier
            .background(colorOpposite.value())
            .fillMaxWidth()
    }
    100.percent {
        Modifier
            .background(colorOpposite.value())
            .width(0.px)
    }
}
