package com.kfgs.admin.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface UploadExcelService {

    public void upload(MultipartFile file,String dataBasesType,String productType);

    public void downLoadExcel(HttpServletResponse response, Integer index);
}
