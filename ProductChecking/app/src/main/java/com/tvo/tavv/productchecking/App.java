package com.tvo.tavv.productchecking;

import android.app.Application;

import com.tvo.tavv.productchecking.dependencies.DaggerNetComponent;
import com.tvo.tavv.productchecking.dependencies.NetComponent;
import com.tvo.tavv.productchecking.models.ReponsitoriesManager;
import com.tvo.tavv.productchecking.networking.AppModule;
import com.tvo.tavv.productchecking.networking.NetworkModule;
import com.tvo.tavv.productchecking.services.Service;

import java.io.File;

import javax.inject.Inject;

/**
 * Created by Tavv
 * on 04/05/2017.
 */

public class App extends Application {
    private final String TAG = "App";


    private ReponsitoriesManager reponsitoriesManager;
    private NetComponent mNetComponent;
    @Inject
    public Service mService;

    @Override
    public void onCreate() {
        super.onCreate();
        File fileCache = new File(getCacheDir(), "responses");
        mNetComponent = DaggerNetComponent.builder()
                .networkModule(new NetworkModule(fileCache))
                .appModule(new AppModule(this))
                .build();
        mNetComponent.injectApp(this);

        mService = mNetComponent.getService();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public ReponsitoriesManager getReponsitory() {
        return reponsitoriesManager;
    }
}
