package com.anelcc.daggertohilt.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anelcc.daggertohilt.main.MainActivity
import com.anelcc.daggertohilt.MyApplication
import com.anelcc.daggertohilt.R
import com.anelcc.daggertohilt.registration.enterdetail.EnterDetailsFragment
import com.anelcc.daggertohilt.registration.termsandconditions.TermsAndConditionsFragment
import javax.inject.Inject
/*
When @Inject is annotated on a class constructor,
it's telling Dagger how to provide instances of that class.
When it's annotated on a class field,
it's telling Dagger that it needs to populate the field with an instance of that type.
*/
class RegistrationActivity : AppCompatActivity() {

    // Stores an instance of RegistrationComponent so that its Fragments can access it
    lateinit var registrationComponent: RegistrationComponent

    // We cannot use the @Inject annotation in the constructor of a View class.
    // Instead, we have to use field injection.
    // @Inject annotated fields will be provided by Dagger
    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    // For Activities specifically, any initialization code needs to go to the onCreate method.
    override fun onCreate(savedInstanceState: Bundle?) {
        // Ask Dagger to inject our dependencies
        //(application as MyApplication).appComponent.inject(this)
        //When using Activities, inject Dagger in the Activity's onCreate method before calling
        // super.onCreate to avoid issues with fragment restoration.

        // Creates an instance of Registration component by grabbing the factory from the app graph
        registrationComponent = (application as MyApplication).appComponent
            .registrationComponent().create()

        // Injects this activity to the just created Registration component
        registrationComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Remove following line
        //registrationViewModel = RegistrationViewModel((application as MyApplication).userManager)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_holder, EnterDetailsFragment())
            .commit()
    }
    /*
    How can we tell Dagger which objects need to be injected into RegistrationActivity?
    We need to create the Dagger graph (or application graph)
    and use it to inject objects into the Activity.
    */

    /**
     * Callback from EnterDetailsFragment when username and password has been entered
     */
    fun onDetailsEntered() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder, TermsAndConditionsFragment())
            .addToBackStack(TermsAndConditionsFragment::class.java.simpleName)
            .commit()
    }

    /**
     * Callback from T&CsFragment when TCs have been accepted
     */
    fun onTermsAndConditionsAccepted() {
        registrationViewModel.registerUser()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
