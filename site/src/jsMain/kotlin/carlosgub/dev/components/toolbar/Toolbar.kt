package carlosgub.dev.components.toolbar


import androidx.compose.runtime.*
import carlosgub.dev.components.models.Section
import carlosgub.dev.components.styles.ToolbarContainerStyle
import carlosgub.dev.components.styles.ToolbarItemStyle
import carlosgub.dev.components.styles.ToolbarStyle
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaIcon
import com.varabyte.kobweb.silk.components.icons.fa.IconCategory
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@Composable
fun Toolbar(breakpoint: Breakpoint) {
    var menuOpen by remember { mutableStateOf(false) }
    Column(
        modifier = ToolbarContainerStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = ToolbarStyle.toModifier(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Logo
            Img(src = "logo.webp", attrs = Modifier.size(64.px).toAttrs())

            if (breakpoint < Breakpoint.MD) {
                ToolbarIconMenu(
                    menuOpen = menuOpen,
                    onOpenMenu = {
                        menuOpen = true
                    }, onCloseMenu = {
                        menuOpen = false
                    }
                )
            } else {
                Row(Modifier.gap(24.px)) {
                    NavItems()
                }
            }
        }
        if (menuOpen && breakpoint < Breakpoint.MD) {
            MobileMenu(onCloseMenu = { menuOpen = false })
        }
    }
}

@Composable
private fun ToolbarIconMenu(
    menuOpen: Boolean,
    onOpenMenu: () -> Unit,
    onCloseMenu: () -> Unit,
) {
    if (menuOpen) {
        FaIcon(
            name = "times",
            modifier = Modifier.onClick {
                onCloseMenu()
            },
            style = IconCategory.SOLID, size = IconSize.XXL
        )
    } else {
        FaBars(
            size = IconSize.XXL,
            modifier = Modifier.onClick {
                onOpenMenu()
            }
        )
    }
}

@Composable
fun NavItem(
    text: String,
    href: String,
    onItemPressed: () -> Unit,
) {
    A(
        href = "#$href",
        attrs = ToolbarItemStyle
            .toModifier()
            .onClick {
                onItemPressed()
            }.toAttrs()
    ) {
        Text(text)
    }
}

@Composable
fun MobileMenu(onCloseMenu: () -> Unit) {
    Column(Modifier.fillMaxWidth().backgroundColor(Color.white)) {
        NavItems(onItemPressed = onCloseMenu)
    }
}

@Composable
private fun NavItems(onItemPressed: () -> Unit = {}) {
    NavItem("About", Section.About.id, onItemPressed)
    NavItem("Experience", Section.Experience.id, onItemPressed)
    NavItem("Projects", Section.Projects.id, onItemPressed)
    NavItem("Talks", Section.Speaker.id, onItemPressed)
}