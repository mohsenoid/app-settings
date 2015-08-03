package com.mirhoseini.appsettings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.HashMap;

public class AppSettings {
    private final static String tag = AppSettings.class.getSimpleName();
    // Current SharedPreferences Names
    static String advancedPreferencesName;
    static PreferencesMode advancedPreferencesMode;
    // Boolean Values
    static HashMap<String, Boolean> booleanValues;
    // Float Values
    static HashMap<String, Float> floatValues;
    // Long Values
    static HashMap<String, Long> longValues;
    // String Values
    static HashMap<String, String> stringValues;
    // Integer Values
    static HashMap<String, Integer> intValues;

    public static void switchDefaultSharePrefrences() {
        Log.i(tag, "Switch to default");

        switchSharePreferences(null, null);
    }
    
    public static void switchSharePreferences(String name, PreferencesMode mode) {
        Log.i(tag, "Switch to " + name);

        flushAllValues();
        advancedPreferencesName = name;
        advancedPreferencesMode = mode;
    }

    private static void flushAllValues() {
        Log.i(tag, "Flush All Values");

        intValues = new HashMap<String, Integer>();
        booleanValues = new HashMap<String, Boolean>();
        floatValues = new HashMap<String, Float>();
        stringValues = new HashMap<String, String>();
        longValues = new HashMap<String, Long>();
    }

    private static SharedPreferences getCurrentSharedPreferences(Context context) {
        if (advancedPreferencesName == null) {
            return PreferenceManager.getDefaultSharedPreferences(context);
        } else {
            return context.getSharedPreferences(advancedPreferencesName, advancedPreferencesMode.getValue());
        }
    }

