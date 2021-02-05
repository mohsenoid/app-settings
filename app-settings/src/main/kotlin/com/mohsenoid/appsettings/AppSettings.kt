package com.mohsenoid.appsettings

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import java.util.*

object AppSettings {
    private val tag = AppSettings::class.java.simpleName

    // Current SharedPreferences Names
    private var advancedPreferencesName: String? = null
    private var advancedPreferencesMode: PreferencesMode? = null

    // Boolean Values
    private var booleanValues: HashMap<String, Boolean?> = HashMap()

    // Float Values
    private var floatValues: HashMap<String, Float?> = HashMap()

    // Long Values
    private var longValues: HashMap<String, Long?> = HashMap()

    // String Values
    private var stringValues: HashMap<String, String?> = HashMap()

    // Integer Values
    private var intValues: HashMap<String, Int?> = HashMap()

    /**
     * switch to default SharedPreferences
     */
    fun switchDefaultSharedPrefrences() {
        Log.i(tag, "Switch to default")

        switchSharedPreferences(null, null)
    }

    /**
     * switch to your own SharedPreferences and modify PreferencesMode
     *
     * @param name set your SharedPreferences name
     * @param mode set your SharedPreferences access Mode
     */
    fun switchSharedPreferences(name: String?, mode: PreferencesMode?) {
        Log.i(tag, "Switch to " + name!!)

        flushAllValues()
        advancedPreferencesName = name
        advancedPreferencesMode = mode
    }

