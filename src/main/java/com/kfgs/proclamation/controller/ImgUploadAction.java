package com.kfgs.proclamation.controller;


import com.kfgs.domain.ext.ImageUploadVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;


@Controller
@RequestMapping("/imgUpload")
public class ImgUploadAction {

	@Value(value = "${ckeditor.storage.image.path}")
	private String imageFilePath;

	@Value(value = "${ckeditor.storage.file.path}")
	private String filePath;

	@Value(value = "${ckeditor.access.image.url}")
	private String url;

	private File upload; // 文件
	private String uploadContentType; // 文件类型
	private String uploadFileName; // 文件名


	/**
	 * 上传图片
	 *
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/ckeditorUpload")
	public ImageUploadVo ckeditorUpload(@RequestParam("upload") MultipartFile file, String type) throws Exception {
		System.out.println("开始上传文件");
		// 获取文件名
		String fileName = file.getOriginalFilename().trim();
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		System.out.println("上传文件文件名称：{}" +  fileName);
		System.out.println("上传文件大小 ：{}" + file.getSize());
		String newfileName = UUID.randomUUID().toString() + suffixName;
		if(suffixName.toLowerCase().equals(".jpg") || suffixName.toLowerCase().equals(".bmp") || suffixName.toLowerCase().equals(".jpeg")
				|| suffixName.toLowerCase().equals(".gif") || suffixName.toLowerCase().equals(".png") || suffixName.toLowerCase().equals(".tif")){
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath + newfileName));
		}else{
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath + newfileName));
		}
		//实现图片回显，基本上是固定代码，只需改路劲即可
		ImageUploadVo imageUploadVo = new ImageUploadVo();
		imageUploadVo.setUploaded(1);
		imageUploadVo.setFileName(fileName);
		String filePath = "";
		if(suffixName.toLowerCase().equals(".jpg") || suffixName.toLowerCase().equals(".bmp") || suffixName.toLowerCase().equals(".jpeg")
				|| suffixName.toLowerCase().equals(".gif") || suffixName.toLowerCase().equals(".png")){
			filePath = url + "/image/" + newfileName;
		}else{
			filePath = url + "/file/" + newfileName;
		}
		imageUploadVo.setUrl(new String(filePath.getBytes(),"utf-8"));
		return imageUploadVo;
	}


	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
}
