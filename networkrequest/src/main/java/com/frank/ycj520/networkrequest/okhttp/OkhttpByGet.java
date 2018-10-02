package com.frank.ycj520.networkrequest.okhttp;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpByGet {

    public static Response getDataSync(String url) {
        Response response=null;
        try {
            //创建OkHttpClient对象
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15,TimeUnit.SECONDS)
                    .writeTimeout(15,TimeUnit.SECONDS)
                    .build();
            Request request = new Request.Builder()
                    .url(url)//请求接口。如果需要传参拼接到接口后面。
                    .build();//创建Request 对象
            response = client.newCall(request).execute();//得到Response对象

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public static Response getDataSyncAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue) {
        Response response=null;
        try {
            //创建OkHttpClient对象
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15,TimeUnit.SECONDS)
                    .writeTimeout(15,TimeUnit.SECONDS)
                    .build();
            Request request = new Request.Builder()
                    .url(url)//请求接口。如果需要传参拼接到接口后面。
                    .header(headerName, headerValue)
                    .addHeader(tokenName, tokenValue)
                    .build();//创建Request 对象
            response = client.newCall(request).execute();//得到Response对象

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


    public static void getDataAsync(String url,final Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void getDataAsyncAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,final Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .build();
        client.newCall(request).enqueue(callback);
    }




}
