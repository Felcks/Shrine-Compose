package com.matheuscorrea.shrine.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheuscorrea.shrine.SampleItemsData
import com.matheuscorrea.shrine.ui.theme.ShrineTheme
import com.matheuscorrea.shrine.ui.widgets.CartItem
import com.matheuscorrea.shrine.ui.widgets.CheckoutCardItem
import com.matheuscorrea.shrine.ui.widgets.CheckoutShippingItem
import com.matheuscorrea.shrine.ui.widgets.SummarizedPayment

@Composable
private fun OrderCompletedHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp, start = 48.dp, end = 16.dp)
    ) {
        Text(
            text = "Hang tight, your order is on its way!",
            style = MaterialTheme.typography.h5,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderCompletedHeaderPreview() {
    ShrineTheme {
        Surface(
            color = MaterialTheme.colors.secondary
        ) {
            Column {
                OrderCompletedHeader()
                CheckoutShippingItem()
                CheckoutCardItem()
                LazyColumn(
                ) {
                    itemsIndexed(SampleItemsData.subList(0, 2)) { index, it ->
                        CartItem(
                            item = it,
                            bottomDividerThickness = if (index == SampleItemsData.subList(
                                    0,
                                    2
                                ).size - 1
                            ) 1.dp else 0.dp
                        )
                    }
                }
                SummarizedPayment(
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun OrderCompleted() {
    Scaffold(
        content = {
            Column {
                OrderCompleted()

            }

        }
    )
}

@Preview
@Composable
fun OrderCompletedPreview() {
    ShrineTheme {
        OrderCompleted()
    }
}