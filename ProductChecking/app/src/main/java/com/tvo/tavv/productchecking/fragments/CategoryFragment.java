package com.tvo.tavv.productchecking.fragments;

import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tvo.tavv.productchecking.R;
import com.tvo.tavv.productchecking.adapters.CategoryAdapter;
import com.tvo.tavv.productchecking.listeners.OnClickListener;
import com.tvo.tavv.productchecking.models.Category;
import com.tvo.tavv.productchecking.models.CategoryReponsitory;
import com.tvo.tavv.productchecking.presenters.CategoryPresenter;
import com.tvo.tavv.productchecking.views.CategoryView;

import java.util.List;

/**
 * Created by Tavv
 * on 04/05/2017.
 */

public class CategoryFragment extends BaseFragment implements OnClickListener<Category>, CategoryView.Event {
    private static final String TAG = CategoryFragment.class.getSimpleName();
    public static final String KEY_GET_EXTRAS = TAG;
    private CategoryPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private ProgressDialog pDialog;

    public static CategoryFragment getInstance() {
        return new CategoryFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initViews(View view) {
        mPresenter = new CategoryPresenter(baseActivity.getService());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerCategory);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mPresenter.attachView(this);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {
        mPresenter.loadCategory();
    }

    @Override
    public void onClick(Category item, int position) {
        Toast.makeText(mContext, item.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        pDialog = ProgressDialog.show(mContext, "", "Loading...");
    }

    @Override
    public void hideProgress() {
        pDialog.dismiss();
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showLayoutEmpty(boolean isShow) {

    }

    @Override
    public void showError(String errMsg) {
        Log.i(TAG, "showError " + errMsg);
    }

    @Override
    public void show(CategoryReponsitory data) {
        if (data != null) {
            List<Category> categories = data.getListModel();
            if (categories != null) {
                CategoryAdapter adapter = new CategoryAdapter(categories, this);
                mRecyclerView.setAdapter(adapter);
            }
        }
    }
}
