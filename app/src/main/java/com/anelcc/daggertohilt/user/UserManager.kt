package com.anelcc.daggertohilt.user

import com.anelcc.daggertohilt.storage.Storage
import javax.inject.Inject

/*
Dagger doesn't know how to create types of UserManager yet. Added the @Inject annotation to UserManager 's constructor.

UserManager.kt
Now, Dagger knows how to provide instances of RegistrationViewModel and UserManager.
*/

private const val REGISTERED_USER = "registered_user"
private const val PASSWORD_SUFFIX = "password"

class UserManager @Inject constructor(private val storage: Storage) {
    /**
     *  UserDataRepository is specific to a logged in user. This determines if the user
     *  is logged in or not, when the user logs in, a new instance will be created.
     *  When the user logs out, this will be null.
     */
    var userDataRepository: UserDataRepository? = null

    val username: String
        get() = storage.getString(REGISTERED_USER)

    fun isUserLoggedIn() = userDataRepository != null

    fun isUserRegistered() = storage.getString(REGISTERED_USER).isNotEmpty()

    fun registerUser(username: String, password: String) {
        storage.setString(REGISTERED_USER, username)
        storage.setString("$username$PASSWORD_SUFFIX", password)
        userJustLoggedIn()
    }

    fun loginUser(username: String, password: String): Boolean {
        val registeredUser = this.username
        if (registeredUser != username) return false

        val registeredPassword = storage.getString("$username$PASSWORD_SUFFIX")
        if (registeredPassword != password) return false

        userJustLoggedIn()
        return true
    }

    fun logout() {
        userDataRepository = null
    }

    private fun userJustLoggedIn() {
        userDataRepository = UserDataRepository(this)
    }

    fun unregister() {
        val username = storage.getString(REGISTERED_USER)
        storage.setString(REGISTERED_USER, "")
        storage.setString("$username$PASSWORD_SUFFIX", "")
        logout()
    }
}