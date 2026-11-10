package io.github.artcraftandroid.capcraft.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/** NexVora Motion's palette: a deep midnight editor with cyan and electric-purple accents. */
object Palette {
    val Black = Color(0xFF090B12)
    /** The editor's chrome: top bar, timeline and dock. */
    val Chrome = Color(0xFF0D101A)
    /** Panels and sheets over the editor. */
    val Panel = Color(0xFF111522)
    /** Cards and raised rows. */
    val Card = Color(0xFF171D2B)
    val CardPressed = Color(0xFF212839)
    val Divider = Color(0xFF283044)
    val Accent = Color(0xFF00D5FF)
    /** The second accent: electric purple. */
    val Purple = Color(0xFF8957FF)
    /** Words on the accent: the Export button's dark ink. */
    val OnAccent = Color(0xFF090B12)
    /** The editor's top part: top bar, preview surround and play bar. */
    val EditorTop = Color(0xFF0E111B)
    /** The timeline and the bottom bar under it. */
    val Timeline = Color(0xFF131827)
    /** The bottom bar while a clip is selected, and the panels. */
    val DockSelected = Color(0xFF171D2B)
    /** The back button of a bottom bar level. */
    val DockBack = Color(0xFF2A3247)
    /** Labels and icons in the bottom bar. */
    val DockText = Color(0xFFD5DBE8)
    /** The resolution chip in the top bar. */
    val Chip = Color(0xFF1D2333)
    /** The "add audio" / "add text" rows and their tiles. */
    val HintRow = Color(0xFF171D2B)
    val HintIcon = Color(0xFF6C7691)
    val Text = Color(0xFFF7F9FF)
    val TextSecondary = Color(0xFF9AA5B8)
    val TextTertiary = Color(0xFF677189)
    val Disabled = Color(0xFF454D60)
    /** Timeline clip colours by row. */
    val TextClip = Color(0xFFE67300)
    /** Captions, a lighter amber than titles. */
    val CaptionClip = Color(0xFFDA9208)
    val EffectClip = Color(0xFF8957FF)
    val FilterClip = Color(0xFFE36BBF)
    val StickerClip = Color(0xFFDCB108)
    val AudioClip = Color(0xFF2A5256)
    /** Beat marks on sound clips. */
    val Beat = Color(0xFFFFD60A)
    val AudioWave = Color(0xFF00B8DB)
    val OverlayClip = Color(0xFF232A3C)
    val Danger = Color(0xFFFF4D4F)
}

object Type {
    val Title = TextStyle(color = Palette.Text, fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
    val Body = TextStyle(color = Palette.Text, fontSize = 14.sp)
    val BodyStrong = TextStyle(color = Palette.Text, fontSize = 14.sp, fontWeight = FontWeight.Medium)
    val Small = TextStyle(color = Palette.TextSecondary, fontSize = 12.sp)
    val Tiny = TextStyle(color = Palette.TextSecondary, fontSize = 10.sp)
    val DockLabel = TextStyle(color = Palette.Text, fontSize = 10.sp)
}

@Composable
fun CapCraftTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Palette.Accent,
            onPrimary = Palette.OnAccent,
            background = Palette.Black,
            surface = Palette.Panel,
            onSurface = Palette.Text,
            onBackground = Palette.Text,
            secondary = Palette.Purple,
            outline = Palette.Divider,
        ),
        content = content,
    )
}
