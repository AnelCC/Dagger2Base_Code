package com.anelcc.daggertohilt.di

import com.anelcc.daggertohilt.login.LoginComponent
import com.anelcc.daggertohilt.registration.RegistrationComponent
import com.anelcc.daggertohilt.user.UserComponent
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
// This module tells a Component which are its subcomponents
// Install this module in Hilt-generated ApplicationComponent
//In this case, as you're migrating the application level component,
// you want the bindings to be generated in ApplicationComponent.
@InstallIn(ApplicationComponent::class)
// This module tells a Component which are its subcomponents
// This is all you need to migrate LoginActivity to use Hilt.
@Module(
    subcomponents = [
        RegistrationComponent::class,
        LoginComponent::class,
        UserComponent::class
    ]
)
class AppSubcomponents