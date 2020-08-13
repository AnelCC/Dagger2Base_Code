package com.anelcc.daggertohilt.storage

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
//In this case, SharedPreferencesStorage has Context as a dependency.
// In order to tell Hilt to inject the context, open SharedPreferencesStorage.kt.
// SharedPreferences requires application's Context, so add @ApplicationContext
// annotation to the context parameter.
class SharedPreferencesStorage @Inject constructor(@ApplicationContext context: Context) : Storage {
    private val sharedPreferences = context.getSharedPreferences("Dagger", Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getString(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }
}
