package carlosgub.dev.components.styles.font

import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight

fun Modifier.regular(): Modifier = this
    .fontFamily("Source Sans 3")
    .fontWeight(FontWeight.Normal)

fun Modifier.light(): Modifier = this
    .fontFamily("Source Sans 3")
    .fontWeight(FontWeight.Light)

fun Modifier.semiBold(): Modifier = this
    .fontFamily("Source Sans 3")
    .fontWeight(FontWeight.SemiBold)

fun Modifier.bold(): Modifier = this
    .fontFamily("Source Sans 3")
    .fontWeight(FontWeight.Bold)