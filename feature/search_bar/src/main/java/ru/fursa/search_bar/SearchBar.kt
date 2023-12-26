package ru.fursa.search_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    placeholderText: String = "",
    onTextChanged: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: () -> Unit,
) {
    val text = remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp),
        value = text.value,
        singleLine = true,
        textStyle = TextStyle(fontSize = 12.sp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(size = 8.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "",
                modifier = Modifier.clickable {
                    onSearchClicked()
                }
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "",
                modifier = Modifier.clickable {
                    onCloseClicked()
                    text.value = ""
                }
            )
        },
        onValueChange = { searchText ->
            text.value = searchText
            onTextChanged(searchText)
        }, placeholder = {
            Text(
                text = placeholderText,
                modifier = Modifier.alpha(0.4f),
                color = Color.White
            )
        }
    )
}
