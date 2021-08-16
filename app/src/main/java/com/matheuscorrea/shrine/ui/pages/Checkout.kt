package com.matheuscorrea.shrine.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.matheuscorrea.shrine.ui.theme.ShrineTheme
import com.matheuscorrea.shrine.ui.widgets.CheckoutCardItem
import com.matheuscorrea.shrine.ui.widgets.CheckoutCouponItem
import com.matheuscorrea.shrine.ui.widgets.CheckoutShippingItem
import com.matheuscorrea.shrine.ui.widgets.SummarizedPayment

@Composable
private fun CheckoutHeader(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Checkout back arrow"
                )
            }
        Text(
            "Checkout".uppercase(),
            style = MaterialTheme.typography.subtitle1
        )
    }
//    TopAppBar(
//        title = {
//            Text(
//                "Checkout",
//                style = MaterialTheme.typography.subtitle1
//            )
//        },
//        backgroundColor = MaterialTheme.colors.secondary,
//        elevation = 0.dp,
//        navigationIcon = {
//            IconButton(onClick = {
//                navController.popBackStack()
//            }) {
//                Icon(
//                    imageVector = Icons.Default.ArrowBack,
//                    contentDescription = "Checkout back arrow"
//                )
//            }
//        }
//
//    )
}

@Preview(showBackground = true)
@Composable
fun CheckoutHeaderPreview() {
    ShrineTheme {
        val navController = rememberNavController()
        Surface(
            color = MaterialTheme.colors.secondary
        ) {
            CheckoutHeader(navController = navController)
        }
    }
}

@Composable
fun Checkout(navController: NavController) {
    Scaffold(
        content = {
            Surface(
                color = MaterialTheme.colors.secondary,
                modifier = Modifier.fillMaxHeight()
            ) {
                Column {
                    CheckoutShippingItem()
                    CheckoutCardItem()
                    CheckoutCouponItem(bottomDividerThickness = 1.dp)
                    SummarizedPayment()
                }
            }
        },
        topBar = {
            Surface(
                color = MaterialTheme.colors.secondary
            ) {
                CheckoutHeader(navController)
            }
        },
        floatingActionButton = {
            Button(
                onClick = {
                    navController.navigate("order_completed")
                }, modifier = Modifier
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
        val navController = rememberNavController()
        Checkout(navController)
    }
}