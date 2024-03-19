package com.cappella.uicomponent

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cappella.uicomponent.theme.AppFont
import com.cappella.uicomponent.theme.appTextColor

@Composable
fun RegistrationTitle(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    text: String
) {
    Text(
        text = text,
        fontFamily = AppFont,
        fontWeight = FontWeight.Medium,
        fontSize = 40.sp,
        color = color,
        modifier = modifier,
        lineHeight = 50.sp
    )
}

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    color: Color = appTextColor,
    text: String,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 16.sp,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        fontFamily = AppFont,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color,
        modifier = modifier,
        textAlign = textAlign
    )
}

@Composable
fun AppInputField(
    modifier: Modifier = Modifier,
    text: String,
    supportingText: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    label: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    trailingIcon: @Composable (() -> Unit)? = null,
    textStyle: TextStyle = LocalTextStyle.current,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: ((String) -> Unit)? = null,
) {
    OutlinedTextField(
        value = text,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White
        ),
        label = label,
        shape = RoundedCornerShape(10.dp),
        supportingText = supportingText,
        leadingIcon = leadingIcon,
        placeholder = placeholder,
        modifier = modifier,
        onValueChange = {
            onValueChange?.invoke(it)
        },
        keyboardOptions = keyboardOptions,
        trailingIcon = trailingIcon,
        textStyle = textStyle,
        visualTransformation = visualTransformation
    )
}