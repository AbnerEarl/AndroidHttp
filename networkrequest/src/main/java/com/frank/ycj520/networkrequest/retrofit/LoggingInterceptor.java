package com.frank.ycj520.networkrequest.retrofit;

import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

public class LoggingInterceptor {
    public static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {

                    @Override
                    public void log(String message) {
                        Log.e("OkHttp", "log = " + message);
                    }

                });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}
