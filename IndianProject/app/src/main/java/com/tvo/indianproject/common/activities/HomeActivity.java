package com.tvo.indianproject.common.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.tvo.indianproject.R;
import com.tvo.indianproject.adapters.HomeAdapter;
import com.tvo.indianproject.listeners.OnClickListener;
import com.tvo.indianproject.models.Music;
import com.tvo.indianproject.presenters.HomePresenter;
import com.tvo.indianproject.utils.StringUtils;
import com.tvo.indianproject.utils.Utils;
import com.tvo.indianproject.views.HomeView;

import java.util.ArrayList;
import java.util.List;

import static com.tvo.indianproject.R.id.homeRecyclerView;

/**
 * Created by Tavv
 * on 24/04/2017.
 */

public class HomeActivity extends BaseActivity implements HomeView.ListMusic, OnClickListener<Music> {
    private final String TAG = "HomeActivity";
    private static final int LIMIT = 10;
    private static final int OFFSET = 0;

    private RecyclerView mRecyclerView;

    private Toolbar mToolbar;

    private ProgressBar mContentLoadingProgress;

    private HomeAdapter mHomeAdapter;

    private HomePresenter mHomePresenter;

    private List<Music> mListMusic;

    @Override
    protected int layoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(homeRecyclerView);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mContentLoadingProgress = (ProgressBar) findViewById(R.id.progress_bar);
    }

    private void setUpRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {
        mHomePresenter = new HomePresenter(getService());
        mListMusic = new ArrayList<>();
        mHomePresenter.attachView(this);
        mHomeAdapter = new HomeAdapter(mListMusic, this);
        setUpRecyclerView(mRecyclerView, mHomeAdapter);
        mHomePresenter.onInitialListRequested(LIMIT, OFFSET);
    }

    @Override
    protected void initToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle(StringUtils.getStringRes(R.string.app_name));
            mToolbar.setBackgroundColor(Utils.getColorRes(R.color.colorPrimary));
        }
    }

    @Override
    protected String TAG() {
        return TAG;
    }

    @Override
    public void showProgress() {
        Log.i(TAG, "showProgress " + 1);
        if (mHomeAdapter.isListEmpty()) {
            mContentLoadingProgress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        Log.i(TAG, "hideProgress " + 2);
        mContentLoadingProgress.setVisibility(View.GONE);
        mHomeAdapter.removeLoadingView();
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showError(String errorMessage) {
        Log.e(TAG, "showError: " + errorMessage);
    }

    @Override
    public void showMessageLayout(boolean show) {

    }

    @Override
    public void showMusics(List<Music> musics) {
        mHomeAdapter.addItems(musics);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFailure(String message) {
        Log.e(TAG, "showError: " + message);
    }

    @Override
    public void onClick(Music item, int position) {

    }
}
