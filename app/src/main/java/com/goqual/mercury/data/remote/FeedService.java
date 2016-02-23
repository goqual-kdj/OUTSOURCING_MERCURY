package com.goqual.mercury.data.remote;

import com.goqual.mercury.data.RetrofitManager;
import com.goqual.mercury.data.local.dto.FeedDTO;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ladmusician on 2/23/16.
 */
public class FeedService {
    private FeedApi mFeedApi = null;

    public FeedService() {
        mFeedApi = RetrofitManager.getRetrofitBuilder().create(FeedApi.class);
    }

    public FeedApi getFeedApi() {
        if (mFeedApi == null) {
            RetrofitManager.getRetrofitBuilder().create(FeedApi.class);
        }
        return mFeedApi;
    }

    public interface FeedApi {
        @GET("api/feed/gets")
        Observable<List<FeedDTO>> getFeeds();
    }
}
