package com.murtaza0xff.staywoke;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public final class StayWoke implements Application.ActivityLifecycleCallbacks {


    private List<Class<?>> activities;
    private Application application;


    /**
     * Use StayWoke.init(...) to keep the specified activities awake irrespective of the idleness
     * from the users.
     * <pre>
     * {@code StayWoke.init(getApplication(), MainActivity.class, SecondActivity.class, ThirdActivity.class);
     * }
     * </pre>
     * @param application Pass in the application using `getApplication()`
     * @param activities The activities that should keep the screen awake.
     */

    @NonNull
    public static StayWoke init(@NonNull Application application, @NonNull Class... activities){
        return new StayWoke(application, activities);
    }

    private StayWoke(Application application, Class... activities) {
        this.application = application;
        this.activities = new ArrayList<>();
        register();
        addActivities(activities);
    }


    private void register(){
        application.registerActivityLifecycleCallbacks(this);
    }

    private void addActivities(Class... activities) {
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
