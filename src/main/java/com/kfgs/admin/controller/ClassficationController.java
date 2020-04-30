package com.kfgs.admin.controller;

import com.kfgs.admin.service.ClassficationService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class ClassficationController {

    @Autowired
    ClassficationService classficationService;

    @PostMapping("/getCountryClassList")
    public Map<String,Object> getCountryClassList(@RequestBody Map searchMap){
        return classficationService.getCountryClassList(searchMap);
    }

    @PostMapping("/getShanxiClassList")
    public Map<String,Object> getShanxiClassList(@RequestBody Map searchMap){
        return classficationService.getShanxiClassList(searchMap);
    }

    //删除国内分类
    @PostMapping(value = "deleteCounrty", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public  String deleteCounrty(@RequestBody List<String> idList){
        String returnBack = "";
        //System.out.println(pData.get("handlingInfo").toString());
        int returnStr = classficationService.deleteCountry(idList);
        return  returnBack;
    }

    //删除陕西分类
    @PostMapping(value = "deleteShanxi", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public  String deleteShanxi(@RequestBody List<String> idList){
        String returnBack = "";
        //System.out.println(pData.get("handlingInfo").toString());
        int returnStr = classficationService.deleteShanxi(idList);
        return  returnBack;
    }

    //保存国内图片
    @RequestMapping(value = "savePic",method=RequestMethod.POST)
    @ResponseBody
    public String savePic(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println("111111111111111111111");
        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("imagePath");
        String className = multipartRequest.getParameter("className");
        //获取当前最大rootID
        String maxId = multipartRequest.getParameter("maxId");
        System.out.println(maxId);
        //新建类别id
        String newId = String.valueOf(Integer.parseInt(maxId) + 1)+"00";
        System.out.println(className);
        //源文件类型
        String type=multipartFile.getContentType();
        System.out.println(type);
        //源文件名称
        String imgName = multipartFile.getOriginalFilename();
        System.out.println(imgName);
        //图片按照类别id命名
        String newName = newId+".jpg";
        //保存路径
        String path= request.getSession().getServletContext().getRealPath("/")+"img\\index\\guonei\\";
        System.out.println(path);
        //String path = "http://localhost:9103/img/index/guonei/";
        File targetImg = new File(path);
        //开始保存
        try{
            FileOutputStream outputStream = new FileOutputStream(path+newName);
            outputStream.write(multipartFile.getBytes());
            outputStream.flush();
            outputStream.close();
            String imgPath = path+newName;
            classficationService.addCountryClass(className,imgPath,newId);
        }catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "SUCCESS";

    }


    //保存陕西图片
    @RequestMapping(value = "saveShanxiPic",method=RequestMethod.POST)
    @ResponseBody
    public String saveShanxiPic(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println("111111111111111111111");
        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("imagePath");
        String className = multipartRequest.getParameter("className");
        //获取当前最大rootID
        String maxId = multipartRequest.getParameter("maxId");
        System.out.println(maxId);
        //新建类别id
        String newId = String.valueOf(Integer.parseInt(maxId) + 1)+"00";
        System.out.println(className);
        String imgName = multipartFile.getOriginalFilename();
        System.out.println(imgName);
        //图片按照类别id命名
        String newName = newId+".jpg";
        //保存路径
        String path= request.getSession().getServletContext().getRealPath("/")+"img\\index\\201507\\";
        System.out.println(path);
        //String path = "http://localhost:9103/img/index/guonei/";
        File targetImg = new File(path);
        //开始保存
        try{
            FileOutputStream outputStream = new FileOutputStream(path+newName);
            outputStream.write(multipartFile.getBytes());
            outputStream.flush();
            outputStream.close();
            String imgPath = path+newName;
            classficationService.addShanxiClass(className,imgPath,newId);
        }catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "SUCCESS";

    }

}
