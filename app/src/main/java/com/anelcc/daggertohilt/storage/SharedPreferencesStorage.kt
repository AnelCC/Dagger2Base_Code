package com.anelcc.daggertohilt.storage

import android.content.Context
import javax.inject.Inject

// @Inject tells Dagger how to provide instances of this type
// Storage object is requested it should create an instance of SharedPreferencesStorage
// We do by annotating the constructor of SharedPreferencesStorage with @Inject.
class SharedPreferencesStorage @Inject constructor(context: Context) : Storage {
    //private val sharedPreferences = context.getSharedPreferences("Dagger", Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) {
        TODO("not implemented") //Implemented an instance of SharedPreferencesStorage
    }

    override fun getString(key: String): String {
        TODO("not implemented") //Implemented an instance of SharedPreferencesStorage
    }
}