package com.anelcc.daggertohilt.di

import android.content.Context
import com.anelcc.daggertohilt.MainActivity
import com.anelcc.daggertohilt.login.LoginComponent
import com.anelcc.daggertohilt.registration.RegistrationActivity
import com.anelcc.daggertohilt.registration.RegistrationComponent
import com.anelcc.daggertohilt.registration.enterdetail.EnterDetailsFragment
import com.anelcc.daggertohilt.registration.termsandconditions.TermsAndConditionsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/*
A @Component interface gives the information Dagger needs to generate the graph at compile-time.
The parameter of the interface methods define what classes request injection.
In Dagger2 injected class called components. These components assign references in our activity,
services, and fragments to have access to the singleton which we are already defined.
The application graph needs to know about StorageModule: because we are only accessing Module.class
via our @Component annotation we also need to add the another Module.class to the list of modules.
Eg. {Module1.class, Module2.class}
*/

// Scope annotation that the AppComponent uses
// Classes annotated with @Singleton will have a unique instance in this Component
@Singleton
// Definition of a Dagger component that adds info from the different modules to the graph
//In this way, AppComponent can access the information that StorageModule or AppSubcomponents contains.
@Component(modules = [StorageModule::class, AppSubcomponents::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    // @BindsInstance tells Dagger that it needs to add that instance in the graph and whenever Context is required, provide that instance.
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }


    // Types that can be retrieved from the graph
    fun registrationComponent(): RegistrationComponent.Factory
    fun loginComponent(): LoginComponent.Factory

    // Classes that can be injected by this Component
    // With the inject(activity: RegistrationActivity)method in the @Component interface,
    // we're telling Dagger that RegistrationActivity requests injection and that it has to provide
    // the dependencies which are annotated with @Inject to RegistrationViewModel.
    //fun inject(activity: RegistrationActivity)
    fun inject(activity: MainActivity)

   /* //Which fields do we want Dagger to provide?
    // In EnterDetailsFragment,
    // we want Dagger to populate both ViewModels.
    // We do that by annotating the fields with
    // @Inject and removing the private visibility modifier.
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)*/
}