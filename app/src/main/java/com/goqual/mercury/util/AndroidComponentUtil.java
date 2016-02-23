package com.goqual.mercury.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by ladmusician on 2/23/16.
 */
public class AndroidComponentUtil {
    public static void toggleComponent(Context context, Class componentClass, boolean enable) {
        ComponentName componentName = new ComponentName(context, componentClass);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(componentName,
                enable ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED :
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }

}
