package com.tvo.tavv.productchecking.dependencies;

import android.app.Application;

import com.tvo.tavv.productchecking.common.BaseActivity;
import com.tvo.tavv.productchecking.networking.AppModule;
import com.tvo.tavv.productchecking.networking.NetworkModule;
import com.tvo.tavv.productchecking.services.Service;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Tavv
 * on 25/04/2017.
 */
@Singleton
@Component(modules = {NetworkModule.class, AppModule.class})
public interface NetComponent {
    void inject(BaseActivity activity);
    void injectApp(Application application);
    Service getService();
}
