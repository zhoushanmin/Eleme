package com.eleme.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtils {
public static String getNewFileName(String fileName) {
		
		String extions = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = UUID.randomUUID().toString().replace("-", "") + extions;
		return newFileName;
	}
	
	public static String getPath(String newFileName) {
		int hash = newFileName.hashCode();
		int a = hash & 0xf;
		int b = hash >>> 4 & 0xf;
		int c = hash >>> 8 & 0xf;
		
		return  a + "/" + b + "/" + c;
	}
	
	public static List<String> uploadFiles(MultipartFile[] files) {
		
		List<String> newFileNames = new ArrayList<String>();
		String rootPath = null;
		for (MultipartFile file : files) {
			if(file != null) {
				if(file.getOriginalFilename() != "") {
					String newFileName = UploadUtils.getNewFileName(file.getOriginalFilename());
					String realPath = UploadUtils.getPath(newFileName);
					String url = PathParam.PATH + realPath;
					File file1 = new File(url);
					if(!file1.exists()) {
						file1.mkdirs();
					}
					File saveFile = new File(rootPath = (url + "/" + newFileName));
					try {
						file.transferTo(saveFile);
						newFileNames.add(rootPath);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		}
		return newFileNames;	
	}
	
	
}
