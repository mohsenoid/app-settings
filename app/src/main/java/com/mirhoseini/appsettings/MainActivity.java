package com.mirhoseini.appsettings;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.mirhoseini.appsettings.AppSettings;


public class MainActivity extends Activity implements View.OnClickListener {
    public static final int WEIGHT_FACTOR = 2;
    final String KEY_NAME = "name";
    final String KEY_AGE = "age";
    final String KEY_IS_MALE = "sex";
    final String KEY_WEIGHT = "weight";

    private EditText etName;
    private Spinner spAge;
    private RadioButton rbMale, rbFemale;
    private SeekBar sbWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initForm();
        loadValues();
    }

    private void initForm() {
        etName = (EditText) findViewById(R.id.etName);
        spAge = (Spinner) findViewById(R.id.spAge);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
    }

    private void loadValues() {
        etName.setText(AppSettings.getString(this, KEY_NAME, ""));
        spAge.setSelection(AppSettings.getInt(this, KEY_AGE, 0));
        rbMale.setChecked(AppSettings.getBoolean(this, KEY_IS_MALE, true));
        rbFemale.setChecked(!AppSettings.getBoolean(this, KEY_IS_MALE, true));
        sbWeight.setProgress((int) (AppSettings.getFloat(this, KEY_WEIGHT, 0f) * WEIGHT_FACTOR));
    }

    private void clearValues() {
        AppSettings.clearValue(this, KEY_NAME);
        AppSettings.clearValue(this, KEY_AGE);
        AppSettings.clearValue(this, KEY_IS_MALE);
        AppSettings.clearValue(this, KEY_WEIGHT);

        loadValues();
    }

    private void saveValues() {
        AppSettings.setValue(this, KEY_NAME, etName.getText().toString().trim());
        AppSettings.setValue(this, KEY_AGE, spAge.getSelectedItemPosition());
        AppSettings.setValue(this, KEY_IS_MALE, rbMale.isChecked());
        AppSettings.setValue(this, KEY_WEIGHT, (float) sbWeight.getProgress() / WEIGHT_FACTOR);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btClear:
                clearValues();
                break;
            case R.id.btSave:
                saveValues();
                break;
            case R.id.btLoad:
                loadValues();
                break;
        }
    }
}
