package com.kfgs.proclamation.controller;

import com.kfgs.domain.TbProtectionNotice;
import com.kfgs.proclamation.service.ProclamtionService;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/proclamation")
public class ProclamationController {

    @Autowired
    private ProclamtionService proclamationService;

    @Autowired
    private com.kfgs.policypapers.service.policypapersService policypapersService;


    @GetMapping("/text")
    public Map<String,List<TbProtectionNotice>> text(){
        return proclamationService.getList();
    }

    @RequestMapping("/search")
    public Map<String,Object> search(@RequestBody Map searchMap){
        return proclamationService.search(searchMap);
    }


    @PostMapping("/getList")
    public Map<String,Object> getList(@RequestBody Map searchMap){
        return proclamationService.getList(searchMap);
    }


    @PostMapping(value = "save", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String save(@RequestBody Map pData) {
        String returnBack = "";
        System.out.println(pData.get("type").toString());
        if(StringUtils.equals(pData.get("type").toString(), "公告")){
            int returnStr = proclamationService.updateByExampleSelective(pData);
        }else  if(StringUtils.equals(pData.get("type").toString(), "政策")){
            int returnStr = policypapersService.updateByExampleSelective(pData);
        }
        return returnBack;
    }

    @PostMapping("/getContent")
    public Map<String,Object> getContent(@RequestBody Map pData){
        return proclamationService.selectByPrimaryKey(pData);
    }

}
