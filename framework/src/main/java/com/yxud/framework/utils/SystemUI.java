package com.yxud.framework.utils;

import android.app.Activity;
import android.os.Build;

/**
 * SystemUI
 *
 * @author yangxudong
 * @date 2021-05-30
 */
public class SystemUI {

    /**
     * 设置沉浸式状态栏
     *
     * @param activity
     */
    public static void fixSystemUI(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 获取最顶层的View
//            activity.getWindow().getDecorView()
//                    .setSystemUiVisibility(
//                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
