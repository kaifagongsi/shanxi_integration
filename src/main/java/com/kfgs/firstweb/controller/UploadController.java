package com.kfgs.firstweb.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kfgs.firstweb.service.UploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping(produces= "text/plain;charset=utf-8",value = "savefile.do", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        System.out.println(file.getOriginalFilename()+">>>>>>>>>");
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();//z.png
        int size = (int) file.getSize();
        /*String path = System.getProperty("user.dir");//   /Users/apple/Desktop/IDEAWORKSPACE/day2/shoppingmall2*/
        //保存路径
        String path= request.getSession().getServletContext().getRealPath("/")+"static\\complaint\\";
        File dest = new File(path);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(path+fileName);
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
            String savePath = path+fileName;
            System.out.println("**********附件" + fileName+"已保存到" + savePath+"***********");
            savePath = "../../static/complaint/"+fileName;
            return savePath;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }

    @PostMapping(value = "save", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String save(@RequestBody Map pData) {
        String returnBack = "";
        /*System.out.println(pData.get("type").toString());*/
        /*if(StringUtils.equals(pData.get("type").toString(), "公告")){
            int returnStr = uploadService.updateByExampleSelective(pData);
        }else  if(StringUtils.equals(pData.get("type").toString(), "政策")){
            int returnStr = uploadService.updateByExampleSelective(pData);
        }*/
        String returnStr = uploadService.updateByExampleSelective(pData);
        return returnBack;
    }

    @PostMapping("/getContent")
    public Map<String,Object> getContent(@RequestBody Map pData){
        return uploadService.selectByPrimaryKey(pData);
    }

    /*@PostMapping(value = "insert", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public void insert(@RequestBody Map pData){
        System.out.println(pData.get("title").toString());
        uploadService.insertByExampleSelective(pData);
    }*/
}
