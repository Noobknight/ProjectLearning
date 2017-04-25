package com.tvo.indianproject.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by Tavv
 * on 21/04/2017.
 */
@Generated("org.jsonschema2pojo")
public class Music {
    @SerializedName("music_id")
    @Expose
    private String musicId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("lyric")
    @Expose
    private String lyric;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("stream")
    @Expose
    private String stream;
    @SerializedName("quality")
    @Expose
    private String quality;
    @SerializedName("singer")
    @Expose
    private Singer singer;

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }
}
