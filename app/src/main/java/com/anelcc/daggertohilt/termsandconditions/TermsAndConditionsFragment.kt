package com.anelcc.daggertohilt.termsandconditions

import androidx.fragment.app.Fragment
import com.anelcc.daggertohilt.registration.RegistrationViewModel
import com.anelcc.daggertohilt.registration.enterdetail.EnterDetailsViewModel
import javax.inject.Inject

class TermsAndConditionsFragment : Fragment() {

    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    @Inject
    lateinit var enterDetailsViewModel: EnterDetailsViewModel

}
