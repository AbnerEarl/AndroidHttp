package com.frank.ycj520.networkrequest.rxjava;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.callback.RxFileCallBack;
import com.tamic.novate.callback.RxStringCallback;
import com.tamic.novate.download.DownLoadCallBack;
import com.tamic.novate.request.NovateRequestBody;

import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class RxJavaByUploadDownload {


    public static final String MULTIPART_FORM_DATA = "multipart/form-data";

    @NonNull
    private static RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), descriptionString);
    }

    @NonNull
    private static MultipartBody.Part prepareFilePart(String partName, String fileName) {
        File file =new File(fileName);
        // 为file建立RequestBody实例
        RequestBody requestFile = RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file);
        // MultipartBody.Part借助文件名完成最终的上传
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }

    public static void uploadByImage(Activity activity, String baseUrl, String pathUrl, RequestBody requestFile , BaseSubscriber<ResponseBody> responseCallback){

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.upload(pathUrl, requestFile, responseCallback );
    }

    public static void uploadByImage(Activity activity,String baseUrl,String pathUrl,String filePath, BaseSubscriber<ResponseBody> responseCallback){
        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        File file = new File(filePath);
        novate.uploadImage(pathUrl, file, responseCallback );

    }

    public static void uploadBySingleFile(Activity activity, String baseUrl,String pathUrl,RequestBody requestFile , BaseSubscriber<ResponseBody> responseCallback){

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.uploadFlie(pathUrl, requestFile, responseCallback );
    }

    public static void uploadByMutipleFile(Activity activity, String baseUrl, String pathUrl, Map<String, RequestBody> mapFiles , BaseSubscriber<ResponseBody> responseCallback){

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.uploadFlies(pathUrl, mapFiles, responseCallback );
    }

    public static void uploadByBodyTextFile(Activity activity, String baseUrl,String pathUrl, RequestBody requestBody , BaseSubscriber<ResponseBody> responseCallback){

       /* RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("name", "tamic")
                .addFormDataPart("pawww.edu800.cnssword", "12345")
                .addFormDataPart("atavr", file.getName(), Utils.createImage(mfile))
                .build();*/
        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.upload(pathUrl, requestBody, responseCallback );
    }

    public static void uploadByPartTextFile(Activity activity, String baseUrl,String pathUrl,String fileName,String pathName,String descriptions, BaseSubscriber<ResponseBody> responseCallback){

       /*  MultipartBody.Part body = Utils.createPart("key", file);
        String descriptionString = "文件描述";
        RequestBody description = Utils.createPartFromString(descriptionString);*/
        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        MultipartBody.Part body  = prepareFilePart(fileName, pathName);
        RequestBody descriptionString = createPartFromString(descriptions);
        // 执行
        novate.uploadFlie(pathUrl,descriptionString,body,responseCallback);
    }

    public static void downloadBigFile(Activity activity,String baseUrl,String pathUrl,DownLoadCallBack downLoadCallBack){
        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.download(pathUrl,downLoadCallBack);
    }

    public static void downloadBigFileAndName(Activity activity,String baseUrl,String pathUrl,String fileName,DownLoadCallBack downLoadCallBack){
        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.download(pathUrl,fileName,downLoadCallBack);
    }

    public static void downloadBigFileAndPath(Activity activity,String baseUrl,String pathUrl,String key,String savePath,String fileName,DownLoadCallBack downLoadCallBack){
        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.download(key,pathUrl,savePath,fileName,downLoadCallBack);
    }

    public static void downloadMinFile(Activity activity,String baseUrl,String pathUrl,DownLoadCallBack downLoadCallBack){
        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.downloadMin(pathUrl,downLoadCallBack);
    }


    public static void downloadMinFileAndName(Activity activity,String baseUrl,String pathUrl,String fileName,DownLoadCallBack downLoadCallBack){
        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.downloadMin(pathUrl,fileName,downLoadCallBack);
    }

    public static void downloadMinFileAndPath(Activity activity,String baseUrl,String pathUrl,String key,String savePath,String fileName,DownLoadCallBack downLoadCallBack){
        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.downloadMin(key,pathUrl,savePath,fileName,downLoadCallBack);
    }



    public static void uploadByRxUploadWithPartAndKey(Activity activity, String baseUrl,String description, NovateRequestBody requestBody , String pathUrl, String filePath,String fileName, BaseSubscriber<ResponseBody> responseCallback){

       /* RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data; charset=utf-8"), file);
        final NovateRequestBody requestBody = Utils.createNovateRequestBody(requestFile, new UpLoadCallback() {

            @Override
            public void onProgress(Object tag, int progress, long speed, boolean done) {

                updateProgressDialog(progress);
            }
        });*/

        Novate novate = new Novate.Builder(activity)
                .baseUrl(baseUrl)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        File file = new File(filePath);

        MultipartBody.Part body = MultipartBody.Part.createFormData(fileName, file.getName(), requestBody);
        RequestBody descriptionString = createPartFromString(description);
        novate.uploadFlie(pathUrl,descriptionString, body, responseCallback);


    }



    public static void downloadByRxGet(Activity activity,String pathUrl,Map<String,Object> parameters,RxFileCallBack rxFileCallBack){
        Novate novate = new Novate.Builder(activity)
                .addCookie(false)  //是否同步cooike 默认不同步
                .addCache(false)  //是否缓存 默认缓存
                .addLog(true)
                .connectTimeout(500000)
                .writeTimeout(500000)
                .build();
        novate.rxGet(pathUrl, parameters, rxFileCallBack);

    }
}
