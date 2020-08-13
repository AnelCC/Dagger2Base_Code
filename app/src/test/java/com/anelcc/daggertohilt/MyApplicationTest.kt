package com.anelcc.daggertohilt


/**
 * MyTestApplication will override MyApplication in android tests
 */
class MyApplicationTest : MyApplication() {

    /*override fun initializeComponent(): AppComponent {
        // Creates a new TestAppComponent that injects fakes types
        return DaggerTestAppComponent.create()
    }*/
}