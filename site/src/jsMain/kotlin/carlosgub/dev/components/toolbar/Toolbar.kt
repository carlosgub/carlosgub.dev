package carlosgub.dev.components.toolbar


import androidx.compose.runtime.*
import carlosgub.dev.model.Section
import carlosgub.dev.components.styles.*
import carlosgub.dev.components.styles.components.H6Style
import carlosgub.dev.components.styles.font.semiBold
import carlosgub.dev.model.Language
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.boxShadow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaIcon
import com.varabyte.kobweb.silk.components.icons.fa.IconCategory
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.icons.mdi.IconStyle
import com.varabyte.kobweb.silk.components.icons.mdi.MdiKeyboardArrowDown
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.document
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event

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
fun Toolbar(language: Language, onLanguageSelected: (Language) -> Unit) {
    var menuOpen by remember { mutableStateOf(false) }
    val menuId = "mobile-menu"

    // -------- CLOSE MENU ON CLICK OUTSIDE --------
    DisposableEffect(menuOpen) {
        if (!menuOpen) {
            return@DisposableEffect onDispose {}
        }

        val element = document.getElementById(menuId)

        val listener: (Event) -> Unit = listener@{ event ->
            val target = event.target as? HTMLElement ?: return@listener
            if (element != null && !element.contains(target)) {
                menuOpen = false
            }
        }

        // Desktop + Android
        document.addEventListener("click", listener)

        // iPhone / iPad (Safari)
        document.addEventListener("touchstart", listener)

        onDispose {
            document.removeEventListener("click", listener)
            document.removeEventListener("touchstart", listener)
        }
    }

    // -------- UI --------
    Column(
        modifier = ToolbarContainerStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = ToolbarStyle.toModifier(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Img(src = "logo.webp", attrs = Modifier.size(64.px).toAttrs())

                H6(
                    attrs = H6Style.toModifier()
                        .semiBold()
                        .margin(left = 8.px)
                        .toAttrs()
                ) {
                    Text("carlosgub.dev")
                }
            }

            ToolbarIconMenuForMobile(
                menuOpen = menuOpen,
                onOpenMenu = { menuOpen = true },
                onCloseMenu = { menuOpen = false },
                modifier = Modifier.displayUntil(Breakpoint.LG)
            )

            ToolbarOptionsForDesktop(
                language = language,
                onLanguageSelected = onLanguageSelected
            )
        }

        if (menuOpen) {
            // WRAP THE MOBILE MENU WITH AN ID
            Div(
                attrs = Modifier
                    .id(menuId)
                    .toAttrs()
            ) {
                MobileMenu(
                    onCloseMenu = { menuOpen = false },
                    language = language,
                    onLanguageSelected = onLanguageSelected
                )
            }
        }
    }
}

