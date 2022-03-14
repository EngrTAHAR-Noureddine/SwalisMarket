package com.aaronx.swallismarket.fragments

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aaronx.swallismarket.R
import com.aaronx.swallismarket.activities.MainActivity
import com.aaronx.swallismarket.ui.composables.AdvancedTextField
import com.aaronx.swallismarket.ui.composables.EmButton
import com.aaronx.swallismarket.ui.theme.IconColor
import com.aaronx.swallismarket.ui.theme.SurfaceColor

@Composable
fun RegisterFragment(navController: NavController){

    var searchQuery by rememberSaveable { mutableStateOf("") }
    val onSearchQueryChange: (String)->Unit = {
        searchQuery = it
    }

    val activity = LocalContext.current as? Activity

    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally) {

        LazyColumn {

            item {
                Text(text = "Create a Swalis account"
                    , textAlign = TextAlign.Center
                    , color = MaterialTheme.colors.IconColor
                    , fontSize = 24.sp
                    , fontWeight = FontWeight.Bold
                    , modifier = Modifier
                        .padding(32.dp)
                        .fillMaxWidth())
            }

            item {
                Row {
                    AdvancedTextField(modifier = Modifier
                        .padding(all = 8.dp)
                        .height(55.dp)
                        .weight(1F)
                        .background(
                            color = MaterialTheme.colors.SurfaceColor,
                            MaterialTheme.shapes.medium
                        )
                        .clip(MaterialTheme.shapes.medium),
                        hint = "Name"
                        , input = searchQuery
                        , onInputChange = onSearchQueryChange)

                    AdvancedTextField(modifier = Modifier
                        .padding(all = 8.dp)
                        .height(55.dp)
                        .weight(1F)
                        .background(
                            color = MaterialTheme.colors.SurfaceColor,
                            MaterialTheme.shapes.medium
                        )
                        .clip(MaterialTheme.shapes.medium),
                        hint = "Surname"
                        , input = searchQuery
                        , onInputChange = onSearchQueryChange)
                }
            }

            item {
                Row {
                    AdvancedTextField(modifier = Modifier
                        .padding(all = 8.dp)
                        .height(55.dp)
                        .weight(1F)
                        .background(
                            color = MaterialTheme.colors.SurfaceColor,
                            MaterialTheme.shapes.medium
                        )
                        .clip(MaterialTheme.shapes.medium),
                        hint = "Birthday"
                        , input = searchQuery
                        , onInputChange = onSearchQueryChange)

                    AdvancedTextField(modifier = Modifier
                        .padding(all = 8.dp)
                        .height(55.dp)
                        .weight(1F)
                        .background(
                            color = MaterialTheme.colors.SurfaceColor,
                            MaterialTheme.shapes.medium
                        )
                        .clip(MaterialTheme.shapes.medium),
                        hint = "address"
                        , input = searchQuery
                        , onInputChange = onSearchQueryChange)
                }
            }

            item {
                AdvancedTextField(modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(color = MaterialTheme.colors.SurfaceColor, MaterialTheme.shapes.medium)
                    .clip(MaterialTheme.shapes.medium),
                    hint = "Phone"
                    , input = searchQuery
                    , onInputChange = onSearchQueryChange)
            }

            item {
                AdvancedTextField(modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(color = MaterialTheme.colors.SurfaceColor, MaterialTheme.shapes.medium)
                    .clip(MaterialTheme.shapes.medium),
                    hint = "Email"
                    , input = searchQuery
                    , onInputChange = onSearchQueryChange)
            }

            item {
                AdvancedTextField(modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(color = MaterialTheme.colors.SurfaceColor, MaterialTheme.shapes.medium)
                    .clip(MaterialTheme.shapes.medium),
                    hint = "Password"
                    , input = searchQuery
                    , onInputChange = onSearchQueryChange)
            }

            item {
                AdvancedTextField(modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(color = MaterialTheme.colors.SurfaceColor, MaterialTheme.shapes.medium)
                    .clip(MaterialTheme.shapes.medium),
                    hint = "Confirm password"
                    , input = searchQuery
                    , onInputChange = onSearchQueryChange)
            }

            item {
                EmButton(onClick = {
                    val intent = Intent(activity, MainActivity::class.java)
                    activity?.startActivity(intent)
                    activity?.finish() }
                    , modifier = Modifier
                        .padding(all = 8.dp)
                        .height(55.dp)
                        .wrapContentWidth()
                    , icon = R.drawable.ic_empty_wallet
                    , text = "Register")
            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .weight(1F))

        Text(text = "Already have an account?"
            , color = MaterialTheme.colors.primary
            , textDecoration = TextDecoration.Underline
            , fontSize = 18.sp
            , fontWeight = FontWeight.SemiBold
            , modifier = Modifier
                .padding(8.dp)
                .clip(MaterialTheme.shapes.small)
                .clickable { navController.popBackStack() }
                .padding(8.dp))
    }

}