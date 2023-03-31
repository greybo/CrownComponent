package au.com.crownresorts.crma.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import au.com.crownresorts.crma.R
import au.com.crownresorts.crma.compose.theme.CrownTheme


@Composable
fun TextWithIcon(text: String = "Multi-Level & P4 \nParking", iconId: Int = R.drawable.ic_new_chip) {
    val icon = painterResource(id = iconId)

    TextWithIcon(
        text = text,
        icon = icon
    )
}

@Composable
fun TextWithIcon(text: String, icon: Painter) {
    val annotatedText = buildAnnotatedString {
        append(text)
        append(" ")
//        withStyle(style = SpanStyle(fontSize = 24.sp)) {
//            appendInlineContent("icon")
//        }
        withStyle(style = SpanStyle(/*verticalAlign = VerticalAlign.Bottom*/)) {
            appendInlineContent("icon")
        }
    }

    val inlineContent = mapOf(
        "icon" to InlineTextContent(
            placeholder = Placeholder(
                width = 24.sp,
                height = 24.sp,
                placeholderVerticalAlign = PlaceholderVerticalAlign.Bottom
            ),
            children = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_new_chip),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        )
    )

    Text(
        text = annotatedText,
        modifier = Modifier.fillMaxWidth(),
        inlineContent = inlineContent
    )
}

@Composable
fun TextWithIconDemo() {

    val icon = painterResource(id = R.drawable.ic_new_chip)
    Column {
        TextWithIcon(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum eu velit non est porta",
            icon = icon
        )
        TextWithIcon(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            icon = icon
        )
        TextWithIcon(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum eu velit non est porta. Duis vestibulum vel velit id tincidunt. Nunc imperdiet viverra magna in aliquet. Sed pretium, nibh quis feugiat ullamcorper, mauris lorem imperdiet sem, at aliquam sapien nulla eget libero.",
            icon = icon
        )
    }
}

@Preview
@Composable
fun PreviewAvailableRewards() {
    CrownTheme {
        TextWithIcon()
//        TextWithIconDemo()
//        AvailableRewards()
    }
}