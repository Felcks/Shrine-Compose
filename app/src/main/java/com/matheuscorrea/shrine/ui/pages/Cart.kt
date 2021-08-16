package com.matheuscorrea.shrine

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.matheuscorrea.shrine.ui.theme.ShrineTheme
import com.matheuscorrea.shrine.ui.widgets.CartItem
import com.matheuscorrea.shrine.ui.widgets.SummarizedPayment

@Composable
private fun CartHeader(cartSize: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        IconButton(
            onClick = {},
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Collapse cart icon"
            )
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Row {
                Text(
                    "Cart".uppercase(),
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text("$cartSize items".uppercase())

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartHeaderPreview() {
    ShrineTheme {
        Surface(
            Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.secondary
        ) {
            CartHeader(cartSize = 15)
        }
    }
}

@Composable
fun Cart(
    navController: NavController,
    items: List<ItemData> = SampleItemsData
) {
    Scaffold(
        content = {
            Surface(
                color = MaterialTheme.colors.secondary,
                modifier = Modifier.fillMaxHeight()
            ) {
                Column {
                    CartHeader(cartSize = items.size)
                    LazyColumn(
                        modifier = Modifier.weight(10f)
                    ) {
                        itemsIndexed(items) { index, it ->
                            CartItem(
                                item = it,
                                bottomDividerThickness = if (index == items.size - 1) 1.dp else 0.dp
                            )
                        }
                    }
                    SummarizedPayment(
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        },
        floatingActionButton = {
            Button(
                onClick = {
                    navController.navigate("checkout")
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text("Proceed to Checkout".uppercase())
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    )
}

@Preview(showBackground = true)
@Composable
fun CartPreview() {
    ShrineTheme {
        val navController = rememberNavController()
        Cart(navController = navController)
    }
}

