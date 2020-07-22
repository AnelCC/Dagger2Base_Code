package com.anelcc.daggertohilt.storage

import android.content.Context
import javax.inject.Inject

// @Inject tells Dagger how to provide instances of this type
class SharedPreferencesStorage @Inject constructor(context: Context) : Storage {
    private val sharedPreferences = context.getSharedPreferences("Dagger", Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) {
    }

    override fun getString(key: String): String {
        return ""
    }
}
