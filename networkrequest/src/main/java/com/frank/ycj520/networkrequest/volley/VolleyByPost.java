package com.frank.ycj520.networkrequest.volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

import java.util.Map;

public class VolleyByPost {

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


    public static void requestByPostString(Context context, String url, final Map<String, String> map, Response.Listener<String> responseListener, Response.ErrorListener errorListener){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, responseListener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        mQueue.add(stringRequest);

    }

    public static void requestByPostStringAddHeaders(Context context, String url,final Map<String, String> mapHeaders, final Map<String, String> map, Response.Listener<String> responseListener, Response.ErrorListener errorListener){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, responseListener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return mapHeaders;
            }
        };
        mQueue.add(stringRequest);

    }

    public static void requestByPUT(Context context, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        RequestQueue mQueue = Volley.newRequestQueue(context);
        mQueue.add(new MyStringRequest(Request.Method.PUT, url, listener, errorListener));
    }

    public static void requestByPUTAddHeaders(Context context, String url,final Map<String, String> mapHeaders, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        RequestQueue mQueue = Volley.newRequestQueue(context);
        mQueue.add(new MyStringRequest(Request.Method.PUT, url, listener, errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return mapHeaders;
            }
        });
    }

    public static void requestByDELETE(Context context, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        RequestQueue  mQueue = Volley.newRequestQueue(context);
        mQueue.add(new MyStringRequest(Request.Method.DELETE, url, listener, errorListener));
    }

    public static void requestByDELETEAddHeaders(Context context, String url,final Map<String, String> mapHeaders, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        RequestQueue  mQueue = Volley.newRequestQueue(context);
        mQueue.add(new MyStringRequest(Request.Method.DELETE, url, listener, errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return mapHeaders;
            }
        });
    }


    public static void requestByPostJSONObject(Context context, String url,Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener){
        //队列初始化以及request加入队列略
        RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, responseListener,errorListener);
        mQueue.add(jsonObjectRequest);
    }

    public static void requestByPostJSONObjectAddHeaders(Context context, String url,final Map<String, String> mapHeaders,Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener){
        //队列初始化以及request加入队列略
        RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, responseListener,errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return mapHeaders;
            }
        };
        mQueue.add(jsonObjectRequest);
    }

    public static void requestByPostJSONObject(Context context, String url,Map<String, String> map,Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener){
        //队列初始化以及request加入队列略
        RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,url, new JSONObject(map),responseListener,errorListener);
        mQueue.add(jsonObjectRequest);
    }

    public static void requestByPostJSONObjectAddHeaders(Context context, String url, Map<String, String> mapData, final Map<String, String> mapHeaders, Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener){
        //队列初始化以及request加入队列略
        final RequestQueue mQueue = Volley.newRequestQueue(context);
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,url, new JSONObject(mapData),responseListener,errorListener) {
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
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST,url,responseListener,errorListener);
        mQueue.add(jsonArrayRequest);
    }

    public static void requestByPostJSONArrayAddHeaders(Context context, String url,final Map<String, String> mapHeaders, Response.Listener<JSONArray> responseListener, Response.ErrorListener errorListener){
        //队列初始化以及request加入队列略
        RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST,url,responseListener,errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return mapHeaders;
            }
        };
        mQueue.add(jsonArrayRequest);
    }

    public static void requestByGetJson(Context context,String url,Response.Listener<JSONObject> responseListener,Response.ErrorListener errorListener){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(Request.Method.POST,url ,responseListener,errorListener);
        mQueue.add(mJsonObjectRequest);

    }

    public static void requestByGetJsonAddHeaders(Context context,String url,final Map<String, String> mapHeaders,Response.Listener<JSONObject> responseListener,Response.ErrorListener errorListener){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(Request.Method.POST,url ,responseListener,errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return mapHeaders;
            }
        };
        mQueue.add(mJsonObjectRequest);

    }

    /*public static void requestByGsonRequest(String url, Class beanClass, Class changeClass, Response.Listener<Object> responseListener, Response.ErrorListener errorListener){
        //使用我们的GsonRequest
        GsonRequest<beanClass> gsonRequest = new GsonRequest<beanClass>(url,changeClass,responseListener,errorListener);
    }*/



    //自定义xml解析
    public static void requestByXmlRequest(Context context, String url, Response.Listener<XmlPullParser> responseListener, Response.ErrorListener errorListener){
        RequestQueue mQueue= Volley.newRequestQueue(context);
        XMLRequest xmlr=new XMLRequest(url,responseListener,errorListener);
        mQueue.add(xmlr);
    }

}
