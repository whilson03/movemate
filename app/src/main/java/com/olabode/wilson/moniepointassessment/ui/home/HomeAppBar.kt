package com.olabode.wilson.moniepointassessment.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olabode.wilson.moniepointassessment.R
import com.olabode.wilson.moniepointassessment.ui.theme.LightGrey200
import com.olabode.wilson.moniepointassessment.ui.theme.Orange600
import com.olabode.wilson.moniepointassessment.ui.theme.Purple700
import com.olabode.wilson.moniepointassessment.ui.theme.White
import java.util.Locale


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeAppBar(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Purple700)
            .fillMaxWidth()
    ) {
        ListItem(
            modifier = modifier.fillMaxWidth(),
            icon = {
                CircularImage(res = R.drawable.id_avatar)
            },
            trailing = {
                CircularContainer(color = White, modifier = Modifier) {
                    Icon(
                        Icons.Rounded.Notifications,
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center),
                    )
                }
            },

            secondaryText = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Wertheimer, illinois",
                        style = MaterialTheme.typography.subtitle2.copy(color = Color.LightGray)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_expand),
                        contentDescription = null,
                        tint = Color.LightGray
                    )

                }
            },
            text = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_location_in_use),
                        contentDescription = null,
                        tint = Color.LightGray
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "Your location",
                        style = MaterialTheme.typography.subtitle2.copy(color = Color.LightGray)
                    )
                }
            }
        )
        val state = remember {
            mutableStateOf("")
        }

        SearchView(value = state.value, hint = "Enter Receipt Number") {
            state.value = it
        }
    }
}

@Composable
fun CircularContainer(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(RoundedCornerShape(500.dp))
            .background(color)
    ) {
        content()
    }
}

@Composable
fun CircularImage(
    res: Int
) {
    Image(
        painter = painterResource(id = res),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(5)),
        contentScale = ContentScale.FillWidth
    )
}


@Composable
fun SearchView(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        TextField(
            value = value,
            onValueChange = { value -> onValueChange(value) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(40.dp)),
            textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
            placeholder = {
                if (value.isEmpty()) {
                    Text(hint, color = LightGrey200)
                }
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                )
            },
            trailingIcon = {
                CircularContainer(color = Orange600, modifier = Modifier.padding(8.dp)) {
                    Icon(
                        painterResource(id = R.drawable.ic_scan),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center),
                    )
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(15.dp), // Rounded corners
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
                leadingIconColor = Purple700,
                trailingIconColor = Color.White,
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun ItemList(state: MutableState<TextFieldValue>) {
    val items = listOf("Drink water", "Walk") // Your list of items
    val searchedText = state.value.text
    val filteredItems = if (searchedText.isEmpty()) {
        items
    } else {
        items.filter {
            it.lowercase(Locale.getDefault()).contains(searchedText.lowercase(Locale.getDefault()))
        }
    }

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(filteredItems) { filteredItem ->
            ItemListItem(
                ItemText = filteredItem,
                onItemClick = { /* Click event code needs to be implemented */ }
            )
        }
    }
}

@Composable
fun ItemListItem(ItemText: String, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(ItemText) })
            .background(colorResource(id = R.color.purple_700))
            .height(57.dp)
            .fillMaxWidth()
            .padding(PaddingValues(8.dp, 16.dp))
    ) {
        Text(text = ItemText, fontSize = 18.sp, color = Color.White)
    }
}


@Preview
@Composable
fun PreviewAppBar() {
    HomeAppBar()
}