package com.anelcc.daggertohilt.di

import android.content.Context
import com.anelcc.daggertohilt.MainActivity
import com.anelcc.daggertohilt.registration.RegistrationActivity
import dagger.BindsInstance
import dagger.Component

interface AppComponent {
    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: RegistrationActivity)
    fun inject(activity: MainActivity)
}