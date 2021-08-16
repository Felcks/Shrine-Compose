package com.matheuscorrea.shrine.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.matheuscorrea.shrine.SampleItemsData
import com.matheuscorrea.shrine.ui.theme.ShrineTheme
import com.matheuscorrea.shrine.ui.widgets.CartItem
import com.matheuscorrea.shrine.ui.widgets.CheckoutCardItem
import com.matheuscorrea.shrine.ui.widgets.CheckoutShippingItem
import com.matheuscorrea.shrine.ui.widgets.SummarizedPayment

@Composable
private fun OrderCompletedHeader(navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Order completed back arrow"
            )
        }
        Text(
            "Order completed".uppercase(),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderCompletedHeaderPreview() {
    val navController = rememberNavController()
    ShrineTheme {
        OrderCompletedHeader(navController)
    }
}

@Composable
private fun OrderCompletedTitle() {
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
fun OrderCompletedTitlePreview() {
    ShrineTheme {
        Surface(color = MaterialTheme.colors.secondary) {
            OrderCompletedTitle()
        }
    }
}


@Composable
fun OrderCompleted(navController: NavController) {
    ShrineTheme {
        Scaffold(
            topBar = {
                Surface(
                    color = MaterialTheme.colors.secondary
                ) {
                    OrderCompletedHeader(navController)
                }
            },
            content = {
                Surface(
                    color = MaterialTheme.colors.secondary
                ) {
                    Column {
                        OrderCompletedTitle()
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
        )
    }
}

@Preview
@Composable
fun OrderCompletedPreview() {
    ShrineTheme {
        val nav = rememberNavController()
        OrderCompleted(nav)
    }
}