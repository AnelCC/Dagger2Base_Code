package com.anelcc.daggertohilt

import android.app.Application
import com.anelcc.daggertohilt.di.AppComponent
import com.anelcc.daggertohilt.di.DaggerAppComponent
import com.anelcc.daggertohilt.storage.SharedPreferencesStorage
import com.anelcc.daggertohilt.user.UserManager

open class MyApplication : Application() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        // Views require objects from the graph
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerAppComponent.factory().create(applicationContext)
    }

    open val userManager by lazy {
        UserManager(SharedPreferencesStorage(this))
    }
}
