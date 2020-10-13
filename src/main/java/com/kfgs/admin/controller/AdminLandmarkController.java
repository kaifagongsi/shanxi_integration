package com.kfgs.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.kfgs.admin.service.AdminLandmarkService;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.statistics.service.AdministrativeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("admin/landmarkController")
public class AdminLandmarkController {
    @Autowired
    AdminLandmarkService adminLandmarkService;

    @Autowired
    AdministrativeAreaService administrativeAreaService;

    @PostMapping("/getAdminLandmarkList")
    public QueryResponseResult getAdminLandmarkList(@RequestBody Map map){
        return adminLandmarkService.adminLandmarkListLoad(map);
    }

    @GetMapping("/getSelectMap")
    public QueryResponseResult getSelectMap(){
        return adminLandmarkService.getSelectMap();
    }

    @GetMapping("/selectByIndustry")
    public QueryResponseResult selectByIndustry(String name){
        return adminLandmarkService.findTypeByIndustry(name);
    }

    @GetMapping("/selectByParentId")
    public QueryResponseResult selectByParentId(String id){
        return administrativeAreaService.findListByParentId(id);
    }

    //新增或编辑
    @PostMapping(value = "saveLandmark", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String saveLandmark(@RequestBody Map landmarkEntity) {
        int returnStr = adminLandmarkService.saveLandmark(landmarkEntity);
        JSONObject ja = new JSONObject();
        if (returnStr == 1){
            return "success";
        }else {
            return "false";
        }
        /*ja.put("isSuccess", returnStr);
        ja.put("loadType", "农产品地理标志");*/
        //return "success";
    }

    //获取详情
    @PostMapping("/initByProductNumber")
    public Map<String,Object> initByProductNumber(@RequestBody Map pData){
        return adminLandmarkService.initByProductNumber(pData);
    }

    //删除
    @DeleteMapping("deleteLandmark")
    public QueryResponseResult deleteLandmark(String productNumber){
        return adminLandmarkService.deleteLandmark(productNumber);
    }
}
