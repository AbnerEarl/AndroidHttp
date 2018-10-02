# AndroidHttp

一个整合OkHttp 、Retrofit 、Volley 、RxJava、Novate多种开源网络框架的项目，对网络请求框架和方法进行了高度的封装和集成，让网络请求更加简洁、简单，只需要一行代码就完成。

# 使用方法

方法一：

1.第一步，在项目的build.gradle下配置，注意是项目的build.gradle：

     allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
        }
     }
    
    
2.第二步,在app的build.gradle下添加如下依赖：

    dependencies {
            ...
            compile 'com.github.Brioal:Test:1.0'
            ...
     }
    
    
方法二：
    
 1.第一步，下载依赖的包：https://github.com/YouAreOnlyOne/AndroidHttp/edit/master/README.md 。并放到项目的 libs 目录下面。
    
 2.第二步,在app的build.gradle下添加如下依赖，注意，两个依赖是平级关系：
    
    repositories {
       flatDir {
           dirs 'libs'
         }
    }
    
    dependencies {
            ...
            compile(name:'mylibrary-debug', ext:'aar')
            ...
    }
 
 
# 使用示例：

由于每个框架集成和封装的方法有很对，这里只是随意挑选一个做演示，具体方法和目录见本文后面。

 1.Okhttp
 
  (1)输入这一行代码：
  
            OkhttpByPost.postFile("http://www.baidu.com","/mnt/TestFolder/test.doc", new Callback()); 
 
然后按 Alt+Enter 键，选择 implement methods，自动生成如下代码：

           OkhttpByPost.postFile("http://www.baidu.com","/mnt/TestFolder/test.doc", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                 ...
                 //请求失败的逻辑处理
                 ...
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                  ...
                  //请求成功的逻辑处理
                  ...
            }
        });
 
  (2)输入这一行代码：
  
            OkhttpByPost.postFileAddHeader("http://www.baidu.com", headerName, headerValue, tokenName, tokenValue, "/mnt/TestFolder/test.doc", new Callback()); 
 
然后按 Alt+Enter 键，选择 implement methods，自动生成如下代码：

           OkhttpByPost.postFileAddHeader("http://www.baidu.com", headerName, headerValue, tokenName, tokenValue, "/mnt/TestFolder/test.doc", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                 ...
                 //请求失败的逻辑处理
                 ...
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                  ...
                  //请求成功的逻辑处理
                  ...
            }
        });
 
 
 
 2.Volley
 
   输入这一行代码：
  
            VolleyByImage.loadImageByImageRequest(this,"http://baidu.com", imageView,new Response.ErrorListener());
 
   然后按 Alt+Enter 键，选择 implement methods，自动生成如下代码：
            
            VolleyByImage.loadImageByImageRequest(this, "http://baidu.com", imageView, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                         ...
                         //图片加载错误的逻辑处理
                         ...
                    }
                });
 
 3.RxJava
 
  输入这一行代码：
  
            RxJavaByPost.PostString(this, "http://www.baidu.com/", "fanyi/china", parameters, new RxStringCallback());
 
   然后按 Alt+Enter 键，选择 implement methods，自动生成如下代码：
            RxJavaByPost.PostString(this, "http://www.baidu.com/", "fanyi/china", parameters, new RxStringCallback() {
            @Override
            public void onNext(Object tag, String response) {
               ...
               //网络请求成功返回的结果逻辑处理
               ...
            }

            @Override
            public void onError(Object tag, Throwable e) {
               ...
               //网络请求错误返回的结果逻辑处理
              ...
            }

            @Override
            public void onCancel(Object tag, Throwable e) {
                ...
                //网络请求取消返回的结果逻辑处理
                ...
            }
        });
 
 
# 项目用到的权限

  在manifest文件中添加访问的权限：
 
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
   
# 项目用到的三方依赖

    在app的build.gradle下添加如下依赖：
    
    android {
      packagingOptions {
           exclude 'META-INF/LICENSE'
           exclude 'META-INF/NOTICE'
           exclude 'META-INF/rxjava.properties'
         }
      ...
      ...
     }
    
     dependencies {
            ...
            implementation 'com.squareup.okhttp3:okhttp:3.11.0'
            testImplementation 'com.squareup.okhttp3:mockwebserver:3.11.0'
            implementation 'com.squareup.retrofit2:retrofit:2.4.0'
            implementation 'com.mcxiaoke.volley:library:1.0.19'
            implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
            implementation 'io.reactivex.rxjava2:rxjava:2.1.0'
            implementation 'com.tamic.novate:novate:1.5.2.3'
            ...
     }
    
