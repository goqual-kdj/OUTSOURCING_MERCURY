package com.goqual.mercury.ui;

import com.goqual.mercury.data.local.dto.FeedDTO;
import com.goqual.mercury.ui.base.BaseMvpView;

import java.util.List;

/**
 * Created by ladmusician on 2/23/16.
 */
public interface MainMvpView extends BaseMvpView {
    void showFeeds(List<FeedDTO> ribots);
    void showFeedssEmpty();
    void showError();
}
