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
 1.Okhttp
 
  输入这一行代码：
  
 OkhttpByPost.postFile("http://www.baidu.com","/mnt/TestFolder/test.doc",new Callback()); 
 
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
 
 
 
 2.Volley
 
 
项目用到的权限

  3.在manifest文件中添加访问的权限：
 
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
