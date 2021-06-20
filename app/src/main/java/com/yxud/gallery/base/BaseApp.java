package com.yxud.gallery.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.yxud.framework.Framework;

public class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * Application的优化
         * 1.必要的组件在程序主页去初始化
         * 2.如果组件一定要在App中初始化，那么尽可能的延时
         * 3.非必要的组件，子线程中初始化
         */
        if (getApplicationInfo().packageName.equals(
                getCurProcessName(getApplicationContext()))) {
            Framework.getFramework().initFramework(this);
        }
    }

    /**
     * 获取当前进程名
     *
     * @param context
     * @return
     */
    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcessInfo : activityManager.getRunningAppProcesses()) {
            if (appProcessInfo.pid == pid) {
                return appProcessInfo.processName;
            }
        }
        return null;
    }
}
