package com.tvo.tavv.productchecking.presenters;

/**
 * Created by Tavv
 * on 25/04/2017.
 */

public class BasePresenter<V> implements IBasePresenter<V>{

    protected V mView;

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public boolean isViewAttached() {
        return mView != null;
    }
}
