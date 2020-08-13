package com.anelcc.daggertohilt.di

import com.anelcc.daggertohilt.user.UserComponent
import dagger.Module

import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
// This module tells a Component which are its subcomponents
@Module(
    subcomponents = [
        UserComponent::class
    ]
)
class AppSubcomponents