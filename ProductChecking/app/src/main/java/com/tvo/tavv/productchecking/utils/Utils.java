package com.tvo.tavv.productchecking.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

/**
 * Created by Tavv
 * on 24/04/2017.
 */

public class Utils {
    private static Context sContext;

    public static void init(Context context) {
        sContext = context.getApplicationContext();
    }

    public static int getColorRes(int colorId) {
        return ContextCompat.getColor(sContext, colorId);
    }
}
