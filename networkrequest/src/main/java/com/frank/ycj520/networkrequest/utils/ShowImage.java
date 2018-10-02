package com.frank.ycj520.networkrequest.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ShowImage {

    public static void showImageByBitmap(Activity activity, final ImageView imageView, final Bitmap bitmap){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    public static void showImageByUrl(final Activity activity,final ImageView imageView, final String url){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Glide.with(activity).load(url).into(imageView);
            }
        });
    }
}
