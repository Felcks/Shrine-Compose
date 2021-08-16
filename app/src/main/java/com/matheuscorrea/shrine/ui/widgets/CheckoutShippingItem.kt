package com.matheuscorrea.shrine.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarRepair
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheuscorrea.shrine.SampleShippingData
import com.matheuscorrea.shrine.Shipping
import com.matheuscorrea.shrine.ui.theme.ShrineTheme

@Composable
fun CheckoutShippingItem(item: Shipping = SampleShippingData) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        IconButton(onClick = {}, modifier = Modifier.padding(top = 8.dp)) {
            Icon(
                imageVector = Icons.Default.CarRepair,
                contentDescription = "Car rental icon",
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
        ) {
            Divider(color = MaterialTheme.colors.onSecondary.copy(alpha = 0.3f))
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(bottom = 16.dp),
            ) {
                Column(verticalArrangement = Arrangement.Center, modifier = Modifier.weight(5f)) {
                    Text(
                        text = "Shipping".uppercase(),
                        style = MaterialTheme.typography.body2
                    )
                    Text(
                        text = "${item.number} ${item.street}, ${item.complement}",
                        style = MaterialTheme.typography.subtitle2,
                    )
                    Text(
                        text = "${item.city}, ${item.zipCode}",
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
fun CheckoutShippingItemPreview() {
    ShrineTheme {
        Surface(
            color = MaterialTheme.colors.secondary
        ) {
            CheckoutShippingItem()
        }
    }
}