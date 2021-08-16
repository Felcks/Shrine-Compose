package com.matheuscorrea.shrine.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheuscorrea.shrine.CreditCard
import com.matheuscorrea.shrine.SampleCreditCard
import com.matheuscorrea.shrine.ui.theme.ShrineTheme

@Composable
fun CheckoutCardItem(item: CreditCard = SampleCreditCard) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        IconButton(onClick = {}, modifier = Modifier.padding(top = 4.dp)) {
            Icon(
                imageVector = Icons.Default.CreditCard,
                contentDescription = "Car rental icon",
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
        ) {
            Divider(color = MaterialTheme.colors.onSecondary.copy(alpha = 0.3f))
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.padding(bottom = 16.dp),
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(5f)
                ) {
                    Text(
                        text = "Payment".uppercase(),
                        style = MaterialTheme.typography.body2
                    )
                    Text(
                        text = item.flag,
                        style = MaterialTheme.typography.subtitle2,
                    )
                    Text(
                        text = item.number,
                        style = MaterialTheme.typography.subtitle2,
                    )
                }
                IconButton(onClick = {}, modifier = Modifier.weight(1f)) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Shipping edit icon",
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutCardItemPreview() {
    ShrineTheme {
        Surface(
            color = MaterialTheme.colors.secondary
        ) {
            CheckoutCardItem()
        }
    }
}