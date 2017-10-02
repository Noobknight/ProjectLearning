package com.tvo.tavv.productchecking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

/**
 * Created by Tavv
 * on 04/05/2017.
 */
@Generated("org.jsonschema2pojo")
public abstract class BaseReponsitory<M> implements IModelFactory<M> {
    @SerializedName("status_code")
    @Expose
    protected int statusCode;
    @SerializedName("message")
    @Expose
    protected String message;
    @SerializedName("content")
    @Expose
    protected List<M> models;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<M> getModels() {
        return models;
    }

    public void setModels(List<M> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "BaseReponsitory{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", models=" + models +
                '}';
    }
}
