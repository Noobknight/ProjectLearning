package com.tvo.tavv.productchecking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by Tavv
 * on 04/05/2017.
 */
@Generated("org.jsonschema2pojo")
public class Category {

    @SerializedName("category_id")
    @Expose
    private int categoryId;
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
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("time_create")
    @Expose
    private int timeCreate;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(int timeCreate) {
        this.timeCreate = timeCreate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", timeCreate=" + timeCreate +
                '}';
    }
}
