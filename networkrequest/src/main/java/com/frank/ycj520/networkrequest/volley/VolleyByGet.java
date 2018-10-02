package com.frank.ycj520.networkrequest.volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.frank.ycj520.networkrequest.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Map;

public class VolleyByGet {


    /*
    安全连接：
    方法一：
    使用证书进行构建连接如下：

    RequestQueue requestQueue =Volley.newRequestQueue(getApplicationContext());//使用https连接
    或者
    SSLSocketFactory sslSocketFactory =initSSLSocketFactory();
    HurlStack stack = new HurlStack(null,sslSocketFactory);
    RequestQueue requestQueue =Volley.newRequestQueue(mContext, stack);

    方法二：
    在创建请求Request对象前加上一行代码：SsX509TrustManager.allowAllSSL();即可，如：
    RequestQueue requestQueue =Volley.newRequestQueue(getApplicationContext());
    SsX509TrustManager.allowAllSSL();
    StringRequest stringRequest = newStringRequest(Request.Method.GET, "https://kyfw.12306.cn/otn/regist/init",
       new Response.Listener<String>() {
           @Override
           public void onResponse(String s) {
                // 请求成功
           }
       },
       new Response.ErrorListener() {
            @Override
           public void onErrorResponse(VolleyError volleyError) {
                // 请求失败
           }
       });
    requestQueue.add(stringRequest);

     */


    public static void requestByGet(Context context,String url,Response.Listener<String> responseListener,Response.ErrorListener errorListener){
        //创建请求队列
        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest mStringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);
        //将请求添加在请求队列中
        mQueue.add(mStringRequest);

    }

    public static void requestByGetAddHeaders(Context context,String url,final Map<String, String> mapHeaders,Response.Listener<String> responseListener,Response.ErrorListener errorListener){
        //创建请求队列
        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest mStringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return mapHeaders;
            }
        };
        //将请求添加在请求队列中
        mQueue.add(mStringRequest);

    }

    public static void requestByTag(Context context, String url, Response.Listener<String> listener, Response.ErrorListener errorListener, Object tag) {
        RequestQueue mQueue = Volley.newRequestQueue(context);
        MyStringRequest request = new MyStringRequest(Request.Method.GET, url, listener, errorListener);
        request.setTag(tag);
        mQueue.add(request);
    }

    public static void requestByTagAddHeaders(Context context, String url,final Map<String, String> mapHeaders, Response.Listener<String> listener, Response.ErrorListener errorListener, Object tag) {
        RequestQueue mQueue = Volley.newRequestQueue(context);
        MyStringRequest request = new MyStringRequest(Request.Method.GET, url, listener, errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return mapHeaders;
            }
        };
        request.setTag(tag);
        mQueue.add(request);
    }

    public static void requestByPostJSONObject(Context context,String url, Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener){
        final RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,(String)null,responseListener,errorListener);
        mQueue.add(jsonObjectRequest);

    }

    public static void requestByPostJSONObjectAddHeaders(Context context,String url,final Map<String, String> mapHeaders,Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener){
        final RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,(String)null,responseListener,errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return mapHeaders;
            }
        };
        mQueue.add(jsonObjectRequest);

    }

    public static void requestByPostJSONArray(Context context, String url, Response.Listener<JSONArray> responseListener, Response.ErrorListener errorListener){
        //队列初始化以及request加入队列略
        RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url,responseListener,errorListener);
        mQueue.add(jsonArrayRequest);
    }

    public static void requestByPostJSONArrayAddHeaders(Context context, String url,final Map<String, String> mapHeaders, Response.Listener<JSONArray> responseListener, Response.ErrorListener errorListener){
        //队列初始化以及request加入队列略
        RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url,responseListener,errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return mapHeaders;
            }
        };
        mQueue.add(jsonArrayRequest);
    }

    public static void requestByGetJson(Context context,String url,Response.Listener<JSONObject> responseListener,Response.ErrorListener errorListener){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url ,responseListener,errorListener
        );
        mQueue.add(mJsonObjectRequest);

    }

    public static void requestByGetJsonAddHeaders(Context context,String url,final Map<String, String> mapHeaders,Response.Listener<JSONObject> responseListener,Response.ErrorListener errorListener){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url ,responseListener,errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return mapHeaders;
            }
        };
        mQueue.add(mJsonObjectRequest);

    }



    //自定义xml解析
    public static void requestByXmlRequest(Context context,String url,Response.Listener<XmlPullParser> responseListener,Response.ErrorListener errorListener){
        RequestQueue mQueue= Volley.newRequestQueue(context);
        XMLRequest xmlr=new XMLRequest(url,responseListener,errorListener);
        mQueue.add(xmlr);
    }
}
