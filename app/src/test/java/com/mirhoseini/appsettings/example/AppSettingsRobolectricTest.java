package com.mirhoseini.appsettings.example;

import com.mirhoseini.appsettings.AppSettings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Mohsen on 12/07/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class AppSettingsRobolectricTest {

    public static final String KEY_INTEGER = "key_integer";
    public static final String KEY_STRING = "key_string";
    public static final String KEY_FLOAT = "key_float";
    public static final String KEY_BOOLEAN = "key_boolean";
    public static final String KEY_LONG = "key_long";


    public static final Integer SAMPLE_INTEGER_VALUE = 100;
    public static final Integer SAMPLE_DEFAULT_INTEGER_VALUE = 0;
    public static final Integer NULL_INTEGER_VALUE = null;

    public static final String SAMPLE_STRING_VALUE = "This is sample String";
    public static final String SAMPLE_DEFAULT_STRING_VALUE = "Default String";
    public static final String NULL_STRING_VALUE = null;

    public static final Float SAMPLE_FLOAT_VALUE = 5.5f;
    public static final Float SAMPLE_DEFAULT_FLOAT_VALUE = 1.5f;
    public static final Float NULL_FLOAT_VALUE = null;

    public static final Long SAMPLE_LONG_VALUE = 4l;
    public static final Long SAMPLE_DEFAULT_LONG_VALUE = -1l;
    public static final Long NULL_LONG_VALUE = null;

    public static final Boolean SAMPLE_BOOLEAN_VALUE = true;
    public static final Boolean SAMPLE_DEFAULT_BOOLEAN_VALUE = false;
    public static final Boolean NULL_BOOLEAN_VALUE = null;

    private MainActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(activity);
    }


    @After
    public void tearDown() throws Exception {
//        activity = null;
//        activity.finish();
    }

    @Test
    public void testSetValues() throws Exception {

        assertTrue(AppSettings.setValue(activity, KEY_INTEGER, SAMPLE_INTEGER_VALUE));
        assertTrue(AppSettings.getInt(activity, KEY_INTEGER, SAMPLE_DEFAULT_INTEGER_VALUE) == SAMPLE_INTEGER_VALUE);

        assertTrue(AppSettings.setValue(activity, KEY_STRING, SAMPLE_STRING_VALUE));
        assertEquals(AppSettings.getString(activity, KEY_STRING, SAMPLE_DEFAULT_STRING_VALUE), SAMPLE_STRING_VALUE);

        assertTrue(AppSettings.setValue(activity, KEY_FLOAT, SAMPLE_FLOAT_VALUE));
        assertEquals(AppSettings.getFloat(activity, KEY_FLOAT, SAMPLE_DEFAULT_FLOAT_VALUE), SAMPLE_FLOAT_VALUE);

        assertTrue(AppSettings.setValue(activity, KEY_LONG, SAMPLE_LONG_VALUE));
        assertEquals(AppSettings.getLong(activity, KEY_LONG, SAMPLE_DEFAULT_LONG_VALUE), SAMPLE_LONG_VALUE);

        assertTrue(AppSettings.setValue(activity, KEY_BOOLEAN, SAMPLE_BOOLEAN_VALUE));
        assertEquals(AppSettings.getBoolean(activity, KEY_BOOLEAN, SAMPLE_DEFAULT_BOOLEAN_VALUE), SAMPLE_BOOLEAN_VALUE);

    }

    @Test
    public void testGetNullValues() throws Exception {

        assertNull(AppSettings.getInt(activity, KEY_INTEGER, null));

        assertNull(AppSettings.getString(activity, KEY_STRING, null));

        assertNull(AppSettings.getFloat(activity, KEY_FLOAT, null));

        assertNull(AppSettings.getLong(activity, KEY_LONG, null));

        assertNull(AppSettings.getBoolean(activity, KEY_BOOLEAN, null));

    }

    @Test
    public void testSetNullValues() throws Exception {

        assertTrue(AppSettings.setValue(activity, KEY_INTEGER, NULL_INTEGER_VALUE));

        assertTrue(AppSettings.setValue(activity, KEY_STRING, NULL_STRING_VALUE));

        assertTrue(AppSettings.setValue(activity, KEY_FLOAT, NULL_FLOAT_VALUE));

        assertTrue(AppSettings.setValue(activity, KEY_LONG, NULL_FLOAT_VALUE));

        assertTrue(AppSettings.setValue(activity, KEY_BOOLEAN, NULL_BOOLEAN_VALUE));

    }


}