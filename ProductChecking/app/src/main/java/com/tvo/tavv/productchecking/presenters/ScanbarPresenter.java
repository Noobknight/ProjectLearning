package com.tvo.tavv.productchecking.presenters;

import com.tvo.tavv.productchecking.listeners.CallbackResponseService;
import com.tvo.tavv.productchecking.models.Product;
import com.tvo.tavv.productchecking.models.ResponseModel;
import com.tvo.tavv.productchecking.networking.NetworkError;
import com.tvo.tavv.productchecking.services.Service;
import com.tvo.tavv.productchecking.views.ScanbarView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Tavv
 * on 26/04/2017.
 */

public class ScanbarPresenter extends BasePresenter<ScanbarView.Render<ResponseModel>> implements ScanbarView.Actions<ResponseModel> {

    private static final String TAG = ScanbarPresenter.class.getSimpleName();

    private final Service mService;

    private CompositeSubscription mCompositeSubscription;

    public ScanbarPresenter(Service mService) {
        this.mService = mService;
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onSendRequest(Product product) {
        saveProduct(product);
    }

    private void saveProduct(final Product product) {
        if (!isViewAttached()) return;
        Subscription subscription = mService.saveProduct(new CallbackResponseService<ResponseModel>() {
            @Override
            public void onSuccess(ResponseModel result) {
                mView.onResponse(result);
            }

            @Override
            public void onError(NetworkError error) {
                mView.onFailure(error.getAppErrorMessage());
            }
        }, product);
        mCompositeSubscription.add(subscription);
    }

    public void stop(){
        mCompositeSubscription.unsubscribe();
    }
}
