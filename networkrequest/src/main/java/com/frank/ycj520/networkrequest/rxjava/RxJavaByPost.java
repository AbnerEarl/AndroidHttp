package com.frank.ycj520.networkrequest.rxjava;

import android.app.Activity;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.callback.RxListCallback;
import com.tamic.novate.callback.RxStringCallback;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Observer;

public class RxJavaByPost {

     /*
    Novate构建方法及参数含义：
    novate = new Novate.Builder(this)
                .addHeader(headers) //添加公共请求头
                .addParameters(parameters)//公共参数
                .connectTimeout(10)  //连接时间 可以忽略
                .readTimeout(10)  //读取 可以忽略
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(true)  //是否缓存 默认缓存
                .addCache(cache, cacheTime)   //自定义缓存
                .baseUrl("Url") //base URL
                .addLog(true) //是否开启log
                .cookieManager(new NovateCookieManager()) // 自定义cooike，可以忽略
                .addInterceptor() // 自定义Interceptor
                .addNetworkInterceptor() // 自定义NetworkInterceptor
                .proxy(proxy) // 设置代理
                .client(client)  //clent 默认不需要
                .build();
     */

    public static void PostString(final Activity activity,final String baseUrl, final String urlPath,final Map<String, Object> parameter, final RxStringCallback rxStringCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(urlPath, parameter, rxStringCallback);
    }

    public static void PostStringCookie(final Activity activity,final String baseUrl, final String urlPath,final Map<String, Object> parameter, final RxStringCallback rxStringCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(true)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(urlPath, parameter, rxStringCallback);
    }

    public static void PostStringCache(final Activity activity,final String baseUrl, final String urlPath,final Map<String, Object> parameter, final RxStringCallback rxStringCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(true)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(urlPath, parameter, rxStringCallback);
    }

    public static void PostStringCookieCache(final Activity activity,final String baseUrl, final String urlPath,final Map<String, Object> parameter, final RxStringCallback rxStringCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(true)  //是否同步cooike 默认不同步
                .addCache(true)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(urlPath, parameter, rxStringCallback);
    }

    public static void PostStringAddHeaders(final Activity activity,final String baseUrl, final String urlPath,  final Map<String, Object> headers,final Map<String, Object> parameter, final RxStringCallback rxStringCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addHeader(headers)//添加公共请求头
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(urlPath, parameter, rxStringCallback);
    }
    public static void PostStringAddHeadersCookie(final Activity activity,final String baseUrl, final String urlPath,  final Map<String, Object> headers,final Map<String, Object> parameter, final RxStringCallback rxStringCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addHeader(headers)//添加公共请求头
                .addCookie(true)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(urlPath, parameter, rxStringCallback);
    }

    public static void PostStringAddHeadersCache(final Activity activity,final String baseUrl, final String urlPath,  final Map<String, Object> headers,final Map<String, Object> parameter, final RxStringCallback rxStringCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addHeader(headers)//添加公共请求头
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(true)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(urlPath, parameter, rxStringCallback);
    }

    public static void PostStringAddHeadersCookieCache(final Activity activity,final String baseUrl, final String urlPath,  final Map<String, Object> headers,final Map<String, Object> parameter, final RxStringCallback rxStringCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addHeader(headers)//添加公共请求头
                .addCookie(true)  //是否同步cooike 默认不同步
                .addCache(true)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(urlPath, parameter, rxStringCallback);
    }


    public static void PostList(Activity activity,String baseUrl, String pathUrl,Map<String, Object> parameter, RxListCallback<List<Object>> rxListCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(pathUrl, parameter, rxListCallback );
    }
    public static void PostListCookie(Activity activity,String baseUrl, String pathUrl,Map<String, Object> parameter, RxListCallback<List<Object>> rxListCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(true)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(pathUrl, parameter, rxListCallback );
    }
    public static void PostListCache(Activity activity,String baseUrl, String pathUrl,Map<String, Object> parameter, RxListCallback<List<Object>> rxListCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(true)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(pathUrl, parameter, rxListCallback );
    }
    public static void PostListCookieCache(Activity activity,String baseUrl, String pathUrl,Map<String, Object> parameter, RxListCallback<List<Object>> rxListCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(true)  //是否同步cooike 默认不同步
                .addCache(true)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(pathUrl, parameter, rxListCallback );
    }



    public static void PostListAddHeaders(Activity activity,String baseUrl, String pathUrl, final Map<String, Object> headers,Map<String, Object> parameter, RxListCallback<List<Object>> rxListCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addHeader(headers)//添加公共请求头
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(pathUrl, parameter, rxListCallback );
    }

    public static void PostListAddHeadersCookie(Activity activity,String baseUrl, String pathUrl, final Map<String, Object> headers,Map<String, Object> parameter, RxListCallback<List<Object>> rxListCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addHeader(headers)//添加公共请求头
                .addCookie(true)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(pathUrl, parameter, rxListCallback );
    }

    public static void PostListAddHeadersCache(Activity activity,String baseUrl, String pathUrl, final Map<String, Object> headers,Map<String, Object> parameter, RxListCallback<List<Object>> rxListCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addHeader(headers)//添加公共请求头
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(true)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(pathUrl, parameter, rxListCallback );
    }

    public static void PostListAddHeadersCookieCache(Activity activity,String baseUrl, String pathUrl, final Map<String, Object> headers,Map<String, Object> parameter, RxListCallback<List<Object>> rxListCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addHeader(headers)//添加公共请求头
                .addCookie(true)  //是否同步cooike 默认不同步
                .addCache(true)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxPost(pathUrl, parameter, rxListCallback );
    }


    public static void requestByBody(final Activity activity,final String baseUrl, final String urlPath,Object body, BaseSubscriber<ResponseBody> responseCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.body(urlPath,body,responseCallback);
    }

    public static void requestByJson(final Activity activity,final String baseUrl, final String urlPath,String jsonString, BaseSubscriber<ResponseBody> responseCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.json(urlPath,jsonString,responseCallback);
    }

    public static void requestByForm(final Activity activity,final String baseUrl, final String urlPath,Map<String,Object> data, BaseSubscriber<ResponseBody> responseCallback) {

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.form(urlPath,data,responseCallback);
    }



    public static void requestByObserver(Observer<String> observer, Observable.OnSubscribe<String> stringOnSubscribe ){
        //使用Observable.create()创建被观察者
        Observable observable1 = Observable.create(stringOnSubscribe);
        //订阅
        observable1.subscribe(observer);
    }
}
