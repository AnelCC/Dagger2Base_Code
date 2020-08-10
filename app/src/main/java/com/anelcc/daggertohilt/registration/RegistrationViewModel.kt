package com.anelcc.daggertohilt.registration

import com.anelcc.daggertohilt.di.ActivityScope
import com.anelcc.daggertohilt.user.UserManager
import javax.inject.Inject

/*
@Inject annotation
 Dagger needs to know how to create instances for the classes
 In Kotlin, to apply an annotation to the constructor,
 you need to specifically add the keyword constructor and
 introduce the annotation just before it as shown in the code snippet above.

With the @Inject annotation, Dagger knows:
1.- How to create instances of type RegistrationViewModel.
2.- RegistrationViewModel has UserManager as dependency
since the constructor takes an instance of UserManager as an argument.
 */
@ActivityScope
class RegistrationViewModel @Inject constructor(val userManager: UserManager) {
    private var username: String? = null
    private var password: String? = null
    private var acceptedTCs: Boolean? = null

    fun updateUserData(username: String, password: String) {
        this.username = username
        this.password = password
    }

    fun acceptTCs() {
        acceptedTCs = true
    }

    fun registerUser() {
        assert(username != null)
        assert(password != null)
        assert(acceptedTCs == true)

        userManager.registerUser(username!!, password!!)
    }
}