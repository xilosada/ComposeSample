package com.facebook.samples.kotlinsampleapp;

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.facebook.CallbackManager
import com.facebook.login.LoginManager

class MainActivity : ComponentActivity() {

    private val login = {
        LoginManager.getInstance().logIn(this, CallbackManager.Factory.create(), listOf("email"))
    }

    private val logout = {
        LoginManager.getInstance().logOut()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: LoginViewModel by viewModels()
        setContent {
            val profileViewState by viewModel.profileViewState.observeAsState(ProfileViewState())
            SampleView(profileViewState)
        }
    }

    @Composable
    fun SampleView(profileViewState: ProfileViewState) {
        Column {
            CustomLoginButton(profileViewState.profile, login = login, logout = logout)
            WrappedLoginButton()
            Text(text = profileViewState.profile?.name ?: "logged out")
        }
    }
}
