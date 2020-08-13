package com.anelcc.daggertohilt.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anelcc.daggertohilt.main.MainActivity
import com.anelcc.daggertohilt.MyApplication
import com.anelcc.daggertohilt.R
import com.anelcc.daggertohilt.registration.enterdetail.EnterDetailsFragment
import com.anelcc.daggertohilt.registration.termsandconditions.TermsAndConditionsFragment
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject

class RegistrationActivity : AppCompatActivity() {
    @InstallIn(ApplicationComponent::class)
    //If you want a content provider to use Hilt to get some dependencies,
    // you need to define an interface that is annotated with @EntryPoint
    // for each binding type that you want and include qualifiers.
    // By using entry points you can keep the app working while migrating every Dagger component.
    @EntryPoint
    interface RegistrationEntryPoint {
        fun registrationComponent(): RegistrationComponent.Factory
    }

    // Stores an instance of RegistrationComponent so that its Fragments can access it
    lateinit var registrationComponent: RegistrationComponent

    // We cannot use the @Inject annotation in the constructor of a View class.
    // Instead, we have to use field injection.
    // @Inject annotated fields will be provided by Dagger
    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_holder, EnterDetailsFragment())
            .commit()

        // Creates an instance of Registration component by grabbing the factory from the app graph
        val entryPoint = EntryPointAccessors.fromApplication(applicationContext, RegistrationEntryPoint::class.java)
        registrationComponent = entryPoint.registrationComponent().create()
    }

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
