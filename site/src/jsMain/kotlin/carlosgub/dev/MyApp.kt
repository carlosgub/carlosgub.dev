package carlosgub.dev

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.layer.SilkLayer
import com.varabyte.kobweb.silk.style.layer.add
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.localStorage
import org.jetbrains.compose.web.css.percent

private const val COLOR_MODE_KEY = "dev:colorMode"

@InitSilk
fun initSilk(ctx: InitSilkContext) {
    ctx.stylesheet.apply {
        // Layers specified in build.gradle.kts
        cssLayers.add("bootstrapjs", after = SilkLayer.BASE)
    }
}

@App
@Composable
fun MyApp(content: @Composable () -> Unit) {
    SilkApp {
        val colorMode = ColorMode.LIGHT
        LaunchedEffect(colorMode) {
            localStorage.setItem(COLOR_MODE_KEY, colorMode.name)
        }

        Surface(SmoothColorStyle.toModifier().width(100.percent)) {
            content()
        }
    }
}
