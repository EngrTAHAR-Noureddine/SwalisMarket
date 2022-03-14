package com.aaronx.swallismarket.activities

import SwalisMarketTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aaronx.swallismarket.fragments.LoginFragment
import com.aaronx.swallismarket.fragments.RegisterFragment
import com.aaronx.swallismarket.ui.composables.TopBar
import com.aaronx.swallismarket.ui.theme.ViewShape

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthActivity()
        }
    }
}

@Composable
fun AuthActivity(){
    val navController = rememberNavController()

    SwalisMarketTheme {
        Scaffold(
            topBar = { TopBar() },
            content = {
                NavHost(navController = navController
                    , startDestination = "Login"
                    ,modifier = Modifier
                        .background(
                            MaterialTheme.colors.surface
                            , MaterialTheme.shapes.ViewShape)){

                    composable("Login") { LoginFragment(navController) }
                    composable("Registration") { RegisterFragment(navController)}
                }
            }
        )
    }
}