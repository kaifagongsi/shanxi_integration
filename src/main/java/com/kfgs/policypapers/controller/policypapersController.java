package com.kfgs.policypapers.controller;


import com.alibaba.fastjson.JSONObject;
import com.kfgs.domain.TbPolicyDocument;
import com.kfgs.policypapers.service.policypapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/policypapers")
public class policypapersController {

    @Autowired
    private  policypapersService policypapersService;

    @GetMapping("/search")
    public Map<String,List<TbPolicyDocument>> text(){
        return policypapersService.getList();
    }



    @PostMapping("/getList")
    public Map<String,Object> getList(@RequestBody Map searchMap){
        return policypapersService.getList(searchMap);
    }


    @PostMapping(value = "save", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String save(@RequestBody Map pData) {
        int returnStr = policypapersService.updateByExampleSelective(pData);
        JSONObject ja = new JSONObject();
        ja.put("isSuccess", returnStr);
        ja.put("loadType", "受理公告");
        return "success";
    }

    @PostMapping("/getContent")
    public Map<String,Object> getContent(@RequestBody Map pData){
        return policypapersService.selectByPrimaryKey(pData);
    }

    //新增或编辑
    @PostMapping(value = "saveOrupdate", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String saveOrupdate(@RequestBody Map contentMap) {
        int returnStr = policypapersService.saveOrupdate(contentMap);
        JSONObject ja = new JSONObject();
        ja.put("isSuccess", returnStr);
        ja.put("loadType", "受理公告");
        return "success";
    }

    //批量删除维权信息
    @PostMapping(value = "deleteAll", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public  String deleteAll(@RequestBody List<String> idList){
        String returnBack = "success";
        int returnStr = policypapersService.deleteByExample(idList);
        return  returnBack;
    }

}
