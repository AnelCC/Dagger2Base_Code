package com.anelcc.daggertohilt.di

import android.content.Context
import com.anelcc.daggertohilt.MainActivity
import com.anelcc.daggertohilt.registration.RegistrationActivity
import dagger.BindsInstance
import dagger.Component
/*
A @Component interface gives the information Dagger needs to generate the graph at compile-time.
The parameter of the interface methods define what classes request injection.
In Dagger2 injected class called components. These components assign references in our activity,
services, and fragments to have access to the singleton which we are already defined.
*/
interface AppComponent {

    // Classes that can be injected by this Component
    // With the inject(activity: RegistrationActivity)method in the @Component interface,
    // we're telling Dagger that RegistrationActivity requests injection and that it has to provide
    // the dependencies which are annotated with @Inject to RegistrationViewModel.
    fun inject(activity: RegistrationActivity)
}