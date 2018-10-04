package com.frank.ycj520.networkrequest.utils;

import android.app.Activity;

import java.util.LinkedList;

/**
 * File description.
 *
 * @author Frank
 * @date 2018/2/5
 * @emial 1320259466@qq.com
 * @description (about file's use)
 */

public class ActivityCollector {

    public static LinkedList<Activity> activities = new LinkedList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }


}
