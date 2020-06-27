package com.anelcc.daggertohilt.di

import com.anelcc.daggertohilt.storage.SharedPreferencesStorage
import com.anelcc.daggertohilt.storage.Storage
import dagger.Binds
import dagger.Module
/*
Modules are a way to encapsulate how to provide objects in a semantic way. As you can see,
we called the class StorageModule to group the logic of providing objects related to storage.
If our application expands, we could also include how to provide different implementations of
SharedPreferences, for example.
*/
// Tells Dagger this is a Dagger module
// Because of @Binds, StorageModule needs to be an abstract class
//Use @Binds to tell Dagger which implementation it needs to use when providing an interface.
@Module
abstract class StorageModule {
    // Makes Dagger provide SharedPreferencesStorage when a Storage type is requested.
    // StorageModule is abstract now because the provideStorage is abstract.
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}