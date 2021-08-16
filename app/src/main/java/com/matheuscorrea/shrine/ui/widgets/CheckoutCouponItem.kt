package com.matheuscorrea.shrine.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuscorrea.shrine.CreditCard
import com.matheuscorrea.shrine.SampleCreditCard
import com.matheuscorrea.shrine.ui.theme.ShrineTheme

@Composable
fun CheckoutCouponItem(modifier: Modifier = Modifier, bottomDividerThickness: Dp = 0.dp) {
    val (text, onTextChange) = remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        IconButton(onClick = {}, modifier = Modifier.padding(top = 4.dp)) {
            Icon(
                imageVector = Icons.Default.CardGiftcard,
                contentDescription = "Car rental icon",
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .weight(5f)
        ) {
            Divider(color = MaterialTheme.colors.onSecondary.copy(alpha = 0.3f))
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Have a Promo Code?".uppercase(),
                style = MaterialTheme.typography.body2
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = text, onValueChange = onTextChange,
                textStyle = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(vertical = 0.dp),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Divider(
                color = MaterialTheme.colors.onSecondary.copy(alpha = 0.3f),
                thickness = bottomDividerThickness
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutCouponItemPreview() {
    ShrineTheme {
        Surface(
            color = MaterialTheme.colors.secondary
        ) {
            CheckoutCouponItem()
        }
    }
}