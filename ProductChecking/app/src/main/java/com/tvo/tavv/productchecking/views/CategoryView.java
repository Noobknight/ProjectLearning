package com.tvo.tavv.productchecking.views;

import com.tvo.tavv.productchecking.models.CategoryReponsitory;

/**
 * Created by Tavv
 * on 04/05/2017.
 */

public interface CategoryView {

    interface Action{
        void loadCategory();
    }

    interface Event extends BaseView{
        void show(CategoryReponsitory categoryReponsitory);
    }

}
