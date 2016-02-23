package com.goqual.mercury.ui;

import android.os.Bundle;

import com.goqual.mercury.R;
import com.goqual.mercury.data.local.dto.FeedDTO;
import com.goqual.mercury.presenter.FeedPresenter;
import com.goqual.mercury.ui.base.BaseActivity;
import com.goqual.mercury.util.Common;

import java.util.List;

import butterknife.BindString;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {
    private final String TAG = "ACTIVITY_MAIN";
    @BindString(R.string.EXTRA_TRIGGER_SYNC_FLAG)
    String EXTRA_TRIGGER_SYNC_FLAG;

    private FeedPresenter mFeedPresenter = null;

    @Override
    public void showFeeds(List<FeedDTO> ribots) {
        Common.log(TAG, "SHOW FEEDS");
    }

    @Override
    public void showFeedssEmpty() {
        Common.log(TAG, "SHOW EMPTY FEEDS");
    }

    @Override
    public void showError() {
        Common.log(TAG, "ERROR!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getFeedPresenter().attachView(this);
        getFeedPresenter().loadFeeds();

//        if (getIntent().getBooleanExtra(EXTRA_TRIGGER_SYNC_FLAG, true)) {
//            startService(SyncDataService.getStartIntent(this));
//        }
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    private FeedPresenter getFeedPresenter() {
        if (mFeedPresenter == null) mFeedPresenter = new FeedPresenter();
        return mFeedPresenter;
    }
}
