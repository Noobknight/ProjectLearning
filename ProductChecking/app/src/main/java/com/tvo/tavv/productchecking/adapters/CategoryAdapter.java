package com.tvo.tavv.productchecking.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tvo.tavv.productchecking.BuildConfig;
import com.tvo.tavv.productchecking.R;
import com.tvo.tavv.productchecking.listeners.OnClickListener;
import com.tvo.tavv.productchecking.models.Category;

import java.util.List;

import jp.shts.android.library.TriangleLabelView;

/**
 * Created by Tavv
 * on 05/05/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> categoris;
    private OnClickListener<Category> onClickListener;

    public CategoryAdapter(List<Category> categories, OnClickListener<Category> onClickListener) {
        this.categoris = categories;
        this.onClickListener = onClickListener;
    }


    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgCategory;
        public TextView txtCategoryName;
        public TriangleLabelView txtCountProduct;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            imgCategory = (ImageView) itemView.findViewById(R.id.imgCategory);
            txtCategoryName = (TextView) itemView.findViewById(R.id.txtCategoryName);
            txtCountProduct = (TriangleLabelView) itemView.findViewById(R.id.txtCountProduct);
        }
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, final int position) {
        final Category category = categoris.get(position);
        if (category != null) {
            holder.txtCategoryName.setText(category.getName());
            Glide.with(holder.itemView.getContext()).load(BuildConfig.DOMAIN + category.getImage()).into(holder.imgCategory);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onClick(category, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return categoris.size();
    }

}
