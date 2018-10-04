package com.frank.ycj520.networkrequest.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;

/**
 * PROJECT_NAME:AndroidHttp
 * PACKAGE_NAME:com.frank.ycj520.networkrequest.ftp
 * USER:Frank
 * DATE:2018/10/4
 * TIME:21:09
 * DAY_NAME_FULL:星期四
 * DESCRIPTION:On the description and function of the document
 **/
public class FtpDelete {
    public static boolean deleteFile(String url, String userName, String passWord,int port,String remotePath, final String filename){
        boolean returnMessage = false;
        try {

            FTPClient ftpClient = new FTPClient();
            try {
                ftpClient.connect(url, port);
                boolean loginResult = ftpClient.login(userName, passWord);
                int returnCode = ftpClient.getReplyCode();
                if (loginResult && FTPReply.isPositiveCompletion(returnCode)) {// 如果登录成功

                    ftpClient.changeWorkingDirectory(remotePath);
                    ftpClient.setBufferSize(10*1024*1024);
                    ftpClient.setControlEncoding("UTF-8");
                    ftpClient.enterLocalPassiveMode();         // 被动模式
                    ftpClient.deleteFile(filename);
                    returnMessage = true;
                }
                else {
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


    public static void deleteFile(String ipAddress, int port,String userName, String passWord,String remoteFilePathAndName,FTPManager.DeleteFileProgressListener deleteFileProgressListener){
        try {

            /*new DeleteFileProgressListener(){

                @Override
                public void onDeleteProgress(String currentStep) {

                    if(currentStep.equals(FTP_DELETEFILE_SUCCESS)){

                    } else if(currentStep.equals(FTP_DELETEFILE_FAIL)){

                    }
                }

            }*/

            new FTPManager(ipAddress,port,userName,passWord).deleteSingleFile(remoteFilePathAndName,deleteFileProgressListener);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
