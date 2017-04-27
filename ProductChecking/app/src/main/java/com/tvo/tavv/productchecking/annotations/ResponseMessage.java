package com.tvo.tavv.productchecking.annotations;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.tvo.tavv.productchecking.annotations.ResponseMessage.MSG_FAILURE;
import static com.tvo.tavv.productchecking.annotations.ResponseMessage.MSG_SUCCESS;

/**
 * Created by Tavv
 * on 25/04/2017.
 */
@StringDef({MSG_SUCCESS, MSG_FAILURE})
@Retention(RetentionPolicy.SOURCE)
public @interface ResponseMessage {
    String MSG_SUCCESS = "Success";
    String MSG_FAILURE = "Failure";
}
