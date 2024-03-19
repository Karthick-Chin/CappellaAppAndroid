package com.cappella.uicomponent.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cappella.uicomponent.R

val AppFont = FontFamily(
    Font(R.font.poppinsmedium, FontWeight.Medium),
    Font(R.font.poppinsregular, FontWeight.Normal),
    Font(R.font.poppinsthin, FontWeight.Thin),
    Font(R.font.poppinssemibold, FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = AppFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val typoSemiBold = TextStyle(
    fontFamily = AppFont,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
)