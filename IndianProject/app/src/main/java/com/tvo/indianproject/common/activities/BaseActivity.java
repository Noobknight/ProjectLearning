package com.tvo.indianproject.common.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tvo.indianproject.deps.DaggerDeps;
import com.tvo.indianproject.deps.Deps;
import com.tvo.indianproject.services.networking.NetworkModule;

import java.io.File;

/**
 * Created by Tavv
 * on 21/04/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Deps deps;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        File fileCache = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(fileCache)).build();
        initView();
        initEvents();
        initData();
    }

    protected abstract int layoutId();

    protected abstract void initView();

    protected abstract void initEvents();

    protected abstract void initData();

    protected abstract String TAG();

    protected Deps getDeps(){
        return deps;
    }
}
