package com.tvo.indianproject.views;

import android.support.annotation.Nullable;

import com.tvo.indianproject.models.Music;

import java.util.List;

/**
 * Created by Tavv
 * on 21/04/2017.
 */

public interface HomeView {

    interface ViewActions {
        void onInitialListRequested(@Nullable Integer limitReq, @Nullable Integer offsetReq);

        void onListEndReached(int limit, int offset);

    }

    interface ListMusic extends RemoteView {
        void showMusics(List<Music> musics);
        void onFailure(String message);
    }

}
