package com.tvo.tavv.productchecking.views;

import com.tvo.tavv.productchecking.models.Product;

/**
 * Created by Tavv
 * on 26/04/2017.
 */

public interface ScanbarView {

    interface Actions<R> extends BaseAction<R> {
        void onSendRequest(Product product);
    }


    interface Render<M> {
        void showBottomControl(boolean isShow);
        void onResponse(M responseModel);
        void onFailure(String msgError);
    }

}
