package com.tvo.indianproject.services.networking;

import android.support.annotation.Nullable;

import com.tvo.indianproject.models.MusicRepository;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Tavv
 * on 21/04/2017.
 */

public interface NetworkService {

    @GET("api/getAllMusic")
    Observable<MusicRepository> getMusicReponsitory(@Nullable @Query("limit") Integer limit,@Nullable @Query("offset") Integer offset);

}
