package com.anelcc.daggertohilt.user

import com.anelcc.daggertohilt.storage.Storage
import javax.inject.Inject

/*
Dagger doesn't know how to create types of UserManager yet. Follow the same process,
and add the @Inject annotation to UserManager 's constructor.

Open the UserManager.kt file and replace the class definition with this one:

UserManager.kt
*/
class UserManager @Inject constructor(private val storage: Storage) {

}