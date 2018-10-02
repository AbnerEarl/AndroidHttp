package com.frank.ycj520.networkrequest.okhttp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import com.frank.ycj520.networkrequest.utils.ShowImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class OkhttpByPost {

    //Post 键值对
    public static void postParameter(String url,String name,String value,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        //构建FormBody，传入要提交的参数
        FormBody formBody = new FormBody.Builder()
                .add(name, value)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void postParameterAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String name,String value,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        //构建FormBody，传入要提交的参数
        FormBody formBody = new FormBody.Builder()
                .add(name, value)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    //Post 键值对
    public static void postParameter(String url,String name1,String value1,String name2,String value2,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        //构建FormBody，传入要提交的参数
        FormBody formBody = new FormBody.Builder()
                .add(name1, value1)
                .add(name2, value2)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void postParameterAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String name1,String value1,String name2,String value2,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        //构建FormBody，传入要提交的参数
        FormBody formBody = new FormBody.Builder()
                .add(name1, value1)
                .add(name2, value2)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    //Post 键值对
    public  static void postParameter(String url,String name1,String value1,String name2,String value2,String name3,String value3,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        //构建FormBody，传入要提交的参数
        FormBody formBody = new FormBody.Builder()
                .add(name1, value1)
                .add(name2, value2)
                .add(name3, value3)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }


    public  static void postParameterAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String name1,String value1,String name2,String value2,String name3,String value3,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        //构建FormBody，传入要提交的参数
        FormBody formBody = new FormBody.Builder()
                .add(name1, value1)
                .add(name2, value2)
                .add(name3, value3)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }


    //Post 字符串
    public static void postString(String url,String content,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        //RequestBody中的MediaType指定为纯文本，编码方式是utf-8
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"),
                content);
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void postStringAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String content,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        //RequestBody中的MediaType指定为纯文本，编码方式是utf-8
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"),
                content);
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    //Post 表单
    public static void postForm(String url,String name,String value,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name, value)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void postFormAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String name,String value,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name, value)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    //Post 表单
    public static void postForm(String url,String name1,String value1,String name2,String value2,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name1, value1)
                .addFormDataPart(name2, value2)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void postFormAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String name1,String value1,String name2,String value2,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name1, value1)
                .addFormDataPart(name2, value2)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    //Post 表单
    public static void postForm(String url,String name1,String value1,String name2,String value2,String name3,String value3,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name1, value1)
                .addFormDataPart(name2, value2)
                .addFormDataPart(name3, value3)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void postFormAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String name1,String value1,String name2,String value2,String name3,String value3,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name1, value1)
                .addFormDataPart(name2, value2)
                .addFormDataPart(name3, value3)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    //Post 文件流
    public static void postStreamingFile(String url, final String pathName, final Callback callback) {
        final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MEDIA_TYPE_MARKDOWN;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                FileInputStream fio= new FileInputStream(new File(pathName));
                byte[] buffer = new byte[1024*8];
                if(fio.read(buffer) != -1){
                    sink.write(buffer);
                }
            }


        };
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }


    public static void postStreamingFileAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue, final String pathName, final Callback callback) {
        final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MEDIA_TYPE_MARKDOWN;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                FileInputStream fio= new FileInputStream(new File(pathName));
                byte[] buffer = new byte[1024*8];
                if(fio.read(buffer) != -1){
                    sink.write(buffer);
                }
            }


        };
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    //Post 字符流
    public static void postStreamingString(String url, final String content, final Callback callback) {
        final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MEDIA_TYPE_MARKDOWN;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.writeUtf8(content);
            }


        };
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }


    public static void postStreamingStringAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue, final String content, final Callback callback) {
        final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MEDIA_TYPE_MARKDOWN;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.writeUtf8(content);
            }


        };
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    //Post 文件
    public static void postFile(String url,String pathName,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
        File file = new File(pathName);
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void postFileAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String pathName,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
        File file = new File(pathName);
        Request request = new Request.Builder()
                .url(url)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    //Post Json
    public static void postJson(String url,String jsonStr,final Callback callback) {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");//数据类型为json格式，
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);

    }

    public static void postJsonAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String jsonStr,final Callback callback) {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");//数据类型为json格式，
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);

    }

    //Post 上传文件
    public static void uploadFile(String url,String pathName,final Callback callback) {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        MediaType fileType = MediaType.parse("File/*");//数据类型为json格式，
        File file = new File(pathName);//file对象.
        RequestBody body = RequestBody.create(fileType , file );
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);

    }

    public static void uploadFileAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String pathName,final Callback callback) {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        MediaType fileType = MediaType.parse("File/*");//数据类型为json格式，
        File file = new File(pathName);//file对象.
        RequestBody body = RequestBody.create(fileType , file );
        Request request = new Request.Builder()
                .url(url)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);

    }

    //Post 上传参数和文件
    public static void uploadParametersAndFile(String url,String name,String value,String pathName,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        File file = new File(pathName);//file对象.
        MultipartBody multipartBody =new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name,value)//添加键值对参数
                .addFormDataPart("file",file.getName(),RequestBody.create(MediaType.parse("file/*"), file))//添加文件
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(multipartBody)
                .build();
        client.newCall(request).enqueue(callback);

    }

    public static void uploadParametersAndFileAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String name,String value,String pathName,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        File file = new File(pathName);//file对象.
        MultipartBody multipartBody =new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name,value)//添加键值对参数
                .addFormDataPart("file",file.getName(),RequestBody.create(MediaType.parse("file/*"), file))//添加文件
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .post(multipartBody)
                .build();
        client.newCall(request).enqueue(callback);

    }

    //Post 上传参数和文件
    public static void uploadParametersAndFile(String url,String name1,String value1,String name2,String value2,String pathName,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        File file = new File(pathName);//file对象.
        MultipartBody multipartBody =new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name1,value1)//添加键值对参数
                .addFormDataPart(name2,value2)//添加键值对参数
                .addFormDataPart("file",file.getName(),RequestBody.create(MediaType.parse("file/*"), file))//添加文件
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(multipartBody)
                .build();
        client.newCall(request).enqueue(callback);

    }


    public static void uploadParametersAndFileAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String name1,String value1,String name2,String value2,String pathName,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        File file = new File(pathName);//file对象.
        MultipartBody multipartBody =new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name1,value1)//添加键值对参数
                .addFormDataPart(name2,value2)//添加键值对参数
                .addFormDataPart("file",file.getName(),RequestBody.create(MediaType.parse("file/*"), file))//添加文件
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .post(multipartBody)
                .build();
        client.newCall(request).enqueue(callback);

    }

    //Post 上传参数和文件
    public static void uploadParametersAndFile(String url,String name1,String value1,String name2,String value2,String name3,String value3,String pathName,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        File file = new File(pathName);//file对象.
        MultipartBody multipartBody =new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name1,value1)//添加键值对参数
                .addFormDataPart(name2,value2)//添加键值对参数
                .addFormDataPart(name3,value3)//添加键值对参数
                .addFormDataPart("file",file.getName(),RequestBody.create(MediaType.parse("file/*"), file))//添加文件
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(multipartBody)
                .build();
        client.newCall(request).enqueue(callback);

    }

    public static void uploadParametersAndFileAddHeader(String url,String headerName,String headerValue,String tokenName,String tokenValue,String name1,String value1,String name2,String value2,String name3,String value3,String pathName,final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        File file = new File(pathName);//file对象.
        MultipartBody multipartBody =new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(name1,value1)//添加键值对参数
                .addFormDataPart(name2,value2)//添加键值对参数
                .addFormDataPart(name3,value3)//添加键值对参数
                .addFormDataPart("file",file.getName(),RequestBody.create(MediaType.parse("file/*"), file))//添加文件
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .header(headerName, headerValue)
                .addHeader(tokenName, tokenValue)
                .post(multipartBody)
                .build();
        client.newCall(request).enqueue(callback);

    }

    //下载图片
    public static void downloadImage(String url, final String pathName) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request
                .Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inputStream = response.body().byteStream();
                //将图片保存到本地存储卡中
                //File file = new File(Environment.getExternalStorageDirectory(), "image.png");
                File file = new File(pathName);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] temp = new byte[128];
                int length;
                while ((length = inputStream.read(temp)) != -1) {
                    fileOutputStream.write(temp, 0, length);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
            }
        });
    }


    //下载图片
    public static void downImage(String url, final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request
                .Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }


    //加载图片
    public static void showdownImage(String url, final Activity activity, final ImageView imageView) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request
                .Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inputStream = response.body().byteStream();
                //将图片显示到ImageView中
                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                ShowImage.showImageByBitmap(activity,imageView,bitmap);

            }
        });
    }

}
