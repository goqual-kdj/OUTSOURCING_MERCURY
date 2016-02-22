package com.goqual.mercury.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.goqual.mercury.receiver.SyncDataOnConnectionAvailable;
import com.goqual.mercury.util.AndroidComponentUtil;
import com.goqual.mercury.util.Common;
import com.goqual.mercury.util.NetworkUtil;

/**
 * Created by ladmusician on 2/23/16.
 */
public class SyncDataService extends Service {
    private final String TAG = "SYNC_DATA_SERVICE";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!NetworkUtil.isNetworkConnected(this)) {
            Common.log(TAG, "Sync canceled, connection not available");
            AndroidComponentUtil.toggleComponent(this, SyncDataOnConnectionAvailable.class, true);
            stopSelf(startId);
            return START_NOT_STICKY;
        }

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
