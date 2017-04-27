package com.tvo.tavv.productchecking.listeners;

import com.tvo.tavv.productchecking.networking.NetworkError;

/**
 * Created by Tavv
 * on 25/04/2017.
 */

public interface CallbackResponseService<T> {
    void onSuccess(T result);

    void onError(NetworkError error);
}
