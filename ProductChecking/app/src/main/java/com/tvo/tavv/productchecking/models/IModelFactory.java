package com.tvo.tavv.productchecking.models;

import java.util.List;

/**
 * Created by Tavv
 * on 04/05/2017.
 */

public interface IModelFactory<T> {

    List<T> getListModel();

    void ListModel(List<T> models);

}
