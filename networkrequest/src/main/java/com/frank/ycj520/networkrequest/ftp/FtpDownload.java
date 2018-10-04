package com.frank.ycj520.networkrequest.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * PROJECT_NAME:AndroidHttp
 * PACKAGE_NAME:com.frank.ycj520.networkrequest.ftp
 * USER:Frank
 * DATE:2018/10/4
 * TIME:21:43
 * DAY_NAME_FULL:星期四
 * DESCRIPTION:On the description and function of the document
 **/
public class FtpDownload {

    public static boolean downloadFile(String ipAddress,int port,String userName, String passWord,String localSavePath, String serverPathFileName){

        boolean result=false;
        try {
            FTPManager ftpManager = new FTPManager(ipAddress,port,userName,passWord);
            if (ftpManager.connect()) {
                if (ftpManager.downloadFile(localSavePath, serverPathFileName)) {
                    ftpManager.closeFTP();
                    result=true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return result;
    }



    public static boolean downloadFile(String url, int port, String username,String password, String remoteFilePathAndName,String localFilePath,String localFileName){
        BufferedOutputStream buffOut = null;

        FTPClient ftpClient = new FTPClient();
        boolean returnMessage = false;
        try {
            ftpClient.connect(url, port);
            boolean loginResult = ftpClient.login(username, password);
            int returnCode = ftpClient.getReplyCode();
            if (loginResult && FTPReply.isPositiveCompletion(returnCode)) {// 如果登录成功
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.enterLocalPassiveMode();

                buffOut = new BufferedOutputStream(new FileOutputStream(localFilePath+localFileName),8*1024);
                ftpClient.retrieveFile(remoteFilePathAndName, buffOut);
                buffOut.flush();
                buffOut.close();

                ftpClient.logout();
                ftpClient.disconnect();

                returnMessage = true;   //上传成功
            } else {// 如果登录失败
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
        return returnMessage;
    }


    public static void downloadFile(String ipAddress, int port, String userName, String passWord,String remoteFilePathAndName,String localFilePath,String localFileName, FTPManager.DownLoadProgressListener downLoadProgressListener){
        // 下载

        /*new DownLoadProgressListener(){

            @Override
            public void onDownLoadProgress(String currentStep, long downProcess, File file) {

                if(currentStep.equals(FTP_DOWN_SUCCESS)){

                } else if(currentStep.equals(FTP_DOWN_LOADING)){

                }
            }

        }*/
        try {

            //单文件下载
            new FTPManager(ipAddress,port,userName,passWord).downloadSingleFile(remoteFilePathAndName,localFilePath,localFileName,downLoadProgressListener);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
