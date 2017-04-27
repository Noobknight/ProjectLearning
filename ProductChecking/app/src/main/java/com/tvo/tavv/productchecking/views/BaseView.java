package com.tvo.tavv.productchecking.views;

/**
 * Created by Tavv
 * on 25/04/2017.
 */

public interface BaseView {

    void showProgress();

    void hideProgress();

    void showEmpty();

    void showLayoutEmpty(boolean isShow);

    void showError(String errMsg);

}
