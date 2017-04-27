package com.tvo.tavv.productchecking.presenters;

/**
 * Created by Tavv
 * on 25/04/2017.
 */

public interface IBasePresenter<V> {

    void attachView(V view);

    void detachView();

    boolean isViewAttached();

}
