package com.tvo.indianproject.listeners;

import com.tvo.indianproject.services.networking.NetworkError;

/**
 * Created by Tavv
 * on 21/04/2017.
 */

public interface ServiceCallbackListener<T> {

    void onSuccess(T data);

    void onError(NetworkError e);
}
