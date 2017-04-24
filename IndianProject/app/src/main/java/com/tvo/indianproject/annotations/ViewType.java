package com.tvo.indianproject.annotations;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.tvo.indianproject.annotations.ViewType.VIEW_TYPE_LIST;
import static com.tvo.indianproject.annotations.ViewType.VIEW_TYPE_LOADING;

/**
 * Created by Tavv
 * on 24/04/2017.
 */
@IntDef({VIEW_TYPE_LIST, VIEW_TYPE_LOADING})
@Retention(RetentionPolicy.SOURCE)
public @interface ViewType {
    int VIEW_TYPE_LIST = 0;
    int VIEW_TYPE_LOADING = 1;
}
