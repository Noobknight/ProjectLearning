package com.tvo.indianproject.common;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Tavv
 * on 24/04/2017.
 */

public abstract class EndlessRecyclerViewOnScrollListener extends RecyclerView.OnScrollListener {
    public static String TAG = EndlessRecyclerViewOnScrollListener.class.getSimpleName();

    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true; // True if we are still waiting for the last set of data to load.
    private int visibleThreshold = 5; // The minimum amount of items to have below your current scroll position before loading more.
    int firstVisibleItem, visibleItemCount, totalItemCount;

    private int mCurrentPage;

    private LinearLayoutManager mLinearLayoutManager;

    public EndlessRecyclerViewOnScrollListener(LinearLayoutManager linearLayoutManager, int typeGet) {
        this.mLinearLayoutManager = linearLayoutManager;
        this.mCurrentPage = typeGet;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
        firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount)
                <= (firstVisibleItem + visibleThreshold) && mCurrentPage < 2) {
            // End has been reached

            // Do something
            mCurrentPage++;
            onLoadMore(mCurrentPage);

            loading = true;
        }
    }

    public abstract void onLoadMore(int currentPage);
}
