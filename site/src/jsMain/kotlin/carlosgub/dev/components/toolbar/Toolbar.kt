package carlosgub.dev.components.toolbar


import androidx.compose.runtime.*
import carlosgub.dev.model.Section
import carlosgub.dev.components.styles.*
import carlosgub.dev.components.styles.components.H6Style
import carlosgub.dev.components.styles.font.semiBold
import carlosgub.dev.model.Language
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.boxShadow
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
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.unaryMinus
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
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
fun Toolbar(language: Language,onLanguageSelected: (Language) -> Unit) {
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
            ToolbarOptionsForDesktop(
                language = language,
                onLanguageSelected = onLanguageSelected
            )

        }
        if (menuOpen) {
            MobileMenu(onCloseMenu = { menuOpen = false }, language)
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
            .displayIfAtLeast(Breakpoint.MD),
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
fun MobileMenu(onCloseMenu: () -> Unit, language: Language) {
    Column(
        modifier = ToolbarMenuMobileStyle.toModifier()
            .displayUntil(Breakpoint.MD)
    ) {
        NavItemsMobile(
            onItemPressed = onCloseMenu,
            language = language
        )
    }
}

@Composable
private fun NavItemsMobile(onItemPressed: () -> Unit = {}, language: Language) {
    NavItem(Section.Home.getText(language), Section.Home.id, onItemPressed)
    NavItem(Section.About.getText(language), Section.About.id, onItemPressed)
    NavItem(Section.Experience.getText(language), Section.Experience.id, onItemPressed)
    NavItem(Section.Projects.getText(language), Section.Projects.id, onItemPressed)
    NavItem(Section.Talks.getText(language), Section.Talks.id, onItemPressed)
    NavItem(Section.ContactMe.getText(language), Section.ContactMe.id, onItemPressed)
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
        selected = language,
        onSelect = onLanguageSelected
    )
}

@Composable
fun LanguageDropdown(
    selected: Language,
    onSelect: (Language) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Div(
        Modifier
            .position(Position.Relative)
            .display(DisplayStyle.InlineBlock)
            .toAttrs()
    ) {
        Row(
            modifier = Modifier
                .padding(8.px)
                .border(2.px, LineStyle.Solid, Color.black)
                .borderRadius(6.px)
                .padding(leftRight = 10.px)
                .display(DisplayStyle.Flex)
                .alignItems(AlignItems.Center)
                .cursor(Cursor.Pointer)
                .onClick { expanded = !expanded }
        ) {
            Img(
                src = selected.flagUrl,
                attrs = Modifier
                    .padding(left = 8.px)
                    .size(36.px).toAttrs()
            )
            MdiKeyboardArrowDown(
                style = IconStyle.ROUNDED
            )
        }

        // --- Dropdown menu ---
        if (expanded) {
            Column(
                modifier = Modifier
                    .position(Position.Absolute)       //<-- THIS FIXES THE MOVEMENT
                    .top(50.px)
                    .left((-48).px)
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
                            // hover: usar styleModifier
                            .styleModifier {
                                property("transition", "background-color 0.15s ease")
                            }
                            // hover real: usar CSS selector
                            .classNames("dropdown-item")
                    ) {
                        Img(
                            src = lang.flagUrl,
                            attrs = Modifier.size(32.px).toAttrs()
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