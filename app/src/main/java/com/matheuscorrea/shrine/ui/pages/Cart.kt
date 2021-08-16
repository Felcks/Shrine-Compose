package com.matheuscorrea.shrine.ui.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.matheuscorrea.shrine.ItemData
import com.matheuscorrea.shrine.SampleItemsData
import com.matheuscorrea.shrine.ui.theme.ShrineTheme
import com.matheuscorrea.shrine.ui.widgets.CartItem
import com.matheuscorrea.shrine.ui.widgets.SummarizedPayment

@Composable
private fun CartHeader(cartSize: Int, expanded: Boolean, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        IconButton(
            onClick = onClick,
        ) {
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
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
            val expanded = remember {
                mutableStateOf(true)
            }
            val onClick = {
                expanded.value = !expanded.value
            }
            CartHeader(cartSize = 15, expanded = true, onClick = onClick)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun Cart(
    items: List<ItemData> = SampleItemsData,
    onRemoveClick: (itemData: ItemData) -> Unit,
    navController: NavController,
) {
    val expanded = remember { mutableStateOf(true) }
    val onClick = {
        expanded.value = !expanded.value
    }
    Scaffold(
        content = {
            Surface(
                color = MaterialTheme.colors.secondary,
                modifier = Modifier.fillMaxHeight()
            ) {
                Column(Modifier.animateContentSize()) {
                    CartHeader(cartSize = items.size, expanded.value, onClick)
                    AnimatedVisibility(visible = expanded.value) {
                        LazyColumn(
                            modifier = Modifier.weight(10f)
                        ) {
                            itemsIndexed(items) { index, it ->
                                CartItem(
                                    item = it,
                                    bottomDividerThickness = if (index == items.size - 1) 1.dp else 0.dp,
                                    onRemoveClick = onRemoveClick
                                )
                            }
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

@ExperimentalAnimationApi
@Composable
fun CartScreen(
    purchaseViewModel: PurchaseViewModel,
    navController: NavController){
    val items = purchaseViewModel.state.collectAsState()
    Cart(items.value, purchaseViewModel::removeItem, navController)
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun CartPreview() {
    ShrineTheme {
        val navController = rememberNavController()
        val items = SampleItemsData
        Cart(
            items,
            {},
            navController = navController
        )
    }
}

