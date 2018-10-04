package com.frank.ycj520.networkrequest.utils;

import android.graphics.Bitmap;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * PROJECT_NAME:AndroidHttp
 * PACKAGE_NAME:com.frank.ycj520.networkrequest.utils
 * USER:Frank
 * DATE:2018/10/4
 * TIME:23:09
 * DAY_NAME_FULL:星期四
 * DESCRIPTION:On the description and function of the document
 **/
public class SaveImage {

    public static void saveBitmapFile(Bitmap bitmap, String path, String imageName){

        File temp = new File(path);
        if (!temp.exists()) {
            temp.mkdir();
        }
        //重复保存时，覆盖原同名图片
        File file=new File(path+imageName);//将要保存图片的路径和图片名称
        //    File file =  new File("/sdcard/1delete/1.png");/////延时较长
        try {
            BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
