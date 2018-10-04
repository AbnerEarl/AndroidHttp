package com.frank.ycj520.networkrequest.utils;

import android.util.Log;

/**
 * PROJECT_NAME:SZJDSpecialDeviceExam
 * PACKAGE_NAME:com.example.frank.jinding.Log
 * USER:Frank
 * DATE:2018/6/19
 * TIME:4:25
 * DAY_NAME_FULL:星期日
 * DESCRIPTION:On the description and function of the document
 **/
public class L {

    public static final String TAG="Log Info : ";
    public static boolean debug=true;

    public static void g(String msg){
        if (debug){
            Log.e(TAG,msg);
        }
    }


    public static void g(String tag,String msg){
        if (debug){
            Log.e(TAG,tag+":=:"+msg);
        }
    }

    public static void a(Object[] msg){
        if (debug){
            for (Object obj:msg) {
                Log.e(TAG,""+obj.toString());
            }

        }
    }


    public static void a(String tag,Object[] msg){
        if (debug){
            for (Object obj:msg) {
                Log.e(TAG,tag+":=:"+obj.toString());
            }

        }
    }

}
