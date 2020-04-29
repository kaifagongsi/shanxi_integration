package com.kfgs.admin.controller;


import com.kfgs.admin.service.ComplaintManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class ComplaintManageController {

    @Autowired
    ComplaintManageService complaintManageService;

    @PostMapping("/getComplaintFinishList")
    public Map<String,Object> getFinishList(@RequestBody Map searchMap){
        return complaintManageService.getFinishList(searchMap);
    }

    @PostMapping("/getComplaintTodoList")
    public Map<String,Object> getTodoList(@RequestBody Map searchMap){
        return complaintManageService.getTodoList(searchMap);
    }

    //新增保存维权处理信息
    @PostMapping(value = "insertHandling", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertHandling(@RequestBody Map pData){
        String returnBack = "";
        //System.out.println(pData.get("handlingInfo").toString());
        int returnStr = complaintManageService.insertByExample(pData);
        return  returnBack;
    }
    //修改维权处理信息
    @PostMapping(value = "updateHandling", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public  String updateHandling(@RequestBody Map pData){
        String returnBack = "";
        //System.out.println(pData.get("handlingInfo").toString());
        int returnStr = complaintManageService.updateByExample(pData);
        return  returnBack;
    }

    //批量删除维权信息
    @PostMapping(value = "deleteAll", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public  String deleteAll(@RequestBody List<String> idList){
        String returnBack = "";
        //System.out.println(pData.get("handlingInfo").toString());
        int returnStr = complaintManageService.deleteByExample(idList);
        return  returnBack;
    }
}
