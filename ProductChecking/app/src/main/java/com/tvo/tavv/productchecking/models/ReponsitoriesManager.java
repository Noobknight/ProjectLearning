package com.tvo.tavv.productchecking.models;

/**
 * Created by Tavv
 * on 04/05/2017.
 */

public class ReponsitoriesManager {

    private BaseReponsitory reponsitory;


    public ReponsitoriesManager(BaseReponsitory reponsitory) {
        this.reponsitory = reponsitory;
    }

    public BaseReponsitory getReponsitory() {
        return reponsitory;
    }

    public void setReponsitory(BaseReponsitory reponsitory) {
        this.reponsitory = reponsitory;
    }
}
