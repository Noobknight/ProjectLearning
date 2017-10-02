package com.tvo.tavv.productchecking.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tavv
 * on 04/05/2017.
 */
public class CategoryReponsitory extends BaseReponsitory<Category> implements Serializable{

    @Override
    public List<Category> getListModel() {
        return models;
    }

    @Override
    public void ListModel(List<Category> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
