package com.tvo.tavv.productchecking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

/**
 * Created by Tavv
 * on 25/04/2017.
 */
@Generated("org.jsonschema2pojo")
public class ProductRepository {

    @SerializedName("status_code")
    @Expose
    private int statusCode;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("content")
    @Expose
    private List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", products=" + products +
                '}';
    }
}
