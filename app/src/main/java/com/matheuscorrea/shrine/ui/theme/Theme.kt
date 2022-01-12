package com.matheuscorrea.shrine.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShrineTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colorScheme = ShrineLightColorScheme,
        typography = Typography,
        content = content
    )
}


@Preview(name = "Theme test", showBackground = true)
@Composable
fun ThemeTest() {
    Column(
        Modifier.padding(48.dp),
    ) {
        ShrineTheme {
            Button(onClick = {}) {
                Text("Button1")
            }
            Spacer(Modifier.height(16.dp))
            Surface {
                Column(
                    Modifier.padding(16.dp)
                ) {
                    Text("This is a card")
                }
            }
        }
        Spacer(Modifier.height(16.dp))
        MaterialTheme {
            Button(onClick = {}) {
                Text("Button1")
            }
            Spacer(Modifier.height(16.dp))
            Surface {
                Column(
                    Modifier.padding(16.dp)
                ) {
                    Text("This is a card")
                }
            }
        }
    }
}

@Preview(name = "Typography test", widthDp = 720, showBackground = true)
@Composable
fun TypographyThemeTest() {
    ShrineTheme {
        Column {
            Text(
                "H1 / Rubik Light",
                style = MaterialTheme.typography.displayLarge
            )
            Text(
                "H2 / Rubik Light",
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                "H3 / Rubik Regular",
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                "Body1 / Rubik Regular",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}