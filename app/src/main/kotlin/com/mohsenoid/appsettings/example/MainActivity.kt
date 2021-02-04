package com.mohsenoid.appsettings.example

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.mohsenoid.appsettings.AppSettings
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // you can switch to another preferences file instead of application default one
        AppSettings.switchSharedPreferences("my_very_own_prefs", AppSettings.PreferencesMode.MULTI_PROCESS)

        loadValues()
    }

    // load saved values
    private fun loadValues() {
        etName.setText(AppSettings.getString(this, KEY_NAME, "") ?: "")
        spAge.setSelection(AppSettings.getInt(this, KEY_AGE, 0) ?: 0)
        rbMale.isChecked = AppSettings.getBoolean(this, KEY_IS_MALE, true) ?: true
        rbFemale.isChecked = !(AppSettings.getBoolean(this, KEY_IS_MALE, true) ?: true)
        sbWeight.progress = (AppSettings.getFloat(this, KEY_WEIGHT, 0f)
                ?: 0f).toInt()
    }

    // clear saved values
    private fun clearValues() {
        AppSettings.clearValue(this, KEY_NAME)
        AppSettings.clearValue(this, KEY_AGE)
        AppSettings.clearValue(this, KEY_IS_MALE)
        AppSettings.clearValue(this, KEY_WEIGHT)

        loadValues()
    }

    // save input values
    private fun saveValues() {
        AppSettings.setValue(this, KEY_NAME, etName.text.toString().trim { it <= ' ' })
        AppSettings.setValue(this, KEY_AGE, spAge.selectedItemPosition)
        AppSettings.setValue(this, KEY_IS_MALE, rbMale.isChecked)
        AppSettings.setValue(this, KEY_WEIGHT, sbWeight.progress.toFloat())
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.btClear -> clearValues()
            R.id.btSave -> saveValues()
            R.id.btLoad -> loadValues()
        }
    }

    companion object {
        private const val KEY_NAME = "name"
        private const val KEY_AGE = "age"
        private const val KEY_IS_MALE = "sex"
        private const val KEY_WEIGHT = "weight"
    }
}
