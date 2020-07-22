package com.anelcc.daggertohilt.registration

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

class RegistrationViewModel @Inject constructor(val userManager: UserManager) {

}