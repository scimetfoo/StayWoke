package com.murtaza0xff.staywoke;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;




public class StayWoke implements Application.ActivityLifecycleCallbacks {


    private List<Class<?>> activities;

    public StayWoke(Application application, Class... activities) {
        application.registerActivityLifecycleCallbacks(this);
        this.activities = new ArrayList<>();
        for (Class activity : activities) {
            this.activities.add(activity);
        }
    }

    @Override
    public void onActivityStopped(Activity activity) {
        if (activities.contains(activity.getClass())){
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (activities.contains(activity.getClass())){
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }
}
