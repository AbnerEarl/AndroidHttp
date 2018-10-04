package com.frank.ycj520.networkrequest.utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * File description.
 *
 * @author Frank
 * @date 2018/2/5
 * @emial 1320259466@qq.com
 * @description (about file's use)
 */

public class ExitAPP {
    public static void AppExit(Context context) {
        try {
            //ActivityCollector.finishAll();
            ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception ignored) {
        }
    }
}
