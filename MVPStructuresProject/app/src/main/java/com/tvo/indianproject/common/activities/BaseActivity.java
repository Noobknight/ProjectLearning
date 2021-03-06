package com.tvo.indianproject.common.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tvo.indianproject.deps.DaggerDeps;
import com.tvo.indianproject.deps.Deps;
import com.tvo.indianproject.services.Service;
import com.tvo.indianproject.services.networking.NetworkModule;

import java.io.File;

import javax.inject.Inject;

/**
 * Created by Tavv
 * on 21/04/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Deps deps;
    @Inject
    public Service service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        File fileCache = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(fileCache)).build();
        deps.inject(this);
        initView();
        initToolbar();
        initEvents();
        initData();
    }

    protected abstract int layoutId();

    protected abstract void initView();

    protected abstract void initEvents();

    protected abstract void initData();

    protected void initToolbar() {
    }
    protected abstract String TAG();

    protected Deps getDeps() {
        return deps;
    }

    protected Service getService() {
        return service;
    }
}
