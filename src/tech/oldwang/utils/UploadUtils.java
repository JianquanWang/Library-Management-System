package tech.oldwang.utils;

import java.util.UUID;

public class UploadUtils {
	
	public static String getUuidFileName(String fileName){
		int idx = fileName.lastIndexOf(".");
		String exName = fileName.substring(idx);// .jpg
		String uuidFileName = UUID.randomUUID().toString().replace("-", "")+exName;
	
		return uuidFileName;
	}
	
	public static void main(String[] args) {
		System.out.println(UploadUtils.getUuidFileName("a.jpg"));
	}
}
