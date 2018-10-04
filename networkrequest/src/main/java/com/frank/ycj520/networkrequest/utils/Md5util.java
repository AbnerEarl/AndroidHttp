package com.frank.ycj520.networkrequest.utils;

import org.apache.commons.net.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5util {
    public static String  md5(String password) throws UnsupportedEncodingException
    {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("md5");
            byte md5[]=md.digest(password.getBytes("utf-8"));
            return  new String(Base64.encodeBase64(md5));	//使用apache工具包里的Base64进行加密
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }
}
