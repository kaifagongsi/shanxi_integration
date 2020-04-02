package com.kfgs.proclamation.controller;


import com.alibaba.fastjson.JSON;
import com.kfgs.domain.ext.ImageUploadVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/imgUpload")
public class ImgUploadAction {

	@Value(value = "D:\\idea_workspace\\shanxi_integration\\src\\main\\webapp\\static\\image\\")
	private String imageFilePath;

	@Value(value = "D:\\idea_workspace\\shanxi_integration\\src\\main\\webapp\\static\\file\\")
	private String filePath;

	@Value(value = "http://localhost:9103/static/")
	private String url;

	private File upload; // 文件
	private String uploadContentType; // 文件类型
	private String uploadFileName; // 文件名

	@RequestMapping(value="/upload")
	public void fileUpload(HttpServletRequest request, HttpServletResponse response) {
		String DirectoryName = "static";
		try {
			ImgUploadUtil.ckeditor(request, response, DirectoryName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


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
//		response.setContentType("text/html; charset=UTF-8");
		imageUploadVo.setUrl(new String(filePath.getBytes(),"utf-8"));
//		Map<String, String> reMap = new HashMap<String, String>();
//
//		//必须返回这样格式的json字符串
//		reMap.put("uploaded", "1");
//		reMap.put("fileName", fileName);
//		reMap.put("url", new String(filePath.getBytes(),"utf-8"));
//		return JSON.toJSONString(reMap);

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
