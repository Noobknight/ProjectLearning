package com.tvo.tavv.productchecking.services;

import com.tvo.tavv.productchecking.constants.ApiConstant;
import com.tvo.tavv.productchecking.listeners.CallbackResponseService;
import com.tvo.tavv.productchecking.models.CategoryReponsitory;
import com.tvo.tavv.productchecking.models.Product;
import com.tvo.tavv.productchecking.models.ProductRepository;
import com.tvo.tavv.productchecking.models.ResponseModel;
import com.tvo.tavv.productchecking.networking.NetworkError;
import com.tvo.tavv.productchecking.networking.NetworkService;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Tavv
 * on 25/04/2017.
 */

public class Service {

    private final NetworkService mNetworkService;

    public Service(NetworkService networkService) {
        this.mNetworkService = networkService;
    }

    public Subscription getAllProduct(final CallbackResponseService<ProductRepository> callback, int limit, int offset) {
        return mNetworkService.getAllProduct(limit, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ProductRepository>>() {
                    @Override
                    public Observable<? extends ProductRepository> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                }).subscribe(new Subscriber<ProductRepository>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(ProductRepository productRepository) {
                        callback.onSuccess(productRepository);
                    }
                });
    }

    public Subscription saveProduct(final CallbackResponseService<ResponseModel> callback, Product product) {
        return mNetworkService.saveProduct(product)
                .retry(3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ResponseModel>>() {
                    @Override
                    public Observable<? extends ResponseModel> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Observer<ResponseModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(ResponseModel responseModel) {
                        callback.onSuccess(responseModel);
                    }
                });
    }

    public Subscription getAllCategory(final CallbackResponseService<CategoryReponsitory> callback) {
        return mNetworkService.getAllCategory(ApiConstant.GET_ALL_CATEGORY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CategoryReponsitory>>() {
                    @Override
                    public Observable<? extends CategoryReponsitory> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Observer<CategoryReponsitory>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(CategoryReponsitory categoryReponsitory) {
                        callback.onSuccess(categoryReponsitory);
                    }
                });
    }
}
