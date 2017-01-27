# StayWoke

[![](https://jitpack.io/v/murtaza0xff/staywoke.svg)](https://jitpack.io/#murtaza0xff/staywoke)

**StayWoke essentially has two features:**

 - Keep the screen awake while on specified activities
 using `StayWoke.init(...)`
 - Wake up the screen as soon as your app gets deployed
  on to the phone using `WakeUp.init(...)`

Here's an example implementation of StayWoke which will keep the screen
on when either `MainActivity` and `SecondActivity` is in the foreground: , and the WakeUp class which will turn the screen on automatically when you deploy the app on to the phone

```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WakeUp.init(this);
        // pass in any number of activity classes.
        StayWoke.init(getApplication(), MainActivity.class, SecondActivity.class);
    }
}
```

Note: The use of both the features in combination is not necessary.
They are both independent of each other.

## Download

Add jitpack to the project level build.gradle file:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency to the app level build.gradle file:

```groovy
dependencies {
    compile 'com.github.murtaza0xff:staywoke:1.0.0'
}
```

## License

       Copyright 2017 Murtaza Akbari

       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.