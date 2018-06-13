package com.spideriot.kkt.utils;

import com.spideriot.kkt.KktApplication;

public class DensityUtil {


    public static int dp2px(float dpValue) {
        final float density = KktApplication.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dpValue* density + 0.5f);
    }
}
