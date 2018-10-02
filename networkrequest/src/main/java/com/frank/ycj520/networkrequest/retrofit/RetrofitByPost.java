package com.frank.ycj520.networkrequest.retrofit;

import android.database.Observable;
import android.support.annotation.NonNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitByPost {
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

    public static void requestByPostByQueryMap(String url,Map<String, String> queryMap, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.requestByPostByQueryMap(url,queryMap);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByPostByQueryMapAddToken(String url,String token,Map<String, String> queryMap, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.requestByPostByQueryMap(token,url,queryMap);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByPostByQueryMapAddHeaders(Map<String ,String > mapHeaders,String url,Map<String, String> queryMap, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.requestByPostByQueryMap(mapHeaders,url,queryMap);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static Observable requestByPostByFieldMap(String url,Map<String, Object> maps, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Observable<ResponseBody> observable = request.requestByPostByFieldMap(url,maps);
        return observable;
    }

    public static Observable requestByPostByFieldMapAddToken(String token,String url,Map<String, Object> maps, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Observable<ResponseBody> observable = request.requestByPostByFieldMap(token,url,maps);
        return observable;
    }

    public static Observable requestByPostByFieldMapAddHeaders(Map<String ,String > mapHeaders,String url,Map<String, Object> maps, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Observable<ResponseBody> observable = request.requestByPostByFieldMap(mapHeaders,url,maps);
        return observable;
    }

    public static void requestByPost(String url,Object objectBean, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.requestByPost(url,objectBean);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByPostAddToken(String token,String url,Object objectBean, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.requestByPost(token,url,objectBean);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByPostAddHeaders(Map<String ,String > mapHeaders,String url,Object objectBean, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.requestByPost(mapHeaders,url,objectBean);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }


    public static void uploadSingleFile(String url,String fileName,String pathName, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MultipartBody.Part file = prepareFilePart(fileName, pathName);
        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.uploadSingleFile(url,file);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void uploadMutipleFiles(String url,String []fileName,String []pathName, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //MultipartBody.Part[] files=new MultipartBody.Part[pathName.length];
        Map<String, MultipartBody.Part> mapFiles=new HashMap<>();
        for (int i=0;i<pathName.length&&i<fileName.length;i++){
            //files[i] = prepareFilePart(fileName[i], pathName[i]);
            mapFiles.put(fileName[i],prepareFilePart(fileName[i], pathName[i]));
        }
        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.uploadMutipleFiles(url,mapFiles);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }


    public static void uploadMutipleFilesAndBean(String url,Object objectBean,String []fileName,String []pathName, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //MultipartBody.Part[] files=new MultipartBody.Part[pathName.length];
        Map<String, MultipartBody.Part> mapFiles=new HashMap<>();
        for (int i=0;i<pathName.length&&i<fileName.length;i++){
            //files[i] = prepareFilePart(fileName[i], pathName[i]);
            mapFiles.put(fileName[i],prepareFilePart(fileName[i], pathName[i]));
        }
        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.uploadMutipleFilesAndBean(url,objectBean,mapFiles);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByForm(String url,String name1,String name2, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.submitByForm(url,name1,name2);
        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByFormAddToken(String token,String url,String name1,String name2, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.submitByForm(token,url,name1,name2);
        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByFormAddHeaders(Map<String ,String > mapHeaders,String url,String name1,String name2, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.submitByForm(mapHeaders,url,name1,name2);
        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByFormByFieldMap(String url, Map<String, Object> map,Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.submitByFormByFieldMap(url,map);
        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByFormByFieldMapAddToken(String token,String url, Map<String, Object> map,Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.submitByFormByFieldMap(token,url,map);
        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByFormByFieldMapAddHeaders(Map<String ,String > mapHeaders,String url, Map<String, Object> map,Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.submitByFormByFieldMap(mapHeaders,url,map);
        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByFormByPartMap(String url, Map<String, RequestBody> args,Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       /* MediaType textType = MediaType.parse("text/plain");
        RequestBody name = RequestBody.create(textType, name1);
        RequestBody age = RequestBody.create(textType, name2);*/

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.submitByFormByPartMap(url,args);
        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByFormByPartMapAddToken(String token,String url, Map<String, RequestBody> args,Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       /* MediaType textType = MediaType.parse("text/plain");
        RequestBody name = RequestBody.create(textType, name1);
        RequestBody age = RequestBody.create(textType, name2);*/

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.submitByFormByPartMap(token,url,args);
        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }

    public static void requestByFormByPartMapAddHeaders(Map<String ,String > mapHeaders,String url, Map<String, RequestBody> args,Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       /* MediaType textType = MediaType.parse("text/plain");
        RequestBody name = RequestBody.create(textType, name1);
        RequestBody age = RequestBody.create(textType, name2);*/

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.submitByFormByPartMap(mapHeaders,url,args);
        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }


    public static void requestByForm(String url,String fileName,String pathName, Map<String, RequestBody> args,Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        /*MediaType textType = MediaType.parse("text/plain");
        RequestBody name = RequestBody.create(textType, "");
        RequestBody age = RequestBody.create(textType, "");*/

       /* RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"), "这里是模拟文件的内容");
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.txt", file);*/
        MultipartBody.Part filePart = prepareFilePart(fileName, pathName);

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<ResponseBody> call = request.submitByForm(url,args,filePart);
        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }


    public static void requestByForm(String url,String name1,String name2,String fileName,String pathName, Callback callback) {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);

        //  @Multipart
        RequestBody name11 = RequestBody.create(MediaType.parse("text/plain"), name1);
        RequestBody name22 = RequestBody.create(MediaType.parse("text/plain"), name2);
        MultipartBody.Part filePart = prepareFilePart(fileName, pathName);
        Call<ResponseBody> call = request.submitByForm(url,name11, name22, filePart);

        //步骤6:发送网络请求(异步)
        call.enqueue(callback);
    }







    public static void uploadSingleFiles(String url,String fileName,String pathName,String descriptions, Callback callback){

// 创建上传的service实例
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //增加返回值为Gson的支持(以实体类返回)
                // .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                // .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
// 创建文件的part (photo, video, ...)
        MultipartBody.Part body1 = prepareFilePart(fileName, pathName);

// 添加其他的part
        RequestBody description = createPartFromString(descriptions);

// 最后执行异步请求操作
        Call<ResponseBody> call = request.uploadSingleFile(description, body1);
        call.enqueue(callback);
    }



    public static void uploadDoubleFiles(String url,String fileName1,String pathName1,String fileName2,String pathName2,String descriptions, Callback callback){

// 创建上传的service实例
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //增加返回值为Gson的支持(以实体类返回)
                // .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                // .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
// 创建文件的part (photo, video, ...)
        MultipartBody.Part body1 = prepareFilePart(fileName1, pathName1);
        MultipartBody.Part body2 = prepareFilePart(fileName2, pathName2);

// 添加其他的part
        RequestBody description = createPartFromString(descriptions);

// 最后执行异步请求操作
        Call<ResponseBody> call = request.uploadDoubleFiles(description, body1, body2);
        call.enqueue(callback);
    }


    public static void uploadMultipleFiles(String url,String []fileName,String []pathName,String descriptions, Callback callback){

// 创建上传的service实例
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //增加返回值为Gson的支持(以实体类返回)
                // .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                // .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
// 创建文件的part (photo, video, ...)
        MultipartBody.Part[] bodys=new MultipartBody.Part[pathName.length];
        for (int i=0;i<pathName.length&&i<fileName.length;i++){
            bodys[i] = prepareFilePart(fileName[i], pathName[i]);
        }

// 添加其他的part
        RequestBody description = createPartFromString(descriptions);

// 最后执行异步请求操作
        Call<ResponseBody> call = request.uploadMultipleFiles(description,bodys);
        call.enqueue(callback);
    }



}
