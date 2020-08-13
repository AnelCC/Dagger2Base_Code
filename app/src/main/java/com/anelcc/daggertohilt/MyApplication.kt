package com.anelcc.daggertohilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//These annotations tell Hilt to trigger the code generation that Dagger will pick up and use in its annotation processor.
@HiltAndroidApp
open class MyApplication : Application()