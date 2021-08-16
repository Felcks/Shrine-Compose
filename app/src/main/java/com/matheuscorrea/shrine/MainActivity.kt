package com.matheuscorrea.shrine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.matheuscorrea.shrine.ui.pages.Checkout
import com.matheuscorrea.shrine.ui.pages.OrderCompleted
import com.matheuscorrea.shrine.ui.theme.ShrineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ShrineTheme {
                NavHost(
                    navController = navController,
                    startDestination = "cart"
                ){
                    composable("cart") {
                        Cart(navController)
                    }
                    composable("checkout") {
                        Checkout(navController)
                    }
                    composable("order_completed") {
                        OrderCompleted(navController)
                    }
                }
            }
        }
    }
}