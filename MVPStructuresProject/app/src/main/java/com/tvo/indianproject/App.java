package com.tvo.indianproject;

import android.app.Application;

import com.tvo.indianproject.utils.StringUtils;
import com.tvo.indianproject.utils.Utils;

/**
 * Created by Tavv
 * on 24/04/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        StringUtils.init(this);
        Utils.init(this);
    }
}
