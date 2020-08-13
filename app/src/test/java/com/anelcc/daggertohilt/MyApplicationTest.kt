package com.anelcc.daggertohilt

import com.anelcc.daggertohilt.di.AppComponent
import com.anelcc.daggertohilt.user.UserManager
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*


/**
 * MyTestApplication will override MyApplication in android tests
 */
class MyApplicationTest : MyApplication() {

    override fun initializeComponent(): AppComponent {
        // Creates a new TestAppComponent that injects fakes types
        return DaggerTestAppComponent.create()
    }
}