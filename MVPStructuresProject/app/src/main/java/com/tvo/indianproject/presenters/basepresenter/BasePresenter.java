package com.tvo.indianproject.presenters.basepresenter;

import android.support.annotation.NonNull;

/**
 * Created by Tavv
 * on 21/04/2017.
 */

public abstract class BasePresenter<T> {

    protected T mView;

    public final void attachView(@NonNull T view){
        mView = view;
    }

    public final void detachView(){
        mView = null;
    }

    protected final boolean isViewAttached(){
        return mView != null;
    }

}
