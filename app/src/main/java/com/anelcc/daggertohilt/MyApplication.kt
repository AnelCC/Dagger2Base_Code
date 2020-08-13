package com.anelcc.daggertohilt

import android.app.Application
import com.anelcc.daggertohilt.di.AppComponent
import com.anelcc.daggertohilt.di.DaggerAppComponent
import dagger.hilt.android.HiltAndroidApp

//These annotations tell Hilt to trigger the code generation that Dagger will pick up and use in its annotation processor.
@HiltAndroidApp
open class MyApplication : Application() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.factory().create(applicationContext)
    }
}
