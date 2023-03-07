package au.com.crownresorts.crma.compose

//import androidx.compose.foundation.layout.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.CrownTheme


@Composable
fun ButtonPrimary(text: String, enabled: Boolean = true) {
    ButtonCrown(text = text, enabled = enabled, isPrimary = true, {})
}

@Composable
fun ButtonSecondary(text: String, enabled: Boolean = true) {
    ButtonCrown(text = text, enabled = enabled, isPrimary = false, {})
}

@Composable
private fun ButtonCrown(text: String, enabled: Boolean = true, isPrimary: Boolean, callback: () -> Unit) {

    val colors = if (isPrimary) CrownTheme.colors.buttonPrimer else CrownTheme.colors.buttonSecondary
    val shape = MaterialTheme.shapes.small //RoundedCornerShape()
    Row(modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 36.dp, end = 36.dp),
            enabled = enabled,
            shape = shape,
            border = BorderStroke(1.dp, if (enabled) colors.border else colors.disableBorder),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = colors.bg,
                contentColor = colors.text,
                disabledContainerColor = colors.disableBg,
                disabledContentColor = colors.disableText,
            )
        ) {
            Text(
                text = text.uppercase(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Preview
@Composable
private fun PreviewButtonsLight() {
    CrownTheme(isDark = false) {
        Column {
            ButtonPrimary(text = "Text 1", enabled = true)
            ButtonPrimary(text = "Text 1", enabled = false)
            Spacer(modifier = Modifier.padding(top = 24.dp))
            ButtonSecondary(text = "Text 1", enabled = true)
            ButtonSecondary(text = "Text 1", enabled = false)
        }
    }
}


@Preview
@Composable
private fun PreviewButtonsDark() {
    CrownTheme(isDark = true) {
        Column(modifier = Modifier.background(color = Color.Black)) {
            ButtonPrimary(text = "Text 1", enabled = true)
            ButtonPrimary(text = "Text 1", enabled = false)
            Spacer(modifier = Modifier.padding(top = 24.dp))
            ButtonSecondary(text = "Text 1", enabled = true)
            ButtonSecondary(text = "Text 1", enabled = false)
        }
    }
}


@Preview(widthDp = 400)
@Composable
private fun PreviewButtonSecondaryDarkaaa() {
    CrownTheme(isDark = true) {

        Column {
            ButtonSecondary(
                text = "Primary CTA with a very long label can sometime be unavoidable",
                enabled = true
            )
            ButtonSecondary(text = "Text 1", enabled = false)
        }
    }
}