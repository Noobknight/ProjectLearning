package com.tvo.indianproject.services;

import com.tvo.indianproject.listeners.ServiceCallbackListener;
import com.tvo.indianproject.models.MusicRepository;
import com.tvo.indianproject.services.networking.NetworkError;
import com.tvo.indianproject.services.networking.NetworkService;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Tavv
 * on 21/04/2017.
 */

public class Service {

    public final NetworkService mNetworkService;

    public Service(NetworkService mNetworkService) {
        this.mNetworkService = mNetworkService;
    }

    public Subscription getAllMusic(final ServiceCallbackListener<MusicRepository> callback, int limit, int offset) {
        return mNetworkService.getMusicReponsitory(limit, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends MusicRepository>>() {
                    @Override
                    public Observable<? extends MusicRepository> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<MusicRepository>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(MusicRepository musicRepository) {
                        callback.onSuccess(musicRepository);
                    }
                });
    }
}
