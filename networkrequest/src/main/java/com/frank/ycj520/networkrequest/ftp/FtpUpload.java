package com.frank.ycj520.networkrequest.ftp;

import android.app.Activity;
import android.util.Log;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.frank.ycj520.networkrequest.ftp.FTPManager.FTP_UPLOAD_LOADING;
import static com.frank.ycj520.networkrequest.ftp.FTPManager.FTP_UPLOAD_SUCCESS;

/**
 * PROJECT_NAME:AndroidHttp
 * PACKAGE_NAME:com.frank.ycj520.networkrequest.ftp
 * USER:Frank
 * DATE:2018/10/4
 * TIME:20:47
 * DAY_NAME_FULL:星期四
 * DESCRIPTION:On the description and function of the document
 **/
public class FtpUpload {

    public static boolean uploadFile( String url,String rootPath, String userName, String passWord, int port, String filePath, String remotePath, String remoteFileName) {


        boolean returnMessage = false;
        try {

            FTPClient ftpClient = new FTPClient();
            FileInputStream fis = null;
            try {
                ftpClient.connect(url, port);
                boolean loginResult = ftpClient.login(userName, passWord);
                int returnCode = ftpClient.getReplyCode();

                if (loginResult && FTPReply.isPositiveCompletion(returnCode)) {// 如果登录成功
                    ftpClient.changeWorkingDirectory(rootPath);
                    String paths[] = remotePath.split("/");
                    for (int i = 0; i < paths.length; i++) {
                        remotePath = remotePath + paths[i] + "/";
                        if (ftpClient.changeWorkingDirectory(remotePath)) {
                            continue;
                        } else {
                            Boolean dd = ftpClient.makeDirectory(remotePath);
                            Log.e("makeDirectory", dd + "");
                        }
                    }

                    // 设置上传目录
                    ftpClient.changeWorkingDirectory(remotePath);
                    ftpClient.setBufferSize(10 * 1024 * 1024);
                    ftpClient.setControlEncoding("UTF-8");
                    ftpClient.enterLocalPassiveMode();// 被动模式

                    fis = new FileInputStream(filePath);
                    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                    boolean isSuccess = ftpClient.storeFile(remoteFileName, fis);
                    // 如果上传成功
                    returnMessage = true;
                    fis.close();
                } else {
                    // 如果登录失败
                    returnMessage = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("FTP客户端出错！", e);
            } finally {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("关闭FTP连接发生异常！", e);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnMessage;
    }



    public static boolean uploadFile(String ipAddress,int port,String userName, String passWord,String localPath, String serverPath){

        boolean result=false;
        try {
            FTPManager ftpManager = new FTPManager(ipAddress,port,userName,passWord);
            if (ftpManager.connect()) {
                if (ftpManager.uploadFile(localPath, serverPath)) {
                    ftpManager.closeFTP();
                    result=true;
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }



        return result;
    }



    public boolean uploadFiles(String ipAddress,int port,String rootPath,String userName, String passWord, String remotePath, ArrayList<String> fileLists) {

        FTPClient ftpClient = new FTPClient();
        FileInputStream fis;
        boolean returnMessage = false;

        try {

            ftpClient.connect(ipAddress, port);
            boolean isLogin = ftpClient.login(userName, passWord);
            int replyCode = ftpClient.getReplyCode();
            if (isLogin && FTPReply.isPositiveCompletion(replyCode)) {
                ftpClient.changeWorkingDirectory(rootPath);
                String paths[] = remotePath.split("/");
                for (int i = 0; i < paths.length; i++) {
                    remotePath = remotePath + paths[i] + "/";
                    if (ftpClient.changeWorkingDirectory(remotePath)) {
                        continue;
                    } else {
                        Boolean dd = ftpClient.makeDirectory(remotePath);
                        Log.e("makeDirectory", dd + "");
                    }
                }
                // 设置上传目录
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.enterLocalPassiveMode();

                for (String filepath : fileLists) {
                    File f = new File(filepath);
                    fis = new FileInputStream(f);
                    ftpClient.storeFile(f.getName(), fis);
                }
                returnMessage = true;
            }
            else {
                returnMessage = false;
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return returnMessage;
    }



    public static boolean uploadFile(String url, String port, String username,String password, String fileNamePath,String fileName){
        FTPClient ftpClient = new FTPClient();
        FileInputStream fis = null;
        boolean returnMessage = false;
        try {
            ftpClient.connect(url, Integer.parseInt(port));
            boolean loginResult = ftpClient.login(username, password);
            int returnCode = ftpClient.getReplyCode();
            if (loginResult && FTPReply.isPositiveCompletion(returnCode)) {// 如果登录成功
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();
                fis = new FileInputStream(fileNamePath + fileName);
                ftpClient.storeFile(fileName, fis);

                returnMessage = true;   //上传成功
            } else {// 如果登录失败
                returnMessage = false;
            }

        } catch (IOException e) {
            e.printStackTrace();
//		     throw new RuntimeException("FTP客户端出错！", e);
            returnMessage = false;
        } finally {
            //IOUtils.closeQuietly(fis);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
        return returnMessage;
    }


    public static void uploadFile(String ipAddress,int port,String userName, String passWord,String remotePath,String localFilePathAndName,FTPManager.UploadProgressListener uploadProgressListener){
        // 上传
        File file = new File(localFilePathAndName);
        /*new FTPManager.UploadProgressListener(){

            @Override
            public void onUploadProgress(String currentStep,long uploadSize,File file) {
                // TODO Auto-generated method stub

                if(currentStep.equals(FTP_UPLOAD_SUCCESS)){

                } else if(currentStep.equals(FTP_UPLOAD_LOADING)){
                    long fize = file.length();
                    float num = (float)uploadSize / (float)fize;
                    int result = (int)(num * 100);

                }
            }
        }*/
        try {
            //单文件上传
            new FTPManager(ipAddress,port,userName,passWord).uploadSingleFile(file, remotePath,uploadProgressListener);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public static void uploadFiles(String ipAddress, int port,String userName, String passWord, String remotePath, List<String> localFilePathAndNameList, FTPManager.UploadProgressListener uploadProgressListener){
        LinkedList<File> fileList=new LinkedList<>();
        for (int i=0;i<localFilePathAndNameList.size();i++) {
            File file = new File(localFilePathAndNameList.get(i));
            fileList.add(file);
        }
        /*new FTPManager.UploadProgressListener(){

            @Override
            public void onUploadProgress(String currentStep,long uploadSize,File file) {
                // TODO Auto-generated method stub

                if(currentStep.equals(FTP_UPLOAD_SUCCESS)){

                } else if(currentStep.equals(FTP_UPLOAD_LOADING)){
                    long fize = file.length();
                    float num = (float)uploadSize / (float)fize;
                    int result = (int)(num * 100);

                }
            }
        }*/
        try {
            //单文件上传
            new FTPManager(ipAddress,port,userName,passWord).uploadMultiFile(fileList, remotePath,uploadProgressListener);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




}
