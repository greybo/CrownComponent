package au.com.crownresorts.crma.compose.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import au.com.crownresorts.crma.R
import au.com.crownresorts.crma.compose.theme.CrownTheme


@Composable
fun TextWithIcon(text: String = "Multi-Level & P4 \nParking", iconId: Int = R.drawable.ic_new_chip) {
    val imageVector = ImageVector.vectorResource(id = iconId)
    TextWithIcon(
        text = text,
//        icon = imageVector
    )
}

@Composable
fun TextWithIcon(text: String) {
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle()) {
            append(text)
            append(" ")
        }
        withStyle(style = SpanStyle() ) {
            appendInlineContent("icon")
        }
    }
    val inlineContent = mapOf(
        "icon" to InlineTextContent(
            placeholder = Placeholder(
                width = 56.sp,
                height = 36.sp,
                placeholderVerticalAlign = PlaceholderVerticalAlign.Bottom
            ),
            children = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = "New",
                        color = CrownTheme.colors.goldDefault,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 2.dp, end = 2.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = CrownTheme.colors.cardBg)
                            .padding(bottom = 2.dp, top = 2.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        )
    )

    Text(
        text = annotatedText,
        modifier = Modifier.fillMaxWidth(),
        style = MaterialTheme.typography.bodyLarge,
        inlineContent = inlineContent,
        color = CrownTheme.colors.textHigh
    )
}

@Composable
private fun TextWithIconDemo() {

    val icon = painterResource(id = R.drawable.ic_new_chip)
    Column {
        TextWithIcon(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum eu velit non est porta",
//            icon = Icons.Default.Info
        )
        TextWithIcon(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
//            icon = Icons.Default.Info
        )
        TextWithIcon(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum eu velit non est porta. Duis vestibulum vel velit id tincidunt. Nunc imperdiet viverra magna in aliquet. Sed pretium, nibh quis feugiat ullamcorper, mauris lorem imperdiet sem, at aliquam sapien nulla eget libero.",
//            icon = Icons.Default.Info
        )
    }
}

@Preview
@Composable
fun PreviewTextWithIcon() {
    CrownTheme {
        Column(modifier = Modifier.background(color = Color.DarkGray)) {
            TextWithIconDemo()
            TextWithIcon("Multi-Level & P4 \nParking")
        }
    }
}