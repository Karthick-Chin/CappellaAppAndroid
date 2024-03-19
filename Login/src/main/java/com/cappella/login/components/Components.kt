package com.cappella.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cappella.core.Utils.isValidEmail
import com.cappella.login.R
import com.cappella.uicomponent.AppInputField
import com.cappella.uicomponent.AppText
import com.cappella.uicomponent.theme.typoSemiBold

@Composable
fun PasswordComponent(
    password: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    onPassword: (String) -> Unit
) {
    val context = LocalContext.current

    var isShowPassword by remember {
        mutableStateOf(false)
    }

    AppInputField(
        modifier = modifier
            .fillMaxWidth(),
        text = password,
        trailingIcon = {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_eye),
                contentDescription = "show password",
                modifier = Modifier.clickable {
                    isShowPassword = !isShowPassword
                }
            )
        },
        supportingText = {
            if (isError) {
                AppText(
                    text = context.getString(R.string.password_error),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.Red
                )
            }
        },
        textStyle = typoSemiBold,
        leadingIcon = {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_password),
                contentDescription = "password",
            )
        },
        placeholder = {
            AppText(
                text = context.getString(R.string.password),
            )
        },
        visualTransformation = if (isShowPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    ) {
        onPassword.invoke(it)
    }
}

@Composable
fun EmailComponent(
    email: String,
    isEmailError: Boolean = false,
    onEmail: (String) -> Unit
) {

    val context = LocalContext.current

    AppInputField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        text = email,
        textStyle = typoSemiBold,
        leadingIcon = {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_mail),
                contentDescription = "emailIcon"
            )
        },
        supportingText = {
            if (isEmailError) {
                AppText(
                    text = context.getString(R.string.email_error),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.Red
                )
            }
        },
        placeholder = {
            AppText(
                text = context.getString(R.string.email),
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        )
    ) {
        onEmail.invoke(it)
    }
}