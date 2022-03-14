package com.aaronx.swallismarket.activities

import SwalisMarketTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aaronx.swallismarket.R
import com.aaronx.swallismarket.fragments.*
import com.aaronx.swallismarket.ui.composables.BottomBar
import com.aaronx.swallismarket.ui.composables.NavRoute
import com.aaronx.swallismarket.ui.composables.TopBar
import com.aaronx.swallismarket.ui.theme.ViewShape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}


@Composable
fun MainContent(){
    val navController = rememberNavController()
    val currentBackStack = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack.value?.destination?.route

    val routes = arrayListOf(
        NavRoute(R.drawable.ic_home, "Home"),
        NavRoute(R.drawable.ic_bag_2, "Cart"),
        NavRoute(R.drawable.ic_orders, "Orders")
    )

    SwalisMarketTheme{
        Scaffold(
            topBar = { TopBar() },

            content = {
                NavHost(navController = navController,
                        startDestination = "Home",
                        modifier = Modifier
                            .background(MaterialTheme.colors.surface
                                , MaterialTheme.shapes.ViewShape)) {
                    composable("Home") { HomeFragment(navController) }
                    composable("Cart") { CartFragment() }
                    composable("Orders") { OrdersFragment() }
                    composable("Profile") { ProfileFragment() }
                    composable("Home/Product/{id}"){ ProductDetailFragment() }
                }
            },
            bottomBar = {
                AnimatedVisibility(visible = currentRoute != "Home/Product/{id}") {
                    BottomBar(
                        navController = navController,
                        Routes = routes,
                        profileRoute = "Profile"
                    )
                }
            },
            backgroundColor = MaterialTheme.colors.background
        )

    }
}