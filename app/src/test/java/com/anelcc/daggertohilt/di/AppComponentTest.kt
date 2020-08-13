package com.anelcc.daggertohilt.di

import dagger.Binds
import dagger.Component
import dagger.Module
import org.junit.Test

import org.junit.Assert.*
import javax.inject.Singleton

// Replacement for AppComponent in android tests
@Singleton
// Includes TestStorageModule that overrides objects provided in StorageModule
@Component(modules = [StorageModuleTest::class, AppSubcomponents::class])
//interface AppComponentTest : AppComponent
