package com.spideriot.kkt.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.spideriot.kkt.KktApplication;

public class ScreenUtil {

    public static int[] getScreenSize() {

        WindowManager wm = (WindowManager) KktApplication.getInstance()
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics out = new DisplayMetrics();
        assert wm != null;
        wm.getDefaultDisplay().getRealMetrics(out);
        return new int[]{out.widthPixels, out.heightPixels};
    }

}
