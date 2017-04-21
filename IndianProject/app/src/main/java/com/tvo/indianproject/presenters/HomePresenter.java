package com.tvo.indianproject.presenters;

import com.tvo.indianproject.listeners.ServiceCallbackListener;
import com.tvo.indianproject.models.Music;
import com.tvo.indianproject.models.MusicRepository;
import com.tvo.indianproject.presenters.basepresenter.BasePresenter;
import com.tvo.indianproject.services.Service;
import com.tvo.indianproject.services.networking.NetworkError;
import com.tvo.indianproject.views.HomeView;

import java.util.List;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Tavv
 * on 21/04/2017.
 */

public class HomePresenter extends BasePresenter<HomeView.ListMusic> implements HomeView.ViewActions {
    private static final int ITEM_REQUEST_INITIAL_OFFSET = 0;
    private static final int ITEM_REQUEST_LIMIT = 10;

    private final Service service;
    private CompositeSubscription subscriptions;

    public HomePresenter(Service service) {
        this.service = service;
        this.subscriptions = new CompositeSubscription();
    }


    @Override
    public void onInitialListRequested(int limitReq, int offsetReq) {
        int limit = limitReq | ITEM_REQUEST_LIMIT;
        int offset = offsetReq | ITEM_REQUEST_INITIAL_OFFSET;
        getListMusic(limit, offset);
    }

    @Override
    public void onListEndReached(int limit, int offset) {

    }


    private void getListMusic(int limit, int offset) {
        if (!isViewAttached()) return;
        mView.showMessageLayout(false);
        mView.showProgress();

        Subscription subscription = service.getAllMusic(new ServiceCallbackListener<MusicRepository>() {
            @Override
            public void onSuccess(MusicRepository data) {
                if (!isViewAttached()) return;
                mView.hideProgress();
                List<Music> musics = data.getMusics();
                if (musics.isEmpty()) {
                    mView.showEmpty();
                    return;
                }
                mView.showMusics(musics);
            }

            @Override
            public void onError(NetworkError e) {
                mView.hideProgress();
                mView.onFailure(e.getAppErrorMessage());
            }
        }, limit, offset);
        subscriptions.add(subscription);
    }

    public void stop() {
        subscriptions.unsubscribe();
    }
}
