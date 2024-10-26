package carlosgub.dev.components.toolbar


import androidx.compose.runtime.*
import carlosgub.dev.components.models.Section
import carlosgub.dev.components.styles.*
import carlosgub.dev.components.styles.components.H6Style
import carlosgub.dev.components.styles.font.semiBold
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
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@InitSilk
fun initNavHeaderStyles(ctx: InitSilkContext) {
    // Trick to avoid text scrolling under our floating nav header when you click on in-page fragments links like
    // `href="#some-section`.
    // See also: https://developer.mozilla.org/en-US/docs/Web/CSS/scroll-margin-top
    Section.entries.forEach { section ->
        ctx.stylesheet.registerStyle("#${section.id}") {
            base {
                Modifier.scrollMargin(top = toolbarHeight) // Size of the toolbar
            }
            Breakpoint.MD { Modifier.scrollMargin(0.px) }
        }
    }
}

@Composable
fun Toolbar() {
    var menuOpen by remember { mutableStateOf(false) }
    Column(
        modifier = ToolbarContainerStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = ToolbarStyle.toModifier(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Logo
                Img(src = "logo.webp", attrs = Modifier.size(64.px).toAttrs())
                H6(
                    attrs = H6Style
                        .toModifier()
                        .semiBold()
                        .margin(left = 8.px)
                        .toAttrs()
                ) {
                    Text("carlosgub.dev")
                }
            }
            ToolbarIconMenuForMobile(
                menuOpen = menuOpen,
                onOpenMenu = {
                    menuOpen = true
                }, onCloseMenu = {
                    menuOpen = false
                },
                modifier = Modifier
                    .displayUntil(Breakpoint.MD)
            )
            ToobarOptionsForDesktop()

        }
        if (menuOpen) {
            MobileMenu(onCloseMenu = { menuOpen = false })
        }
    }
}

@Composable
private fun ToobarOptionsForDesktop() {
    Row(
        Modifier
            .gap(24.px)
            .displayIfAtLeast(Breakpoint.MD)
    ) { NavItemsDesktop() }
}

@Composable
private fun ToolbarIconMenuForMobile(
    menuOpen: Boolean,
    onOpenMenu: () -> Unit,
    onCloseMenu: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (menuOpen) {
        FaIcon(
            name = "times",
            modifier = modifier.onClick {
                onCloseMenu()
            },
            style = IconCategory.SOLID, size = IconSize.XXL
        )
    } else {
        FaBars(
            size = IconSize.XXL,
            modifier = modifier.onClick {
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
    Column(
        modifier = ToolbarMenuMobileStyle.toModifier()
            .displayUntil(Breakpoint.MD)
    ) {
        NavItemsMobile(onItemPressed = onCloseMenu)
    }
}

@Composable
private fun NavItemsMobile(onItemPressed: () -> Unit = {}) {
    NavItem(Section.Home.text, Section.Home.id, onItemPressed)
    NavItem(Section.About.text, Section.About.id, onItemPressed)
    NavItem(Section.Experience.text, Section.Experience.id, onItemPressed)
    NavItem(Section.Projects.text, Section.Projects.id, onItemPressed)
    NavItem(Section.Talks.text, Section.Talks.id, onItemPressed)
    NavItem(Section.ContactMe.text, Section.ContactMe.id, onItemPressed)
}

@Composable
private fun NavItemsDesktop(onItemPressed: () -> Unit = {}) {
    NavItem(Section.About.text, Section.About.id, onItemPressed)
    NavItem(Section.Experience.text, Section.Experience.id, onItemPressed)
    NavItem(Section.Projects.text, Section.Projects.id, onItemPressed)
    NavItem(Section.Talks.text, Section.Talks.id, onItemPressed)
    NavItem(Section.ContactMe.text, Section.ContactMe.id, onItemPressed)
}