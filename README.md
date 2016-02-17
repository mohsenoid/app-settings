# app_settings
==============

![Logo](website/static/logo.png)

<h1>App Settings</h1>
This is a best practice for Android Applications Config Management using Shared Preferences.<br />
<b>AppSettings</b> class help you to manage deferent types of data in your application and load them in memory for faster use also save them in shared preferences for next run.
  * Eliminate SharedPreferences and Editor Commits calls.
  * Different method ovverride to set and get all data types.
  * Allow to use different XML files for saving and accessing settings.

USAGE
--------

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
    
Designed By: [<b>Mohsen Mirhoseini Argi</b>][3]<br />

Contact me: mohsen@mirhoseini.com

[2]: https://search.maven.org/remote_content?g=com.jakewharton&a=butterknife&v=LATEST
[3]: http://www.mirhoseini.com
