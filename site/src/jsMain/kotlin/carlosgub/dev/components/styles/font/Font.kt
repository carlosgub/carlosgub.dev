package carlosgub.dev.components.styles.font

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily

fun Modifier.regular(): Modifier = this.fontFamily("PPMoriRegular")
fun Modifier.light(): Modifier = this.fontFamily("PPMoriLight")
fun Modifier.bold(): Modifier = this.fontFamily("PPMoriSemiBold")