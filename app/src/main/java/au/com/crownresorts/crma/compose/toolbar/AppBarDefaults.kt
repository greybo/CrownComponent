package au.com.crownresorts.crma.compose.toolbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import au.com.crownresorts.crma.compose.theme.CrownTheme

enum class ActionButtonType(val icon: ImageVector) {
    Search(Icons.Default.Search),
    Close(Icons.Default.Close),
    ArrowBack(Icons.Default.ArrowBack)
}

data class ActionToolbar(val type: ActionButtonType, val color: Color? = null)

data class ColorToolbar(
    val backgroundColor: Color,
    val contentColor: Color
)

@Composable
fun toolbarColorDefault(
    backgroundColor: Color = CrownTheme.colors.appBar.background,
    contentColor: Color = CrownTheme.colors.appBar.tint
): ColorToolbar {
    return ColorToolbar(backgroundColor, contentColor)
}

fun homeActionDefault(
    iconType: ActionButtonType? = ActionButtonType.ArrowBack,
    color: Color? = null
): ActionToolbar? {
    return iconType?.let { ActionToolbar(type = it, color = color) }
}

fun rightActionDefault(
    iconType: ActionButtonType? = ActionButtonType.Search,
    color: Color? = null
): ActionToolbar? {
    return iconType?.let { ActionToolbar(type = it, color = color) }
}

interface IToolbarModel {
    var title: String?
    var homeAction: ActionToolbar?
    var rightAction: ActionToolbar?
    var colorsDefault: ColorToolbar
    var callback: (ActionButtonType) -> Unit
}

data class ToolbarModel(
    override var title: String?,
    override var homeAction: ActionToolbar?,
    override var rightAction: ActionToolbar?,
    override var colorsDefault: ColorToolbar,
    override var callback: (ActionButtonType) -> Unit
) : IToolbarModel

@Composable
fun toolbarModelDefault(
    titleText: String = "Page title",
    homeIcon: ActionToolbar? = homeActionDefault(),
    rightIcon: ActionToolbar? = rightActionDefault(),
    colors: ColorToolbar = toolbarColorDefault(),
    action: (ActionButtonType) -> Unit = {}
) = ToolbarModel(
    title = titleText,
    homeAction = homeIcon,
    rightAction = rightIcon,
    colorsDefault = colors,
    callback = action
)