    /**
     * get current SharedPreferences
     *
     * @return current SharedPreferences
     */
    private fun getCurrentSharedPreferences(context: Context): SharedPreferences =
            if (advancedPreferencesName == null) {
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext(context))
            } else {
                getApplicationContext(context).getSharedPreferences(advancedPreferencesName, advancedPreferencesMode!!.value)
            }

    private fun getApplicationContext(context: Context): Context =
            if (context is Activity || context is Service || context is ContextWrapper) {
                context.applicationContext
            } else {
                context
            }

    fun clearValue(context: Context, key: String) {
        Log.i(tag, "Clear $key")

        val editor = getCurrentSharedPreferences(context)
                .edit()
        editor.remove(key)
        editor.apply()

        intValues.remove(key)
        booleanValues.remove(key)
        floatValues.remove(key)
        stringValues.remove(key)
        longValues.remove(key)
    }

    /**
     * delete all SharedPreferences saved values
     */
    private fun flushAllValues() {
        Log.i(tag, "Flush All Values")

        intValues = HashMap()
        booleanValues = HashMap()
        floatValues = HashMap()
        stringValues = HashMap()
        longValues = HashMap()
    }

    // ---------------------- Boolean ----------------------

    /**
     * get Boolean value saved for this Key in PreferencesMode
     *
     * @param context      application context
     * @param key          key
     * @param defaultValue default value to return if there is no value saved for this key
     * @param forceUpdate  force value to be updated from file
     * @return saved value or default value if there is no value saved for this key
     */
    @JvmOverloads
    fun getBoolean(context: Context, key: String,
                   defaultValue: Boolean? = null, forceUpdate: Boolean = false): Boolean? {
        Log.i(tag, "Get " + (if (forceUpdate) "Force Update " else "") + key)

        if (!booleanValues.containsKey(key) || forceUpdate)
            booleanValues[key] =
                    if (getCurrentSharedPreferences(context).contains(key))
                        getCurrentSharedPreferences(context).getBoolean(key, defaultValue
                                ?: false)
                    else
                        defaultValue

        return booleanValues[key]
    }

    /**
     * set Boolean value for this Key in PreferencesMode
     *
     * @param context application context
     * @param key     key
     * @return commit result
     */
    fun setValue(context: Context, key: String, value: Boolean?): Boolean {
        Log.i(tag, "Set $key:$value")

        val editor = getCurrentSharedPreferences(context)
                .edit()

        if (null == value)
            editor.remove(key)
        else
            editor.putBoolean(key, value)

        val result = editor.commit()

        booleanValues[key] = value

        return result
    }

    // ---------------------- Float ----------------------

    /**
     * get Float value saved for this Key in PreferencesMode
     *
     * @param context      application context
     * @param key          key
     * @param defaultValue default value to return if there is no value saved for this key
     * @param forceUpdate  force value to be updated from file
     * @return saved value or default value if there is no value saved for this key
     */
    @JvmOverloads
    fun getFloat(context: Context, key: String, defaultValue: Float? = null, forceUpdate: Boolean = false): Float? {
        Log.i(tag, "Get " + (if (forceUpdate) " Force Update" else "") + key)

        if (!floatValues.containsKey(key) || forceUpdate)
            floatValues[key] =
                    if (getCurrentSharedPreferences(context).contains(key))
                        getCurrentSharedPreferences(context).getFloat(key, defaultValue
                                ?: 0f)
                    else
                        defaultValue


        return floatValues[key]
    }

    /**
     * set Float value for this Key in PreferencesMode
     *
     * @param context application context
     * @param key     key
     * @return commit result
     */
    fun setValue(context: Context, key: String, value: Float?): Boolean {
        Log.i(tag, "Set $key:$value")

        val editor = getCurrentSharedPreferences(context)
                .edit()

        if (null == value)
            editor.remove(key)
        else
            editor.putFloat(key, value)

        val result = editor.commit()

        floatValues[key] = value

        return result
    }

    // ---------------------- Long ----------------------

    /**
     * get Long value saved for this Key in PreferencesMode
     *
     * @param context      application context
     * @param key          key
     * @param defaultValue default value to return if there is no value saved for this key
     * @param forceUpdate  force value to be updated from file
     * @return saved value or default value if there is no value saved for this key
     */
    @JvmOverloads
    fun getLong(context: Context, key: String, defaultValue: Long? = null, forceUpdate: Boolean = false): Long? {
        Log.i(tag, "Get " + (if (forceUpdate) "Force Update " else "") + key)

        if (!longValues.containsKey(key) || forceUpdate)
            longValues[key] =
                    if (getCurrentSharedPreferences(context).contains(key))
                        getCurrentSharedPreferences(context).getLong(key, defaultValue
                                ?: 0)
                    else
                        defaultValue

        return longValues[key]
    }

    /**
     * set Long value for this Key in PreferencesMode
     *
     * @param context application context
     * @param key     key
     * @return commit result
     */
    fun setValue(context: Context, key: String, value: Long?): Boolean {
        Log.i(tag, "Set $key:$value")

        val editor = getCurrentSharedPreferences(context)
                .edit()
        editor.putLong(key, value!!)
        val result = editor.commit()

        longValues[key] = value

        return result
    }

    // ---------------------- String ----------------------

    /**
     * get String value saved for this Key in PreferencesMode
     *
     * @param context      application context
     * @param key          key
     * @param defaultValue default value to return if there is no value saved for this key
     * @param forceUpdate  force value to be updated from file
     * @return saved value or default value if there is no value saved for this key
     */
    @JvmOverloads
    fun getString(context: Context, key: String,
                  defaultValue: String? = null, forceUpdate: Boolean = false): String? {
        Log.i(tag, "Get " + (if (forceUpdate) "Force Update " else "") + key)

        if (!stringValues.containsKey(key) || forceUpdate)
            stringValues[key] =
                    if (getCurrentSharedPreferences(context).contains(key))
                        getCurrentSharedPreferences(context).getString(key, defaultValue
                                ?: "")
                    else
                        defaultValue

        return stringValues[key]
    }

    /**
     * set String value for this Key in PreferencesMode
     *
     * @param context application context
     * @param key     key
     * @return commit result
     */
    fun setValue(context: Context, key: String, value: String): Boolean {
        Log.i(tag, "Set $key:$value")

        val editor = getCurrentSharedPreferences(context)
                .edit()
        editor.putString(key, value)
        val result = editor.commit()

        stringValues[key] = value

        return result
    }

    // ---------------------- Integer ----------------------

    /**
     * get Integer value saved for this Key in PreferencesMode
     *
     * @param context      application context
     * @param key          key
     * @param defaultValue default value to return if there is no value saved for this key
     * @param forceUpdate  force value to be updated from file
     * @return saved value or default value if there is no value saved for this key
     */
    @JvmOverloads
    fun getInt(context: Context, key: String,
               defaultValue: Int? = null, forceUpdate: Boolean = false): Int? {
        Log.i(tag, "Get " + (if (forceUpdate) "Force Update " else "") + key)

        if (!intValues.containsKey(key) || forceUpdate)
            intValues[key] =
                    if (getCurrentSharedPreferences(context).contains(key))
                        getCurrentSharedPreferences(context).getInt(key, defaultValue ?: 0)
                    else
                        defaultValue

        return intValues[key]
    }

    /**
     * set Integer value for this Key in PreferencesMode
     *
     * @param context application context
     * @param key     key
     * @return commit result
     */
    fun setValue(context: Context, key: String, value: Int?): Boolean {
        Log.i(tag, "Set $key:$value")

        val editor = getCurrentSharedPreferences(context)
                .edit()

        if (null == value)
            editor.remove(key)
        else
            editor.putInt(key, value)

        val result = editor.commit()

        intValues[key] = value

        return result
    }

    /**
     * enum PreferencesMode values
     */
    enum class PreferencesMode(value: Int) {
        PRIVATE(Context.MODE_PRIVATE),
        APPEND(Context.MODE_APPEND),
        ENABLE_WRITE_AHEAD_LOGGING(Context.MODE_ENABLE_WRITE_AHEAD_LOGGING),
        MULTI_PROCESS(Context.MODE_MULTI_PROCESS);

        var value: Int = 0
            internal set

        init {
            this.value = value
        }
    }
}
