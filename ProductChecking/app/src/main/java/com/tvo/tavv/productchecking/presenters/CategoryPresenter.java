package com.tvo.tavv.productchecking.presenters;

import com.tvo.tavv.productchecking.listeners.CallbackResponseService;
import com.tvo.tavv.productchecking.models.CategoryReponsitory;
import com.tvo.tavv.productchecking.networking.NetworkError;
import com.tvo.tavv.productchecking.services.Service;
import com.tvo.tavv.productchecking.views.CategoryView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Tavv
 * on 04/05/2017.
 */

public class CategoryPresenter extends BasePresenter<CategoryView.Event> implements CategoryView.Action {
    private static final String TAG = CategoryPresenter.class.getSimpleName();
    private final Service mService;

    private CompositeSubscription mCompositeSubscription;

    public CategoryPresenter(Service mService) {
        this.mService = mService;
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void loadCategory() {
        if (!isViewAttached()) return;
        mView.showProgress();
        Subscription subscription = mService.getAllCategory(new CallbackResponseService<CategoryReponsitory>() {
            @Override
            public void onSuccess(CategoryReponsitory result) {
                mView.hideProgress();
                mView.show(result);
            }

            @Override
            public void onError(NetworkError error) {
                mView.hideProgress();
                mView.showError(error.getMessage());
            }
        });
        mCompositeSubscription.add(subscription);
    }

    public void stop() {
        mCompositeSubscription.unsubscribe();
    }
}
