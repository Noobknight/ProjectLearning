package com.tvo.tavv.productchecking.dependencies;

import com.tvo.tavv.productchecking.common.BaseActivity;
import com.tvo.tavv.productchecking.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Tavv
 * on 25/04/2017.
 */
@Singleton
@Component(modules = {NetworkModule.class})
public interface NetComponent {
    void inject(BaseActivity activity);
}
