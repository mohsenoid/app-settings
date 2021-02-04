package com.mohsenoid.appsettings.example

import com.mohsenoid.appsettings.AppSettings
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Created by Mohsen on 12/07/16.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
class AppSettingsRobolectricTest {

    private var activity: MainActivity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        activity = Robolectric.setupActivity(MainActivity::class.java)
        assertNotNull(activity)
    }


    @After
    @Throws(Exception::class)
    fun tearDown() {
        //        activity = null;
        //        activity.finish();
    }

    @Test
    @Throws(Exception::class)
    fun testSetValues() {

        assertTrue(AppSettings.setValue(activity!!, KEY_INTEGER, SAMPLE_INTEGER_VALUE))
        assertTrue(AppSettings.getInt(activity!!, KEY_INTEGER, SAMPLE_DEFAULT_INTEGER_VALUE) === SAMPLE_INTEGER_VALUE)

        assertTrue(AppSettings.setValue(activity!!, KEY_STRING, SAMPLE_STRING_VALUE))
        assertEquals(AppSettings.getString(activity!!, KEY_STRING, SAMPLE_DEFAULT_STRING_VALUE), SAMPLE_STRING_VALUE)

        assertTrue(AppSettings.setValue(activity!!, KEY_FLOAT, SAMPLE_FLOAT_VALUE))
        assertEquals(AppSettings.getFloat(activity!!, KEY_FLOAT, SAMPLE_DEFAULT_FLOAT_VALUE), SAMPLE_FLOAT_VALUE)

        assertTrue(AppSettings.setValue(activity!!, KEY_LONG, SAMPLE_LONG_VALUE))
        assertEquals(AppSettings.getLong(activity!!, KEY_LONG, SAMPLE_DEFAULT_LONG_VALUE), SAMPLE_LONG_VALUE)

        assertTrue(AppSettings.setValue(activity!!, KEY_BOOLEAN, SAMPLE_BOOLEAN_VALUE))
        assertEquals(AppSettings.getBoolean(activity!!, KEY_BOOLEAN, SAMPLE_DEFAULT_BOOLEAN_VALUE), SAMPLE_BOOLEAN_VALUE)

    }

    @Test
    @Throws(Exception::class)
    fun testGetNullValues() {

        assertNull(AppSettings.getInt(activity!!, KEY_INTEGER, null))

        assertNull(AppSettings.getString(activity!!, KEY_STRING, null))

        assertNull(AppSettings.getFloat(activity!!, KEY_FLOAT, null))

        assertNull(AppSettings.getLong(activity!!, KEY_LONG, null))

        assertNull(AppSettings.getBoolean(activity!!, KEY_BOOLEAN, null))

    }

    @Test
    @Throws(Exception::class)
    fun testSetNullValues() {

        assertTrue(AppSettings.setValue(activity!!, KEY_INTEGER, NULL_INTEGER_VALUE))

        assertTrue(AppSettings.setValue(activity!!, KEY_STRING, NULL_STRING_VALUE!!))

        assertTrue(AppSettings.setValue(activity!!, KEY_FLOAT, NULL_FLOAT_VALUE))

        assertTrue(AppSettings.setValue(activity!!, KEY_LONG, NULL_FLOAT_VALUE))

        assertTrue(AppSettings.setValue(activity!!, KEY_BOOLEAN, NULL_BOOLEAN_VALUE))

    }

    companion object {

        val KEY_INTEGER = "key_integer"
        val KEY_STRING = "key_string"
        val KEY_FLOAT = "key_float"
        val KEY_BOOLEAN = "key_boolean"
        val KEY_LONG = "key_long"


        val SAMPLE_INTEGER_VALUE = 100
        val SAMPLE_DEFAULT_INTEGER_VALUE = 0
        val NULL_INTEGER_VALUE: Int? = null

        val SAMPLE_STRING_VALUE = "This is sample String"
        val SAMPLE_DEFAULT_STRING_VALUE = "Default String"
        val NULL_STRING_VALUE: String? = null

        val SAMPLE_FLOAT_VALUE = 5.5f
        val SAMPLE_DEFAULT_FLOAT_VALUE = 1.5f
        val NULL_FLOAT_VALUE: Float? = null

        val SAMPLE_LONG_VALUE = 4L
        val SAMPLE_DEFAULT_LONG_VALUE: Long? = -1L
        val NULL_LONG_VALUE: Long? = null

        val SAMPLE_BOOLEAN_VALUE = true
        val SAMPLE_DEFAULT_BOOLEAN_VALUE = false
        val NULL_BOOLEAN_VALUE: Boolean? = null
    }


}