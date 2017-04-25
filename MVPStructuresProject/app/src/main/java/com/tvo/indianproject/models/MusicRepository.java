package com.tvo.indianproject.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

/**
 * Created by Tavv
 * on 21/04/2017.
 */
@Generated("org.jsonschema2pojo")
public class MusicRepository {
    @SerializedName("Error")
    @Expose
    private boolean error;

    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("Musics")
    @Expose
    private List<Music> musics;

    @SerializedName("count")
    @Expose
    private int count;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MusicRepository{" +
                "error=" + error +
                ", message='" + message + '\'' +
                ", musics=" + musics +
                ", count=" + count +
                '}';
    }
}
