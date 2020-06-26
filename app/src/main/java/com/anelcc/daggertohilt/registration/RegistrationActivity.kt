package com.anelcc.daggertohilt.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anelcc.daggertohilt.MyApplication
import com.anelcc.daggertohilt.R
import javax.inject.Inject
/*
When @Inject is annotated on a class constructor,
it's telling Dagger how to provide instances of that class.
When it's annotated on a class field,
it's telling Dagger that it needs to populate the field with an instance of that type.
*/
class RegistrationActivity : AppCompatActivity() {

    // We cannot use the @Inject annotation in the constructor of a View class.
    // Instead, we have to use field injection.
    // @Inject annotated fields will be provided by Dagger
    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    // For Activities specifically, any initialization code needs to go to the onCreate method.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Remove following line
        registrationViewModel = RegistrationViewModel((application as MyApplication).userManager)
    }
    /*
    How can we tell Dagger which objects need to be injected into RegistrationActivity?
    We need to create the Dagger graph (or application graph)
    and use it to inject objects into the Activity.
    */
}
