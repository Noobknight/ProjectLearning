package com.tvo.tavv.productchecking.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.tvo.tavv.productchecking.listeners.OnClickListener;
import com.tvo.tavv.productchecking.models.Product;

import java.util.List;

/**
 * Created by Tavv
 * on 25/04/2017.
 */

public class ProductAdapter extends BaseAdapter<ProductAdapter.ProductViewHolder, Product>{

    public ProductAdapter(OnClickListener onClickListener, List<Product> dataSource) {
        super(onClickListener, dataSource);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        public ProductViewHolder(View itemView) {
            super(itemView);
        }
    }
}
