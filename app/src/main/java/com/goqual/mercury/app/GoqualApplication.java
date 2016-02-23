package com.goqual.mercury.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ladmusician on 16. 2. 3..
 */
public class GoqualApplication extends Application {
    private final int DB_VERSION = 0;
    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration realmConfiguration =
                new RealmConfiguration.Builder(this)
                        .name("realm-sample.db")
                        .schemaVersion(DB_VERSION)
                        .deleteRealmIfMigrationNeeded()
                        .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
