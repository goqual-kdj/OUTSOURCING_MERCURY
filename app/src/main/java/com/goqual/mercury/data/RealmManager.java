package com.goqual.mercury.data;

import com.goqual.mercury.data.local.dao.FeedDAO;

import io.realm.Realm;

/**
 * Created by ladmusician on 2/23/16.
 */
public class RealmManager {
    private static Realm mRealm;

    public static Realm open() {
        if (mRealm == null)
            mRealm = Realm.getDefaultInstance();
        return mRealm;
    }
    public static void close() {
        if (mRealm != null) {
            mRealm.close();
        }
    }
    private static void checkForOpenRealm() {
        if (mRealm == null || mRealm.isClosed()) {
            open();
            //throw new IllegalStateException("RetrofitManager: Realm is closed, call open() method first");
        }
    }

    public static FeedDAO createFeedDAO() {
        checkForOpenRealm();
        return new FeedDAO(mRealm);
    }
}
