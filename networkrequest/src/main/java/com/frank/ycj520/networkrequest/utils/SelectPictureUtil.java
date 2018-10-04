package com.frank.ycj520.networkrequest.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class SelectPictureUtil {

	//默认保存数据路径
	public final static String IMAGES = "images";
	public final static String DEFAULT_SAVE_PATH = Environment.getExternalStorageDirectory()
			+ File.separator + "select";
	public final static String DEFAULT_SAVE_IMAGES_PATH = DEFAULT_SAVE_PATH + File.separator + IMAGES;

	// 拍照
	public static final int REQUEST_CODE_PICK = 1;//选取单张图片
	public static final int REQUEST_CODE_CAPTURE = 2;//拍照
	public static final int REQUEST_CODE_CROP = 3;//裁剪图片
	public static final int REQUEST_CODE_PICK_MULTI = 4;//选取多张图片

	public static final String IMAGE_LIST = "image_list";

	public static void getImageFromAlbum(Activity activity) {
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType("image/*");// 相片类型
		activity.startActivityForResult(intent, REQUEST_CODE_PICK);
	}

	public static void getImageFromCamera(Activity activity, String mFilePath) {
		String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			Intent getImageByCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(mFilePath)));
			activity.startActivityForResult(getImageByCamera, REQUEST_CODE_CAPTURE);
		} else {
			Toast.makeText(activity, "请确认已经插入SD卡", Toast.LENGTH_LONG).show();
		}
	}
	
	public static void cropImageUri(Activity activity, String mCropPath, Uri uri, int outputX, int outputY) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", outputX);
		intent.putExtra("outputY", outputY);
		intent.putExtra("scale", true);
		intent.putExtra("return-data", false);
		intent.putExtra("output", Uri.fromFile(new File(mCropPath)));
		intent.putExtra("noFaceDetection", true); // no face detection
		activity.startActivityForResult(intent, REQUEST_CODE_CROP);
	}
	
	/**
	 * 获取随机文件名
	 */
	public static String getRandomFilePath(){
		return DEFAULT_SAVE_IMAGES_PATH + File.separator + SystemClock.uptimeMillis()+".jpg";
	}

	/**
	 * 创建文件夹
	 */
	public static File createSDDir(String dirName) throws IOException {
		File dir = new File(DEFAULT_SAVE_PATH, dirName);
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			if (!dir.exists()) {
				dir.mkdirs();
				// System.out.println("createSDDir:" + dir.getAbsolutePath());
			}
			return dir;
		}
		return null;
	}
}
