package com.frank.ycj520.networkrequest.utils;

import java.io.File;

/**
 * Created by Frank on 2017/12/7.
 */

public class DeleteFile {
    public static boolean deleteFile(String filePath){

        try{
            File file = new File(filePath);
            if(file.exists()){
                file.delete();
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
