package com.matheuscorrea.shrine.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheuscorrea.shrine.ui.theme.ShrineTheme
import com.matheuscorrea.shrine.ui.widgets.CheckoutCardItem
import com.matheuscorrea.shrine.ui.widgets.CheckoutCouponItem
import com.matheuscorrea.shrine.ui.widgets.CheckoutShippingItem
import com.matheuscorrea.shrine.ui.widgets.SummarizedPayment

@Composable
private fun CheckoutHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp, start = 48.dp, end = 16.dp)
    ) {
        Text(
            "Checkout",
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutHeaderPreview() {
    ShrineTheme {
        Surface(
            color = MaterialTheme.colors.secondary
        ) {
            CheckoutHeader()
        }
    }
}

@Composable
fun Checkout() {
    Scaffold(
        content = {
            Surface(
                color = MaterialTheme.colors.secondary,
                modifier = Modifier.fillMaxHeight()
            ) {
                Column {
                    CheckoutHeader()
                    CheckoutShippingItem()
                    CheckoutCardItem()
                    CheckoutCouponItem(bottomDividerThickness = 1.dp)
                    SummarizedPayment()
                }
            }
        },
        floatingActionButton = {
            Button(
                onClick = {}, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text("Place Order".uppercase())
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    )
}

@Preview
@Composable
fun CheckoutPreview() {
    ShrineTheme {
        Checkout()
    }
}