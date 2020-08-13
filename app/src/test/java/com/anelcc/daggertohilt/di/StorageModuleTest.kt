package com.anelcc.daggertohilt.di

import com.anelcc.daggertohilt.storage.SharedPreferencesStorageTest
import com.anelcc.daggertohilt.storage.Storage
import dagger.Binds
import dagger.Module
import org.junit.Test

import org.junit.Assert.*

// Overrides StorageModule in android tests
@Module
abstract class StorageModuleTest {


    // Makes Dagger provide FakeStorage when a Storage type is requested
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorageTest): Storage
}
