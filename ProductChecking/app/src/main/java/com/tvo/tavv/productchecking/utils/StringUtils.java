package com.tvo.tavv.productchecking.utils;

import android.content.Context;

/**
 * Created by Tavv
 * on 24/04/2017.
 */

public class StringUtils {
    private static Context sContext;

    public static void init(Context context) {
        sContext = context.getApplicationContext();
    }

    public static String getStringRes(int idStringRes) {
        return sContext.getResources().getString(idStringRes);
    }

    public static String[] getStringArray(int idStringArray) {
        return sContext.getResources().getStringArray(idStringArray);
    }
}
