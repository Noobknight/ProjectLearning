package com.tvo.tavv.productchecking.adapters;

import android.support.v7.widget.RecyclerView;

import com.tvo.tavv.productchecking.listeners.OnClickListener;

import java.util.List;

/**
 * Created by Tavv
 * on 05/10/2017.
 */

public abstract class BaseAdapter<V extends RecyclerView.ViewHolder, M> extends RecyclerView.Adapter<V>{

    private OnClickListener onClickListener;

    private List<M> dataSource;

    public BaseAdapter(OnClickListener onClickListener, List<M> dataSource){
        this.onClickListener = onClickListener;
        this.dataSource = dataSource;
    }

    public OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public List<M> getDataSource() {
        return dataSource;
    }

    public void setDataSource(List<M> dataSource) {
        this.dataSource = dataSource;
    }
}
