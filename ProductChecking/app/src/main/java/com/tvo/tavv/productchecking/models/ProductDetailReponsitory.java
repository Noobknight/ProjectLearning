package com.tvo.tavv.productchecking.models;

import java.util.List;

/**
 * Created by Tavv
 * on 04/05/2017.
 */

public class ProductDetailReponsitory extends BaseReponsitory<ProductDetail> {
    @Override
    public List<ProductDetail> getListModel() {
        return models;
    }

    @Override
    public void ListModel(List<ProductDetail> models) {
        this.models = models;
    }
}