@Composable
private fun ToolbarOptionsForDesktop(
    language: Language,
    onLanguageSelected: (Language) -> Unit,
) {
    Row(
        Modifier
            .gap(24.px)
            .displayIfAtLeast(Breakpoint.LG),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavItemsDesktop(
            language = language,
            onLanguageSelected = onLanguageSelected
        )
    }
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
fun MobileMenu(
    onCloseMenu: () -> Unit,
    language: Language,
    onLanguageSelected: (Language) -> Unit
) {
    Column(
        modifier = ToolbarMenuMobileStyle.toModifier()
            .displayUntil(Breakpoint.LG),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavItemsMobile(
            onItemPressed = onCloseMenu,
            language = language,
            onLanguageSelected = onLanguageSelected
        )
    }
}

@Composable
private fun NavItemsMobile(
    onItemPressed: () -> Unit = {},
    language: Language,
    onLanguageSelected: (Language) -> Unit
) {
    NavItemMobile(Section.Home.getText(language), Section.Home.id, onItemPressed)
    NavItemMobile(Section.About.getText(language), Section.About.id, onItemPressed)
    NavItemMobile(Section.Experience.getText(language), Section.Experience.id, onItemPressed)
    NavItemMobile(Section.Projects.getText(language), Section.Projects.id, onItemPressed)
    NavItemMobile(Section.Talks.getText(language), Section.Talks.id, onItemPressed)
    NavItemMobile(Section.ContactMe.getText(language), Section.ContactMe.id, onItemPressed)

    LanguageDropdown(
        language = language,
        onSelect = onLanguageSelected,
    )
    Br()
}

@Composable
private fun NavItemsDesktop(
    onItemPressed: () -> Unit = {},
    language: Language,
    onLanguageSelected: (Language) -> Unit
) {
    NavItem(Section.About.getText(language), Section.About.id, onItemPressed)
    NavItem(Section.Experience.getText(language), Section.Experience.id, onItemPressed)
    NavItem(Section.Projects.getText(language), Section.Projects.id, onItemPressed)
    NavItem(Section.Talks.getText(language), Section.Talks.id, onItemPressed)
    NavItem(Section.ContactMe.getText(language), Section.ContactMe.id, onItemPressed)

    LanguageDropdown(
        language = language,
        onSelect = onLanguageSelected
    )
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
fun NavItemMobile(
    text: String,
    href: String,
    onItemPressed: () -> Unit,
) {
    A(
        href = "#$href",
        attrs = ToolbarItemStyle
            .toModifier()
            .width(100.percent)
            .onClick {
                onItemPressed()
            }.toAttrs()
    ) {
        Text(text)
    }
}

@Composable
fun LanguageDropdown(
    language: Language,
    onSelect: (Language) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val dropdownId = "language-dropdown"

    // --- Close dropdown when clicking outside ---
    DisposableEffect(expanded) {
        if (!expanded) {
            return@DisposableEffect onDispose {}
        }

        val element = document.getElementById(dropdownId)

        val listener: (Event) -> Unit = listener@{ event ->
            val target = event.target as? HTMLElement ?: return@listener
            if (element != null && !element.contains(target)) {
                expanded = false
            }
        }

        // Desktop + Android browsers
        document.addEventListener("click", listener)

        // iPhone / iPad (Safari)
        document.addEventListener("touchstart", listener)

        onDispose {
            document.removeEventListener("click", listener)
            document.removeEventListener("touchstart", listener)
        }
    }

    // --- Container ---
    Div(
        attrs = Modifier
            .id(dropdownId)
            .position(Position.Relative)
            .display(DisplayStyle.InlineBlock)
            .toAttrs()
    ) {

        // ---------- BUTTON (works on mobile!) ----------
        Div(
            attrs = Modifier
                .padding(8.px)
                .border(2.px, LineStyle.Solid, Color.black)
                .borderRadius(6.px)
                .padding(leftRight = 10.px)
                .cursor(Cursor.Pointer)
                .onClick { expanded = !expanded }   // ❤️ iOS compatible
                .attr("role", "button")
                .attr("tabindex", "0")
                .toAttrs()
        ) {
            Row(
                modifier = Modifier
                    .display(DisplayStyle.Flex)
                    .alignItems(AlignItems.Center)
                    .gap(8.px)
            ) {
                I(
                    attrs = Modifier
                        .size(32.px)
                        .classNames("em", language.flag)
                        .toAttrs()
                )
                MdiKeyboardArrowDown(style = IconStyle.ROUNDED)
            }
        }

        // ---------- MENU ----------
        if (expanded) {
            Column(
                modifier = Modifier
                    .position(Position.Absolute)
                    .top(40.px)
                    .left((-54).px)  // move left to look good
                    .border(2.px, LineStyle.Solid, Color.black)
                    .styleModifier { boxShadow("2px 2px 0 0 black") }
                    .backgroundColor(Color.floralwhite)
                    .borderRadius(12.px)
                    .zIndex(100)
            ) {

                Language.entries.forEach { lang ->
                    Row(
                        modifier = Modifier
                            .display(DisplayStyle.Flex)
                            .alignItems(AlignItems.Center)
                            .padding(6.px)
                            .cursor(Cursor.Pointer)
                            .onClick {
                                onSelect(lang)
                                expanded = false
                            }
                            .styleModifier {
                                property("transition", "background-color 0.15s ease")
                            }
                            .classNames("dropdown-item")
                    ) {
                        I(
                            attrs = Modifier
                                .size(28.px)
                                .classNames("em", lang.flag)
                                .toAttrs()
                        )
                        Span(
                            attrs = ToolbarItemStyle
                                .toModifier()
                                .margin(left = 8.px)
                                .toAttrs()
                        ) {
                            Text(lang.label)
                        }
                    }
                }
            }
        }
    }
}

