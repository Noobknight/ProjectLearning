package com.tvo.tavv.productchecking.models;

import java.util.List;

/**
 * Created by Tavv
 * on 25/04/2017.
 */
public class ProductRepository extends BaseReponsitory<Product> {

    @Override
    public List<Product> getListModel() {
        return models;
    }

    @Override
    public void ListModel(List<Product> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
