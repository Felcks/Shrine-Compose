package com.matheuscorrea.shrine.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheuscorrea.shrine.ui.theme.ShrineTheme

@Composable
fun SummarizedPayment(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 48.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    "total".uppercase(),
                    style = MaterialTheme.typography.body2
                )
                Text(
                    "$141.40",
                    style = MaterialTheme.typography.h5
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    "Subtotal",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    "$115.00",
                    style = MaterialTheme.typography.body2
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    "Shipping",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    "$10.00",
                    style = MaterialTheme.typography.body2
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    "Tax",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    "$11.40",
                    style = MaterialTheme.typography.body2
                )
            }
        }
        Divider(
            color = MaterialTheme.colors.onSecondary.copy(alpha = 0.3f),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SummarizedPaymentPreview() {
    ShrineTheme {
        Surface(
            color = MaterialTheme.colors.secondary
        ) {
            SummarizedPayment()
        }
    }
}
