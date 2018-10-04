package com.frank.ycj520.networkrequest.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamTool {

	public static String streamtoText(InputStream is, String charset)
	{
		if(is==null)
			return null;
		ByteArrayOutputStream bao=new ByteArrayOutputStream();
		int len=0;
		byte[] buf=new byte[1024];
		
		try {
			while((len=is.read(buf))!=-1)
			{
				bao.write(buf,0,len);
			}
			is.close();
			bao.close();
			byte[] result=bao.toByteArray();
			String temp=new String(result,charset);
			return temp;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "获取失败";
		}
	}
	
	

}