    public static Boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, null);
    }

    public static Boolean getBoolean(Context context, String key,
                                     Boolean defaultValue) {
        return getBoolean(context, key, defaultValue, false);
    }

    public static Boolean getBoolean(Context context, String key,
                                     Boolean defaultValue, boolean forceUpdate) {
        Log.i(tag, "Get " + (forceUpdate ? "Force Update " : "") + key);

        if (booleanValues == null)
            booleanValues = new HashMap<String, Boolean>();

        if (!booleanValues.containsKey(key) || forceUpdate)
            booleanValues.put(key,
                    getCurrentSharedPreferences(context)
                            .getBoolean(key, defaultValue));

        return booleanValues.get(key);
    }

    public static void setValue(Context context, String key, Boolean value) {
        Log.i(tag, "Set " + key + ":" + value);

        if (booleanValues == null)
            booleanValues = new HashMap<String, Boolean>();

        Editor editor = getCurrentSharedPreferences(context)
                .edit();
        editor.putBoolean(key, value);
        editor.commit();

        booleanValues.put(key, value);
    }

    public static Float getFloat(Context context, String key) {
        return getFloat(context, key, null);
    }

    public static Float getFloat(Context context, String key, Float defaultValue) {
        return getFloat(context, key, defaultValue, false);
    }

    public static Float getFloat(Context context, String key, Float defaultValue, boolean forceUpdate) {
        Log.i(tag, "Get " + (forceUpdate ? " Force Update" : "") + key);
        if (floatValues == null)
            floatValues = new HashMap<String, Float>();

        if (!floatValues.containsKey(key) || forceUpdate)
            floatValues.put(key,
                    getCurrentSharedPreferences(context)
                            .getFloat(key, defaultValue));

        return floatValues.get(key);
    }

    public static void setValue(Context context, String key, Float value) {
        Log.i(tag, "Set " + key + ":" + value);

        if (floatValues == null)
            floatValues = new HashMap<String, Float>();

        Editor editor = getCurrentSharedPreferences(context)
                .edit();
        editor.putFloat(key, value);
        editor.commit();

        floatValues.put(key, value);
    }

    public static Long getLong(Context context, String key) {
        return getLong(context, key, null);
    }

    public static Long getLong(Context context, String key, Long defaultValue) {
        return getLong(context, key, defaultValue, false);
    }

    public static Long getLong(Context context, String key, Long defaultValue, boolean forceUpdate) {
        Log.i(tag, "Get " + (forceUpdate ? "Force Update " : "") + key);
        if (longValues == null)
            longValues = new HashMap<String, Long>();

        if (!longValues.containsKey(key) || forceUpdate)
            longValues.put(key,
                    getCurrentSharedPreferences(context)
                            .getLong(key, defaultValue));

        return longValues.get(key);
    }

    public static void setValue(Context context, String key, Long value) {
        Log.i(tag, "Set " + key + ":" + value);

        if (longValues == null)
            longValues = new HashMap<String, Long>();

        Editor editor = getCurrentSharedPreferences(context)
                .edit();
        editor.putLong(key, value);
        editor.commit();

        longValues.put(key, value);
    }

    public static String getString(Context context, String key) {
        return getString(context, key, null);
    }

    public static String getString(Context context, String key,
                                   String defaultValue) {
        return getString(context, key, defaultValue, false);
    }

    public static String getString(Context context, String key,
                                   String defaultValue, boolean forceUpdate) {
        Log.i(tag, "Get " + (forceUpdate ? "Force Update " : "") + key);
        if (stringValues == null)
            stringValues = new HashMap<String, String>();

        if (!stringValues.containsKey(key))
            stringValues.put(key,
                    getCurrentSharedPreferences(context)
                            .getString(key, defaultValue));

        return stringValues.get(key);
    }

    public static void setValue(Context context, String key, String value) {
        Log.i(tag, "Set " + key + ":" + value);

        if (stringValues == null)
            stringValues = new HashMap<String, String>();

        Editor editor = getCurrentSharedPreferences(context)
                .edit();
        editor.putString(key, value);
        editor.commit();

        stringValues.put(key, value);
    }

    public static Integer getInt(Context context, String key) {
        return getInt(context, key, null);
    }

    public static Integer getInt(Context context, String key,
                                 Integer defaultValue) {
        return getInt(context, key, defaultValue, false);
    }

    public static Integer getInt(Context context, String key,
                                 Integer defaultValue, boolean forceUpdate) {
        Log.i(tag, "Get " + (forceUpdate ? "Force Update " : "") + key);
        if (intValues == null)
            intValues = new HashMap<String, Integer>();

        if (!intValues.containsKey(key))
            intValues.put(key,
                    getCurrentSharedPreferences(context)
                            .getInt(key, defaultValue));

        return intValues.get(key);
    }

    public static void setValue(Context context, String key, Integer value) {
        Log.i(tag, "Set " + key + ":" + value);

        if (intValues == null)
            intValues = new HashMap<String, Integer>();

        Editor editor = getCurrentSharedPreferences(context)
                .edit();
        editor.putInt(key, value);
        editor.commit();

        intValues.put(key, value);
    }

    public static void clearValue(Context context, String key) {
        Log.i(tag, "Clear " + key);

        if (intValues == null)
            intValues = new HashMap<String, Integer>();

        if (booleanValues == null)
            booleanValues = new HashMap<String, Boolean>();

        if (floatValues == null)
            floatValues = new HashMap<String, Float>();

        if (stringValues == null)
            stringValues = new HashMap<String, String>();

        if (longValues == null)
            longValues = new HashMap<String, Long>();

        Editor editor = getCurrentSharedPreferences(context)
                .edit();
        editor.remove(key);
        editor.commit();

        intValues.remove(key);
        booleanValues.remove(key);
        floatValues.remove(key);
        stringValues.remove(key);
        longValues.remove(key);
    }

    public enum PreferencesMode {
        PRIVATE(Context.MODE_PRIVATE),
        APPEND(Context.MODE_APPEND),
        ENABLE_WRITE_AHEAD_LOGGING(Context.MODE_ENABLE_WRITE_AHEAD_LOGGING),
        MULTI_PROCESS(Context.MODE_MULTI_PROCESS);

        int value;

        PreferencesMode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
