package com.frank.ycj520.networkrequest.retrofit;

import android.database.Observable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitByGet {

    public static void requestByGet(String url, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.requestByGet(url);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }


    public static  void requestByGetAddToken(String token,String url, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.requestByGetAddToken(token,url);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static  void requestByGetAddHeaders(Map<String ,String > mapHeaders,String url, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.requestByGetAddHeaders(mapHeaders,url);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }


    //文件下载by call
    public static void downloadFileByCall(String url, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.downloadFileByCall(url);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    //文件下载by Observable
    public static Observable downloadFileByObservable(String url, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Observable<ResponseBody> observable=request.downloadFileByObservable(url);
        return  observable;
    }


}
