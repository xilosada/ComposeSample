package com.facebook.samples.kotlinsampleapp;

import com.facebook.login.widget.LoginButton
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.runtime.Composable

@Composable
fun WrappedLoginButton() {
    AndroidView(
        factory = { context -> LoginButton(context) }
    )
}
