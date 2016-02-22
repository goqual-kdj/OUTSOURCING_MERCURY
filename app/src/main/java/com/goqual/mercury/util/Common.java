package com.goqual.mercury.util;

import android.util.Log;

/**
 * Created by ladmusician on 2/23/16.
 */
public class Common {
    private static boolean DEBUG_MODE = false;

    public static void log(String tag, String msg) {
        if (DEBUG_MODE) {
            Log.e(tag, msg);
        }
    }
}
