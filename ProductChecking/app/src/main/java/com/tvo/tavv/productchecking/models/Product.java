package com.tvo.tavv.productchecking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by Tavv
 * on 25/04/2017.
 */
@Generated("org.jsonschema2pojo")
public class Product {

    @SerializedName("product_id")
    @Expose
    private String productId;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("link")
    @Expose
    private String link;

    public Product() {
    }

    public Product(String productId, String image, String link) {
        this.productId = productId;
        this.image = image;
        this.link = link;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product product = (Product) obj;
            return (this.productId == product.productId) && (this.image == product.image)
                    && (this.link == product.link);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", image='" + image + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
