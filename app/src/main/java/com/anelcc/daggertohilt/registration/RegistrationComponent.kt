package com.anelcc.daggertohilt.registration

import com.anelcc.daggertohilt.di.ActivityScope
import com.anelcc.daggertohilt.registration.enterdetail.EnterDetailsFragment
import com.anelcc.daggertohilt.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent


// Scope annotation that the RegistrationComponent uses
// Classes annotated with @ActivityScope will have a unique instance in this Component
@ActivityScope
// Definition of a Dagger subcomponent
@Subcomponent
interface RegistrationComponent {

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)
}

