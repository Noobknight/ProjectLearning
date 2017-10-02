package com.tvo.tavv.productchecking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tavv
 * on 04/05/2017.
 */

public class ProductDetail {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("product_image")
    @Expose
    private String productImage;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("product_create")
    @Expose
    private int productCreate;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("level")
    @Expose
    private int level;
    @SerializedName("parent_id")
    @Expose
    private int parentId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("category_image")
    @Expose
    private String categoryImage;
    @SerializedName("category_create")
    @Expose
    private int categoryCreate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getProductCreate() {
        return productCreate;
    }

    public void setProductCreate(int productCreate) {
        this.productCreate = productCreate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public int getCategoryCreate() {
        return categoryCreate;
    }

    public void setCategoryCreate(int categoryCreate) {
        this.categoryCreate = categoryCreate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", productImage='" + productImage + '\'' +
                ", link='" + link + '\'' +
                ", productCreate=" + productCreate +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                ", description='" + description + '\'' +
                ", categoryImage='" + categoryImage + '\'' +
                ", categoryCreate=" + categoryCreate +
                '}';
    }
}
