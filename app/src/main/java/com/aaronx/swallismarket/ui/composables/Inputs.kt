package com.aaronx.swallismarket.ui.composables

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.aaronx.swallismarket.ui.theme.IconColor

@Composable
fun AdvancedTextField(modifier: Modifier = Modifier
                      , hint: String
                      ,input: String
                      , onInputChange: (String) -> Unit = {}){

    TextField(value = input
        , onValueChange = { onInputChange(it) }
        , modifier = modifier
        , placeholder = { Text(hint) }
        ,shape = MaterialTheme.shapes.medium
        , singleLine = true
        , maxLines = 1
        , colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedLabelColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
            , textColor = MaterialTheme.colors.IconColor
            , placeholderColor = Color(0x9A909090)
        ))

}