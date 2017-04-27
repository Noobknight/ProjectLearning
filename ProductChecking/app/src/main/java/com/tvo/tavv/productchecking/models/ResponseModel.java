package com.tvo.tavv.productchecking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by Tavv
 * on 25/04/2017.
 */

@Generated("org.jsonschema2pojo")
public class ResponseModel {
    @SerializedName("status_code")
    @Expose
    private int statusCode;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("product_id")
    @Expose
    private String productId;

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
