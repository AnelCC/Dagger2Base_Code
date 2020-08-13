package com.anelcc.daggertohilt.di

import com.anelcc.daggertohilt.login.LoginComponent
import com.anelcc.daggertohilt.registration.RegistrationComponent
import com.anelcc.daggertohilt.user.UserComponent
import dagger.Module

// This module tells a Component which are its subcomponents
@Module(
    subcomponents = [
        RegistrationComponent::class,
        LoginComponent::class,
        UserComponent::class
    ]
)
class AppSubcomponents