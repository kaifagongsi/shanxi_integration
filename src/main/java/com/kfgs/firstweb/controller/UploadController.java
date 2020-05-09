package com.kfgs.firstweb.controller;


import com.kfgs.firstweb.service.UploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "savefile.do", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam("filename") MultipartFile file){
        System.out.println(file.getOriginalFilename()+">>>>>>>>>");
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();//z.png
        int size = (int) file.getSize();
        //fileName=fileName.substring(fileName.lastIndexOf("\\")+1);

        String path = System.getProperty("user.dir");//   /Users/apple/Desktop/IDEAWORKSPACE/day2/shoppingmall2
        File dest = new File(path+"/target/classes/static/file" + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            String savepath = "http://localhost:9103/upload/"+fileName;
            System.out.println("*************************"+savepath);
            return savepath;
            //return "{\"file_path\":\"http://localhost:9101/upload/"+fileName+"\"}";
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
