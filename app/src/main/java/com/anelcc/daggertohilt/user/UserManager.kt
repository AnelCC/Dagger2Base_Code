package com.anelcc.daggertohilt.user

import com.anelcc.daggertohilt.storage.Storage
import javax.inject.Inject

/*
Dagger doesn't know how to create types of UserManager yet. Added the @Inject annotation to UserManager 's constructor.

UserManager.kt
Now, Dagger knows how to provide instances of RegistrationViewModel and UserManager.
*/
class UserManager @Inject constructor(private val storage: Storage) {

}