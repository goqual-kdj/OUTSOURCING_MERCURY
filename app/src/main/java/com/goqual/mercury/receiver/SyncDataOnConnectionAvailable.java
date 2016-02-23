package com.goqual.mercury.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.goqual.mercury.service.SyncDataService;
import com.goqual.mercury.util.AndroidComponentUtil;
import com.goqual.mercury.util.Common;
import com.goqual.mercury.util.NetworkUtil;

/**
 * Created by ladmusician on 2/23/16.
 */
public class SyncDataOnConnectionAvailable extends BroadcastReceiver {
    private final String TAG = "RECEIVER_SYNC_DATA_ON_CONNECTION_AVAILABLE";

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SyncDataService.class);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)
                && NetworkUtil.isNetworkConnected(context)) {
            Common.log(TAG, "Connection is now available, triggering sync...");
            AndroidComponentUtil.toggleComponent(context, this.getClass(), false);
            context.startService(getStartIntent(context));
        }
    }
}
