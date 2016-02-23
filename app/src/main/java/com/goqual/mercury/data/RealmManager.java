package com.goqual.mercury.data;

import com.goqual.mercury.data.local.dao.FeedDAO;
import com.goqual.mercury.util.Common;

import io.realm.Realm;

/**
 * Created by ladmusician on 2/23/16.
 */
public class RealmManager {
    private static final String TAG = "REALM_MANAGER";
    private Realm mRealm;

    public RealmManager() {
        checkForOpenRealm();
    }

    public Realm open() {
        if (mRealm == null)
            mRealm = Realm.getDefaultInstance();
        return mRealm;
    }
    public void close() {
        if (mRealm != null) {
            mRealm.close();
        }
    }
    private void checkForOpenRealm() {
        if (mRealm == null || mRealm.isClosed()) {
            open();
            //throw new IllegalStateException("RetrofitManager: Realm is closed, call open() method first");
        }
    }

    public FeedDAO createFeedDAO() {
        Common.log(TAG, "THREAD ID : " + Thread.currentThread().getId());
        checkForOpenRealm();
        return new FeedDAO(mRealm);
    }
}
