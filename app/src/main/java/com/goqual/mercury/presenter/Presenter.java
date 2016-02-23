package com.goqual.mercury.presenter;

import com.goqual.mercury.ui.base.BaseMvpView;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface Presenter<V extends BaseMvpView> {

    void attachView(V mvpView);

    void detachView();
}
