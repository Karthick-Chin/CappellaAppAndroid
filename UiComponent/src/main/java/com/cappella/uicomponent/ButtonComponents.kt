package com.cappella.uicomponent

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cappella.uicomponent.theme.AppFont

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick.invoke()
        },
        modifier = modifier
            .height(50.dp)
    ) {
        Text(
            text = text,
            fontFamily = AppFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
    }
}