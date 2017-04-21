package com.tvo.indianproject.deps;

import com.tvo.indianproject.common.activities.BaseActivity;
import com.tvo.indianproject.services.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Tavv
 * on 21/04/2017.
 */
@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(BaseActivity activity);
}
