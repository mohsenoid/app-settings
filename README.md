App Settings
============

![Logo](icon.png)

This is a best practice for Android Applications Config Management using Shared Preferences.<br />
<b>AppSettings</b> class help you to manage deferent types of data in your application and load them in memory for faster use also save them in shared preferences for next run.
  * Eliminate SharedPreferences and Editor Commits calls.
  * Different method ovverride to set and get all data types.
  * Allow to use different XML files for saving and accessing settings.
```java
// load saved values
    private void loadValues() {
        etName.setText(AppSettings.getString(this, KEY_NAME, ""));
        spAge.setSelection(AppSettings.getInt(this, KEY_AGE, 0));
        rbMale.setChecked(AppSettings.getBoolean(this, KEY_IS_MALE, true));
        rbFemale.setChecked(!AppSettings.getBoolean(this, KEY_IS_MALE, true));
        sbWeight.setProgress((int) (AppSettings.getFloat(this, KEY_WEIGHT, 0f) * WEIGHT_FACTOR));
    }

    // clear saved values
    private void clearValues() {
        AppSettings.clearValue(this, KEY_NAME);
        AppSettings.clearValue(this, KEY_AGE);
        AppSettings.clearValue(this, KEY_IS_MALE);
        AppSettings.clearValue(this, KEY_WEIGHT);

        loadValues();
    }

    // save input values
    private void saveValues() {
        AppSettings.setValue(this, KEY_NAME, etName.getText().toString().trim());
        AppSettings.setValue(this, KEY_AGE, spAge.getSelectedItemPosition());
        AppSettings.setValue(this, KEY_IS_MALE, rbMale.isChecked());
        AppSettings.setValue(this, KEY_WEIGHT, (float) sbWeight.getProgress() / WEIGHT_FACTOR);
    }
```

USAGE
--------

Grab via Maven:
```xml
<dependency>
  <groupId>com.mirhoseini.appsettings</groupId>
  <artifactId>appsettings</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```
or Gradle:
```groovy
compile 'com.mirhoseini.appsettings:appsettings:1.0.0'
```


License
-------

    Copyright (c) 2014 Mohsen Mirhoseini Argi
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
    
Designed By: [<b>Mohsen Mirhoseini Argi</b>][1]<br />

Contact me: mohsen@mirhoseini.com

[1]: http://www.mirhoseini.com
