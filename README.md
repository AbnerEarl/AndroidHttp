# AndroidHttp

一个整合OkHttp 、Retrofit 、Volley 、RxJava、Novate多种开源网络框架的项目，对网络请求框架和方法进行了高度的封装和集成，让网络请求更加简洁、简单，只需要一行代码就完成。

本项目主要根据 GET 、POST 、UPLOAD 、DOWNLOAD 四个方面进行整合，集成了数据请求、数据解析、文件上传、文件下载、图片展示等方法。重载多样化参数的构造方法，大约有近 100 个左右的常用方法。

每个方法都封装了需要参数，根据方法名结合自身需要传输的参数即可了解需要使用的方法，只需要一行代码进行调用和实现，重写逻辑处理代码即可。

# 最新版本

版本号：[![](https://www.jitpack.io/v/YouAreOnlyOne/AndroidHttp.svg)](https://www.jitpack.io/#YouAreOnlyOne/AndroidHttp)

使用自行替换下面的版本号，以获得最新版本。

# 使用方法

Android中使用：

方法一：

1.第一步，在项目的build.gradle下配置，注意是项目的build.gradle：

     allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
    
    
2.第二步,在app的build.gradle下添加如下依赖：

    dependencies {
            ...
            implementation 'com.github.YouAreOnlyOne:AndroidHttp:版本号'
            ...
     }
    
    
方法二：
    
 1.第一步，下载依赖的包：https://github.com/YouAreOnlyOne/AndroidHttp/blob/master/aar/networkrequest-release.aar 。并放到项目的 libs 目录下面。
    
 2.第二步,在app的build.gradle下添加如下依赖，注意，两个依赖是平级关系：
    
    repositories {
       flatDir {
           dirs 'libs'
         }
    }
    
    dependencies {
            ...
            compile(name:'networkrequest-release', ext:'aar')
            ...
    }
 
Maven中使用：

第一步，在maven中添加：

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://www.jitpack.io</url>
		</repository>
	</repositories>
	
 第二步，添加依赖：
 
 	<dependency>
	    <groupId>com.github.YouAreOnlyOne</groupId>
	    <artifactId>AndroidHttp</artifactId>
	    <version>版本号</version>
	</dependency>
	
Sbt中使用：

  第一步： 在build.sbt文件末尾添加：
  
  	resolvers += "jitpack" at "https://www.jitpack.io"
	
  第二步：添加依赖：
  
  	libraryDependencies += "com.github.YouAreOnlyOne" % "AndroidHttp" % "版本号"
 
 Leiningen中使用：
 
   第一步：在project.clj文件末尾添加：
   
   	:repositories [["jitpack" "https://www.jitpack.io"]]
  
  第二步：添加依赖：
  
  	:dependencies [[com.github.YouAreOnlyOne/AndroidHttp "版本号"]]
	
	
# 使用示例：

由于每个框架集成和封装的方法有很对，这里只是随意挑选一个做演示，具体方法和目录见本文后面。使用总体策略：框架名称 . 方法名（如：OkhttpByPost . postFile() ）。

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
     
     
# 多样化工具类
 
 ## Ftp文件上传、文件下载、文件删除、进度监听
 
 Ftp文件上传、文件下载、文件删除、进度监听等功能是需要一行代码进行调用即可。
 
 ## 常用图片压缩及图片保存方法
 
 包括质量压缩方法、比列压缩方法、分辨率压缩方法、图片存储等常用的方法，只需要一行代码就可以实现。
 
 ## 常用的加密算法
 
 包括MD5加密算法、DES加密算法、MISC算法等等，已经封装好，只需要用类名点方法名（）即可调用实现。
 
 ## Strings工具类常用方法
 
 包括字符编码的转换、时间格式的转换、非空的判断、输入流的转换等等，只需要调用即可使用。
 
 ## 日志输出管理
 
 在任何一个文件中，不管是字符串日志还是数据列表日志，只要用L.e()或者L.g()或者L.a()等方法即可快速的打印日志。
 
 ## APP退出管理
 
 包括App中Activity的加入和移除，状态监控及管理，彻底的退出应用程序的方法等等，一行代码调用方法即可完成操作。
 
# 使用指南
 
 更新中……
 
# 其它信息

1.项目还有很多不完善的地方，欢迎大家指导。

2.项目持续更新开源，有兴趣加入项目或者跟随项目的伙伴，可以邮件联系！ 

3.关注或者喜欢或者尝试使用或者感兴趣的伙伴可以，点击 ~ star ~ 。

# 作者邮箱

ycj52011@outlook.com

