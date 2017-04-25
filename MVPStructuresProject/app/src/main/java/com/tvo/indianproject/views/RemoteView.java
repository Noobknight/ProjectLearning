package com.tvo.indianproject.views;

/**
 * Created by Tavv
 * on 21/04/2017.
 */

public interface RemoteView {

    void showProgress();

    void hideProgress();

    void showEmpty();

    void showError(String errorMessage);

    void showMessageLayout(boolean show);
}
