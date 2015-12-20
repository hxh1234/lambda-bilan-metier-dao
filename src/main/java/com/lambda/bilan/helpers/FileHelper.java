package com.lambda.bilan.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelper {
	private String OPENSHIFT_DATA_DIR="D:/";
	
	public String setRandomName(String filename){
		String extension = filename.substring(filename.lastIndexOf("."));
		return  RandomGenerator.randomNumber() + extension;
	}
	
	public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException 
	{
	        File convFile = new File( multipart.getOriginalFilename());
	        multipart.transferTo(convFile);
	        return convFile;
	}
	
	public String saveDocument(MultipartFile multipart, String documentFileName) throws IOException {
		//create Files
		File saveDirReal = new File(OPENSHIFT_DATA_DIR);
		
		//generate names and prepare URI
		String generatedName = setRandomName(documentFileName);
		File fileToSaveReal = new File(saveDirReal, generatedName);
		
		//save file
		File document =multipartToFile(multipart);
		FileUtils.copyFile(document, fileToSaveReal);
		
		return generatedName;
	}
	
	public InputStream getDocument(String file) throws Exception {
		File f = new File(OPENSHIFT_DATA_DIR + "/" + file);
		System.out.println(f);
		
		if(f.exists()){
			FileInputStream fileInputStream = new FileInputStream(f);
			return fileInputStream;
		}else{
			throw new Exception();
		}
	}

	public String getOPENSHIFT_DATA_DIR() {
		return OPENSHIFT_DATA_DIR;
	}

	public void setOPENSHIFT_DATA_DIR(String oPENSHIFT_DATA_DIR) {
		OPENSHIFT_DATA_DIR = oPENSHIFT_DATA_DIR;
	}
	
}
