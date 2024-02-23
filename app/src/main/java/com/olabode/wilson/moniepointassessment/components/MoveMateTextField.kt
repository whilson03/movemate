package com.olabode.wilson.moniepointassessment.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.olabode.wilson.moniepointassessment.R
import com.olabode.wilson.moniepointassessment.ui.theme.LightGrey100
import com.olabode.wilson.moniepointassessment.ui.theme.LightGrey200

@Composable
fun MoveMateInputField(
    modifier: Modifier = Modifier,
    hint: String,
    value: String,
    @DrawableRes vectorImageId: Int? = R.drawable.ic_home,
    onInputChanged: (String) -> Unit
) {

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = LightGrey100.copy(alpha = 0.5f),
            cursorColor = Color.Black,
            disabledLabelColor = LightGrey100,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            if (value.isEmpty()) {
                Text(hint, color = LightGrey200)
            }
        },
        onValueChange = {
            onInputChanged(it)
        },
        shape = RoundedCornerShape(8.dp),
        singleLine = true,
        leadingIcon = if (vectorImageId != null) {
            {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = vectorImageId),
                        contentDescription = null,
                        tint = Color.Gray
                    )

                    Spacer(
                        modifier = Modifier
                            .width(1.dp)
                            .height(25.dp)
                            .background(Color.LightGray)
                    )
                }
            }
        } else {
            null
        },
    )
}

@Preview
@Composable
fun PreviewMaterialTextField() {
    MoveMateInputField(vectorImageId = R.drawable.ic_home, value = "", hint = "Hello") {}
}


