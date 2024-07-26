package carlosgub.dev.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.ElementRefScope
import com.varabyte.kobweb.compose.dom.registerRefScope
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.ariaLabel
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.forms.*
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.common.DisabledStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.ColorScheme
import com.varabyte.kobweb.silk.theme.colors.palette.Palette
import com.varabyte.kobweb.silk.theme.colors.palette.switch
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Label
import org.w3c.dom.HTMLElement

internal fun SwitchShape.toModifier() = Modifier
    .thenIf(this == SwitchShape.RECTANGLE) { Modifier.setVariable(SwitchVars.BorderRadius, 0.px) }

/**
 * Creates a toggleable switch.
 *
 * Note that visual control of the switch is fairly limited compared to many other widgets -- you can't directly modify
 * the width or height of the track or the thumb parts. Instead, configure your switch by passing in the relevant
 * parameters.
 *
 * Note that this widget is backed by a checkbox input. Use the `ref` callback if you need access to it:
 *
 * ```
 * ref = ref { element -> element.getElementsByTagName("input")[0] as HTMLInputElement }
 * ```
 *
 * @param checked Whether the switch is currently checked or not.
 * @param onCheckedChange A callback which is invoked when the switch is toggled.
 * @param modifier The modifier to apply to the *container* of this switch element. This will not be applied to the
 *   switch itself (since its configuration comes from the other parameters).
 * @param enabled Whether the switch is enabled or not. If not, the switch will be rendered in a disabled state and will
 *   not be interactable.
 * @param size The size of the switch. Defaults to [SwitchSize.MD]. You can implement your own [SwitchSize] if you want
 *   custom sizing.
 * @param colorScheme An optional color scheme to use for the switch. If not provided, the switch will use the
 *   appropriate colors from the [Palette].
 * @param thumbColor An optional override for the color of the thumb.
 * @param focusBorderColor An optional override for the border color when the input is focused.
 * @param ref Provides a reference to the *container* of the switch. Its direct children will be the underlying checkbox
 *   element and the switch track, whose direct child will be the thumb element.
 */
@Composable
fun Switch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    variant: CssStyleVariant<SwitchKind>? = null,
    enabled: Boolean = true,
    size: SwitchSize = SwitchSize.MD,
    shape: SwitchShape = SwitchShape.PILL,
    colorScheme: ColorScheme? = null,
    thumbColor: CSSColorValue? = null,
    focusBorderColor: CSSColorValue? = null,
    ref: ElementRefScope<HTMLElement>? = null,
) {
    val colorMode = ColorMode.current
    val switchPalette = colorMode.toPalette().switch
    // Use a label so it intercepts clicks and passes them to the inner Input
    Label(
        attrs = SwitchStyle.toModifier(variant)
            .then(size.toModifier())
            .then(shape.toModifier())
            .then(modifier)
            .toAttrs()
    ) {
        registerRefScope(ref)
        // We base Switch on a checkbox input for a11y + built-in input/keyboard support, but hide the checkbox itself
        // and render the switch separately. We do however allow it to be focused, which combined with the outer label
        // means that both clicks and keyboard events will toggle the checkbox.
        Input(
            type = InputType.Checkbox,
            value = checked,
            onValueChanged = { onCheckedChange(!checked) },
            variant = SwitchInputVariant,
            enabled = enabled,
            modifier = Modifier
                .ariaLabel("switch")
        )
        Box(
            SwitchTrackStyle.toModifier()
                .setVariable(
                    SwitchVars.TrackBackgroundColor,
                    if (checked) colorScheme?.let { if (colorMode.isDark) it._200 else it._700 }
                        ?: switchPalette.backgroundOn else switchPalette.backgroundOff
                )
                .setVariable(SwitchVars.ThumbColor, thumbColor)
                .setVariable(SwitchVars.FocusColor, focusBorderColor)
                .thenIf(!enabled) { DisabledStyle.toModifier() }
        ) {
            Box(
                SwitchThumbStyle.toModifier()
                    .setVariable(
                        SwitchVars.ThumbOffset,
                        if (checked) SwitchVars.TrackWidth.value() - SwitchVars.TrackHeight.value() else 0.percent
                    )
            )
        }
    }
}
