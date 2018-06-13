package com.spideriot.kkt;

import android.app.Application;

import com.spideriot.kkt.common.Constants;
import com.spideriot.kkt.utils.ScreenUtil;

public class KktApplication extends Application {

    private static KktApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    private void init() {
        int[] size = ScreenUtil.getScreenSize();
        Constants.SCREEN_WIDTH = size[0];
        Constants.SCREEN_HEIGHT = size[1];
    }


    public static KktApplication getInstance() {
        return instance;
    }


}
