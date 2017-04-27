package com.tvo.tavv.productchecking.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.tvo.tavv.productchecking.dependencies.DaggerNetComponent;
import com.tvo.tavv.productchecking.dependencies.NetComponent;
import com.tvo.tavv.productchecking.networking.NetworkModule;
import com.tvo.tavv.productchecking.services.Service;

import java.io.File;

import javax.inject.Inject;

import static com.tvo.tavv.productchecking.R.id.toolbar;

/**
 * Created by Tavv
 * on 21/04/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected NetComponent deps;

    @Inject
    protected Service mService;

    public FragmentManager mFragmentManager;

    public FragmentTransaction mFragmentTransaction;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        File fileCache = new File(getCacheDir(), "responses");
        deps = DaggerNetComponent.builder().networkModule(new NetworkModule(fileCache)).build();
        deps.inject(this);
        mFragmentManager = getSupportFragmentManager();
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
        mToolbar = findToolbar();
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(true);
        }
    }


    private Toolbar findToolbar() {
        return (Toolbar) findViewById(toolbar);
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        mToolbar = toolbar;
    }

    protected abstract String TAG();

    public NetComponent getDeps() {
        return deps;
    }

    public Service getService() {
        return mService;
    }
}
