package com.goqual.mercury.presenter;

import com.goqual.mercury.data.DataManager;
import com.goqual.mercury.data.local.dto.FeedDTO;
import com.goqual.mercury.ui.MainMvpView;
import com.goqual.mercury.util.Common;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ladmusician on 2/23/16.
 */
public class FeedPresenter extends BasePresenter<MainMvpView>{
    private final String TAG = "PRESENTER_FEED";
    private Subscription mSubscription;
    private DataManager mDataManager = null;

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadFeeds() {
        mSubscription = getDataManager().getFeeds()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<FeedDTO>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Common.log(TAG, "There was an error loading the feeds.");
                        getMvpView().showError();
                    }

                    @Override
                    public void onNext(List<FeedDTO> feeds) {
                        if (feeds.isEmpty()) {
                            getMvpView().showFeedssEmpty();
                        } else {
                            getMvpView().showFeeds(feeds);
                        }
                    }
                });
    }

    private DataManager getDataManager() {
        if (mDataManager == null)
            mDataManager = new DataManager();
        return mDataManager;
    }
}
