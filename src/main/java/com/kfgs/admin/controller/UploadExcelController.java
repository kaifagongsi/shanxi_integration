package com.kfgs.admin.controller;

import com.kfgs.admin.service.UploadExcelService;
import com.kfgs.domain.ext.ExcelSheetPO;
import com.kfgs.domain.response.Response;
import com.kfgs.domain.response.ResponseResult;
import com.kfgs.firstweb.service.UploadService;
import com.kfgs.utils.DatabasePropertiesUtils;
import com.kfgs.utils.ExportExcelUtil;
import com.kfgs.utils.ImportExcelSheetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 2020-04-15-10-20
 * Module:
 * Description:
 *
 * @author:
 */
@RestController
@RequestMapping("admin")
public class UploadExcelController {


    @Autowired
    UploadExcelService uploadExcelService;

    @PostMapping("/uploadExcel")
    public ResponseResult upload(@RequestParam("file") MultipartFile file, @RequestParam("dataBasesType")String dataBasesType,@RequestParam("productType")String productType){
        ResponseResult result = new ResponseResult();
        try {
            Boolean b = uploadExcelService.upload(file,dataBasesType,productType);
            if(b){
                result.setCode(Response.SUCCESS_CODE);
                result.setSuccess(Response.SUCCESS);
                result.setMessage("上传成功");
            }else{
                result.setCode(Response.FALIE_CODE);
                result.setSuccess(Response.FALIE);
                result.setMessage("上传失败,系统内部异常或数据错误，请检查或稍候重试");
            }
            return  result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(Response.FALIE_CODE);
            result.setSuccess(Response.FALIE);
            result.setMessage("上传失败,系统内部异常，请稍候重试");
            return  result;
        }
    }



}
