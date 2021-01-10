package com.sample.fooddelivery.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.sample.fooddelivery.models.Food

class AppPreference(context: Context?) {
    private val sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    /**
     * Save shared preference for String value
     *
     * @param key Shared preference key
     * @param dt  String value
     */
    fun savePreferences(key: String?, dt: String?) {
        editor = sharedPreferences.edit()
        editor.putString(key, dt)
        editor.apply()
    }

    /**
     * Save shared preference for int value
     *
     * @param key Shared preference key
     * @param dt  int value
     */
    fun savePreferences(key: String?, dt: Int) {
        editor = sharedPreferences.edit()
        editor.putInt(key, dt)
        editor.apply()
    }

    /**
     * Save shared preference for boolean value
     *
     * @param key Shared preference key
     * @param dt  boolean value
     */
    fun savePreferences(key: String?, dt: Boolean) {
        editor = sharedPreferences.edit()
        editor.putBoolean(key, dt)
        editor.apply()
    }

    /**
     * Get shared preference for String value
     *
     * @param pref Shared preference key
     */
    fun getStringValue(pref: String?): String? {
        return sharedPreferences.getString(pref, "")
    }

    /**
     * Get shared preference for int value
     *
     * @param pref Shared preference key
     */
    fun getIntValue(pref: String?): Int {
        return sharedPreferences.getInt(pref, 0)
    }

    /**
     * Get shared preference for boolean value
     *
     * @param pref Shared preference key
     */
    fun getBoolean(pref: String?): Boolean {
        return sharedPreferences.getBoolean(pref, false)
    }

    companion object {
        private val TAG = AppPreference::class.java.simpleName
        private const val SHARED_PREFERENCES_NAME = "com.mavensports"
        private const val PREF_PARAM_IS_PROFILE_CREATED = "isProfileCreated"
        private const val PREF_PARAM_IS_POSTS_WAS_LOADED_AT_LEAST_ONCE =
            "isPostsWasLoadedAtLeastOnce"

        private fun getSharedPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(
                SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE
            )
        }

        fun isProfileCreated(context: Context): Boolean {
            return getSharedPreferences(context)
                .getBoolean(PREF_PARAM_IS_PROFILE_CREATED, false)
        }

        fun isPostWasLoadedAtLeastOnce(context: Context): Boolean {
            return getSharedPreferences(context).getBoolean(
                PREF_PARAM_IS_POSTS_WAS_LOADED_AT_LEAST_ONCE,
                false
            )
        }

        fun setProfileCreated(
            context: Context,
            isProfileCreated: Boolean?
        ) {
            getSharedPreferences(context).edit()
                .putBoolean(PREF_PARAM_IS_PROFILE_CREATED, isProfileCreated!!)
                .commit()
        }

        fun setPostWasLoadedAtLeastOnce(
            context: Context,
            isPostWasLoadedAtLeastOnce: Boolean?
        ) {
            getSharedPreferences(context).edit().putBoolean(
                PREF_PARAM_IS_POSTS_WAS_LOADED_AT_LEAST_ONCE,
                isPostWasLoadedAtLeastOnce!!
            ).commit()
        }

        /**
         * Delete Shared Preference with all it's value
         */
        fun clearPreferences(context: Context) {
            val editor =
                getSharedPreferences(context).edit()
            editor.clear()
            editor.apply()
        }
    }

    /**
     * [AppPreference] Constructor
     *
     * @param context [Context] of caller
     */
    init {
        sharedPreferences = PreferenceManager
            .getDefaultSharedPreferences(context)
    }
}