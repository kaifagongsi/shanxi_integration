package com.kfgs.firstweb.controller;

import com.kfgs.firstweb.service.ComplaintRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/complaintRight")
public class ComplaintRightController {

    @Autowired
    private ComplaintRightService complaintRightService;

    @PostMapping("/getList")
    public Map<String,Object> getList(@RequestBody Map searchMap){
        return complaintRightService.getList(searchMap);
    }

    @PostMapping(value = "save", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String save(@RequestBody Map pData) {
        String returnBack = "";
        System.out.println(pData.get("object").toString());
        int returnStr = complaintRightService.insertByExample(pData);
        return returnBack;
    }

}
