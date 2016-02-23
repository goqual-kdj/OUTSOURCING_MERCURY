package com.goqual.mercury.data.local.dao;

import android.support.annotation.NonNull;

import com.goqual.mercury.data.local.dto.FeedDTO;
import com.goqual.mercury.data.model.Feed;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by ladmusician on 2/23/16.
 */
public class FeedDAO {
    private Realm mRealm = null;
    public FeedDAO(@NonNull Realm realm) {
        this.mRealm = realm;
    }

    public List<FeedDTO> gets() {
        mRealm.beginTransaction();
        List<FeedDTO> rtv = new ArrayList<>();
        RealmResults<Feed> results = mRealm.where(Feed.class).findAll();
        results.sort("seq", Sort.DESCENDING);

        for(Feed each : results) {
            rtv.add(convertToDTO(each));
        }
        mRealm.commitTransaction();
        return rtv;
    }

    public FeedDTO getById(int id) {
        mRealm.beginTransaction();
        Feed result = mRealm.where(Feed.class)
                .equalTo("id", id)
                .findFirst();

        FeedDTO rtv = convertToDTO(result);
        mRealm.commitTransaction();
        return rtv;
    }

    public int add(final FeedDTO item) {
        mRealm.beginTransaction();
        Feed feed = convertToRealmObject(item);
        int realmId = 0;
        Number lastId = mRealm.where(Feed.class).max("id");
        if (lastId != null)
            realmId = lastId.intValue() + 1;
        feed.setId(realmId);
        mRealm.copyToRealmOrUpdate(feed);
        mRealm.commitTransaction();

        return realmId;
    }

    public void updateFeed(final FeedDTO item) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mRealm.copyToRealmOrUpdate(convertToRealmObject(item));
            }
        });
    }

    public void deleteAll() {
        RealmResults<Feed> results = mRealm.where(Feed.class).findAll();
        mRealm.beginTransaction();
        results.clear();
        mRealm.commitTransaction();
    }


     /* convert logic */
    private FeedDTO convertToDTO(Feed item) {
        return new FeedDTO();
    }
    private Feed convertToRealmObject(FeedDTO item) {
        return new Feed();
    }
}
