package com.kfgs.admin.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface UploadExcelService {

    public Boolean upload(MultipartFile file,String dataBasesType,String productType);

    public void downLoadExcel(HttpServletResponse response, Integer index);

    public Map<String, String> getAdminAreaMap();
}
