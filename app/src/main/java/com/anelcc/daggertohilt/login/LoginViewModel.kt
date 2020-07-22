package com.anelcc.daggertohilt.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anelcc.daggertohilt.user.UserManager

class LoginViewModel (private val userManager: UserManager) {

    private val _loginState = MutableLiveData<LoginViewState>()
    val loginState: LiveData<LoginViewState>
        get() = _loginState

    fun login(username: String, password: String) {
        if (userManager.loginUser(username, password)) {
            _loginState.value = LoginSuccess
        } else {
            _loginState.value = LoginError
        }
    }

    fun getUsername(): String = userManager.username
}
