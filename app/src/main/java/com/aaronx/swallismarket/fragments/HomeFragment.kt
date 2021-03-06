package com.aaronx.swallismarket.fragments

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aaronx.swallismarket.data.Product
import com.aaronx.swallismarket.firebase.FirebaseController
import com.aaronx.swallismarket.ui.composables.AdvancedTextField
import com.aaronx.swallismarket.ui.composables.ProductCard
import com.aaronx.swallismarket.ui.theme.SurfaceColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeFragment(navController: NavController){
    val context = LocalContext.current
    FirebaseController.getListProducts(context)

    val productList = FirebaseController.getProducts().observeAsState()

    var searchQuery by rememberSaveable { mutableStateOf("") }
    val onSearchQueryChange: (String)->Unit = {
        searchQuery = it
    }

    Column(modifier = Modifier.fillMaxSize()) {
        AdvancedTextField(modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
            .height(55.dp)
            .background(color = MaterialTheme.colors.SurfaceColor, MaterialTheme.shapes.medium)
            .clip(MaterialTheme.shapes.medium),
            hint = "Search for a product"
            , input = searchQuery
            , onInputChange = onSearchQueryChange)

        LazyVerticalGrid(cells = GridCells.Fixed(2)
            , modifier = Modifier.padding(horizontal = 4.dp)){

            if(productList.value != null){
                items(productList.value!!) {
                    ProductCard(
                        product = it,
                        onClick = { navController.navigate("Product/${it.idProduct}") })
                }
            }

            item {
                Spacer(modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth())
            }
            item {
                Spacer(modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth())
            }
        }
    }
}