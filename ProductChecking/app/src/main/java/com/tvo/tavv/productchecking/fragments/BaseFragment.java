package com.tvo.tavv.productchecking.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tvo.tavv.productchecking.common.BaseActivity;

/**
 * Created by Tavv
 * on 25/04/2017.
 */

public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected BaseActivity baseActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mContext = container.getContext();
        return inflater.inflate(layoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initEvents();
        initData();
    }

    protected abstract int layoutId();

    protected abstract void initViews(View view);

    protected abstract void initEvents();

    protected abstract void initData();

    @Override
    public void onAttach(Context context) {
        AppCompatActivity activity;
        if (context instanceof AppCompatActivity) {
            activity = (AppCompatActivity) context;
            baseActivity = (BaseActivity) activity;
        }
        super.onAttach(context);
    }

}
