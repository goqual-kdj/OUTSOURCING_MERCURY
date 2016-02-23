package com.goqual.mercury.data;

import com.goqual.mercury.data.local.dao.FeedDAO;
import com.goqual.mercury.data.local.dto.FeedDTO;
import com.goqual.mercury.util.Common;

import java.util.Collection;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by ladmusician on 2/23/16.
 */
public class DatabaseHelper {
    private final String TAG = "MERCURY_HELPER_DATABASE";

    public Observable<FeedDTO> setFeeds(final Collection<FeedDTO> newFeeds) {
        return Observable.create(new Observable.OnSubscribe<FeedDTO>() {
            @Override
            public void call(Subscriber<? super FeedDTO> subscriber) {
                if (subscriber.isUnsubscribed()) return;

                try {
                    Common.log(TAG, "TEST");
                    FeedDAO dao = RealmManager.createFeedDAO();
                    dao.deleteAll();

                    for(FeedDTO feed : newFeeds) {
                        int result = dao.add(feed);
                        if (result >= 0) subscriber.onNext(feed);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Common.log(TAG, "RETROFIT FAIL");
                } finally {
                    subscriber.onCompleted();
                }
            }
        });
    }
}
