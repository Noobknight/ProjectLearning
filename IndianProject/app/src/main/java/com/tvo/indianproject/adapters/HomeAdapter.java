package com.tvo.indianproject.adapters;

import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tvo.indianproject.R;
import com.tvo.indianproject.annotations.ViewType;
import com.tvo.indianproject.listeners.OnClickListener;
import com.tvo.indianproject.models.Music;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Created by Tavv
 * on 21/04/2017.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = HomeAdapter.class.getSimpleName();
    /**
     * ViewTypes serve as a mapping point to which layout should be inflated
     */
    public static final int VIEW_TYPE_LIST = 1;
    public static final int VIEW_TYPE_LOADING = 2;

    @IntDef({VIEW_TYPE_LOADING, VIEW_TYPE_LIST})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TypeView {
    }

    @TypeView
    private int mViewType;

    private List<Music> mListMusics;
    private OnClickListener<Music> onClickListener;

    public HomeAdapter(List<Music> mListMusics, OnClickListener onClickListener) {
        this.mListMusics = mListMusics;
        //this.mListMusics = new ArrayList<>();
        this.onClickListener = onClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_LOADING) {
            return onIndicationViewHolder(parent);
        }
        return onGenericItemViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_TYPE_LOADING) {
            return;
        }
        onBindGenericItemViewHolder((HomeViewHolder) holder, position);
    }

    private RecyclerView.ViewHolder onIndicationViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_progress_bar, parent, false);
        return new ProgressBarViewHolder(view);
    }

    private RecyclerView.ViewHolder onGenericItemViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_home, parent, false);
        return new HomeViewHolder(view);
    }

    private void onBindGenericItemViewHolder(final HomeViewHolder holder, int position) {
        Music music = mListMusics.get(position);
        holder.txtTitle.setText(music.getTitle());
        holder.txtArtist.setText(music.getSinger().getName());
        holder.txtQuality.setText(music.getQuality());
        if (TextUtils.isEmpty(music.getSinger().getAvatar())) {
            Glide.with(holder.view.getContext()).load(R.mipmap.ic_launcher).into(holder.imgArtistAvt);
        } else {
            Glide.with(holder.view.getContext()).load(music.getSinger().getAvatar()).into(holder.imgArtistAvt);
        }
    }

    @Override
    public int getItemCount() {
        return mListMusics.size();
    }

    public String getMusicId(int position) {
        return mListMusics.get(position).getMusicId();
    }

    public Music getItemClick(int position) {
        return mListMusics.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return mListMusics.get(position) == null ? VIEW_TYPE_LOADING : mViewType;
    }

    public class ProgressBarViewHolder extends RecyclerView.ViewHolder {
        final ProgressBar pLoading;

        ProgressBarViewHolder(View itemView) {
            super(itemView);
            pLoading = (ProgressBar) itemView.findViewById(R.id.progress_bar);
        }
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        final View view;
        final ImageView imgArtistAvt;
        final TextView txtTitle;
        final TextView txtArtist;
        final TextView txtQuality;

        HomeViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            imgArtistAvt = (ImageView) itemView.findViewById(R.id.imgArtistAvatar);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtArtist = (TextView) itemView.findViewById(R.id.txtArtist);
            txtQuality = (TextView) itemView.findViewById(R.id.txtQuality);
        }
    }

    public boolean addLoadingView() {
        if (getItemViewType(mListMusics.size() - 1) != VIEW_TYPE_LOADING) {
            add(null);
            return true;
        }
        return false;
    }

    public boolean removeLoadingView() {
        if (mListMusics.size() > 1) {
            int loadViewPosition = mListMusics.size() - 1;
            if (getItemViewType(loadViewPosition) == VIEW_TYPE_LOADING) {
                remove(loadViewPosition);
                return true;
            }
        }
        return false;
    }

    public boolean isListEmpty() {
        return mListMusics.size() == 0;
    }

    public int getViewType() {
        return mViewType;
    }

    public void setViewType(@ViewType int viewType) {
        mViewType = viewType;
    }

    public void add(Music music) {
        add(null, music);
    }

    public void add(@Nullable Integer position, Music music) {
        if (position != null) {
            mListMusics.add(position, music);
        } else {
            mListMusics.add(music);
        }
        notifyItemInserted(position != null ? position : mListMusics.size() - 1);
    }

    public void remove(int position) {
        if (mListMusics.size() < position) {
            Log.w(TAG, "The item at position : " + position + " don't exist");
            return;
        }
        mListMusics.remove(position);
        notifyItemRemoved(position);
    }

    public void removeAll() {
        mListMusics.clear();
        notifyDataSetChanged();
    }

    public void addItems(List<Music> listMusic) {
        mListMusics.addAll(listMusic);
        notifyItemRangeInserted(getItemCount(), mListMusics.size() - 1);
    }

}
