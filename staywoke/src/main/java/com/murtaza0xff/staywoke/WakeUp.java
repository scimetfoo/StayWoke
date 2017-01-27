package com.murtaza0xff.staywoke;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.WindowManager;


final class WakeUp {

    /**
     * Use WakeUp.init(...) to turn on the screen after deployment without
     * having to reach for the power button.
     * <pre>
     * {@code WakeUp.init(this);
     * }
     * </pre>
     * @param context The context of the activity
     */

    @NonNull
    public static WakeUp init(@NonNull  Context context){
        return new WakeUp(context);
    }

    private WakeUp(Context context){
        Window window = ((Activity) context).getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        context = null;
    }

}
