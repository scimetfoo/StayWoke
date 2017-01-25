package com.murtaza0xff.staywoke;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by murtaza on 25/1/17.
 */

public class WakeUp {

    private WakeUp(Context context){
        Window window = ((Activity) context).getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        context = null;
    }

    public static WakeUp init(Context context){
        return new WakeUp(context);
    }
}
