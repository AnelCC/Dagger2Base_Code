package com.anelcc.daggertohilt.di

import com.anelcc.daggertohilt.storage.SharedPreferencesStorage
import com.anelcc.daggertohilt.storage.Storage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

// Tells Dagger this is a Dagger module
// Install this module in Hilt-generated ApplicationComponent
@InstallIn(ApplicationComponent::class)
// Tells Dagger this is a Dagger module
@Module
abstract class StorageModule {

    // Makes Dagger provide SharedPreferencesStorage when a Storage type is requested
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}