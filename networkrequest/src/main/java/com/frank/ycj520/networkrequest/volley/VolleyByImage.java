package com.frank.ycj520.networkrequest.volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

public class VolleyByImage {

    /*
    第三/四个参数用于指定允许图片最大的宽/高，若网络图片的实际宽高大于该设定值，则会对图片进行压缩，指定成0的话就表示不进行压缩。
    第五个参数用于指定图片的颜色属性，Bitmap.Config下的几个常量都可以在这里使用，其中ARGB_8888可以展示最好的颜色属性，
    每个图片像素占据4个字节的大小，而RGB_565则表示每个图片像素占据2个字节大小。
     */
    public static void loadImageByImageRequest(Context context, String url, Response.Listener<Bitmap> responseListener, Response.ErrorListener errorListener){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        ImageRequest imageRequest = new ImageRequest(url, responseListener, 0, 0, Bitmap.Config.RGB_565,errorListener);
        mQueue.add(imageRequest);

    }

    //查看ImageRequest的源码发现它可以设置你想要的图片的最大宽度和高度，在加载图片时如果图片超过期望的最大宽度和高度则会进行压缩
    public static void loadImageByImageRequest(Context context,String url,Response.Listener<Bitmap> responseListener,int maxWidth, int maxHeight,Response.ErrorListener errorListener){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        ImageRequest imageRequest = new ImageRequest(url, responseListener, maxWidth, maxHeight, Bitmap.Config.RGB_565,errorListener);
        mQueue.add(imageRequest);

    }

    //查看ImageRequest的源码发现它可以设置你想要的图片的最大宽度和高度，在加载图片时如果图片超过期望的最大宽度和高度则会进行压缩
    public static void loadImageByImageRequest(Context context, String url, final ImageView imageView, int maxWidth, int maxHeight, Response.ErrorListener errorListener){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        ImageRequest imageRequest = new ImageRequest(
                url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                    }
                }, maxWidth, maxHeight, Bitmap.Config.RGB_565, errorListener);
        mQueue.add(imageRequest);

    }

    //查看ImageRequest的源码发现它可以设置你想要的图片的最大宽度和高度，在加载图片时如果图片超过期望的最大宽度和高度则会进行压缩
    public static void loadImageByImageRequest(Context context, String url, final ImageView imageView, Response.ErrorListener errorListener){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        ImageRequest imageRequest = new ImageRequest(
                url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, errorListener);
        mQueue.add(imageRequest);

    }

    //ImageLoader的内部使用ImageRequest来实现，它的构造器可以传入一个ImageCache缓存形参，实现了图片缓存的功能，同时还可以过滤重复链接，避免重复发送请求。
    //与ImageRequest实现效果不同的是，ImageLoader加载图片会先显示默认的图片，等待图片加载完成才会显示在ImageView上。
    public static void loadImageByImageLoader(Context context,String url,ImageView imageView, final int defaultImageResId, final int errorImageResId){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageView,defaultImageResId, errorImageResId);
        imageLoader.get(url, listener);
    }

    public static void loadImageByImageLoader(Context context,String url,ImageView imageView,int maxWidth, int maxHeight,final int defaultImageResId, final int errorImageResId){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageView,defaultImageResId, errorImageResId);
        imageLoader.get(url, listener);
        imageLoader.get(url,listener, maxWidth, maxHeight);
    }


    public static void loadImageByNetworkImageView(Context context, String url, NetworkImageView networkImageView, final int defaultImageResId, final int errorImageResId){
        RequestQueue mQueue= Volley.newRequestQueue(context);
        ImageLoader imageLoader=new ImageLoader(mQueue,new BitmapCache());
        networkImageView.setDefaultImageResId(defaultImageResId);//加载中显示的图片
        networkImageView.setErrorImageResId(errorImageResId);//加载错误时显示的图片
        networkImageView.setImageUrl(url,imageLoader);
    }

}
