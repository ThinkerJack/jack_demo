package com.example.android_demo.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

//活动收集器 用于管理所有的活动
public class ActivityCollector {
    public static List<Activity> activityList = new ArrayList();

    //添加活动
    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    //删除活动
    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    //结束所有
    public static void finishAll() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activityList.clear();
        //杀死当前程序进程
//        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
