package com.cappella.login.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cappella.core.Utils
import com.cappella.core.network.AppResponseResource
import com.cappella.login.R
import com.cappella.login.components.EmailComponent
import com.cappella.login.components.PasswordComponent
import com.cappella.login.screen.LoginViewModel
import com.cappella.uicomponent.AppButton
import com.cappella.uicomponent.AppText
import com.cappella.uicomponent.RegistrationTitle

@Composable
fun ScreenLogin(
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    var email by remember {
        mutableStateOf("")
    }
    var isEmailError by remember {
        mutableStateOf(false)
    }

    var password by remember {
        mutableStateOf("")
    }
    var isPasswordError by remember {
        mutableStateOf(false)
    }

    val uiState by loginViewModel.loginState.collectAsState(AppResponseResource.Loading(false))

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            RegistrationTitle(text = context.getString(R.string.welcome_back))
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_fox),
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(fraction = 0.9f),
                    contentDescription = ""
                )
            }
            AppText(
                text = context.getString(R.string.login_message),
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 16.dp)
            )

            EmailComponent(
                email = email,
                isEmailError = isEmailError
            ) {
                email = it
            }

            PasswordComponent(
                password = password,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                password = it
            }

            AppText(
                text = context.getString(R.string.forgot_password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                textAlign = TextAlign.End,
                color = MaterialTheme.colorScheme.primary,
            )

            AppButton(
                text = context.getString(R.string.login),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
            ) {
                if (Utils.isValidEmail(email).not()) {
                    isEmailError = true
                    return@AppButton
                }
                isEmailError = false
                if (password.isEmpty()) {
                    isPasswordError = true
                    return@AppButton
                }
                isPasswordError = false

                loginViewModel.login(
                    email, password
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                AppText(
                    text = context.getString(R.string.sign_up_prefix),
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp
                )

                AppText(
                    text = context.getString(R.string.sign_up),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 4.dp),
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp
                )
            }
        }

        (uiState as? AppResponseResource.Loading)?.let {
            if (it.status)
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}