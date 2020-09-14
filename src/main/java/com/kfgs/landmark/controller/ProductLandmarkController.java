package com.kfgs.landmark.controller;

import com.kfgs.landmark.service.ProductLandmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/landmark")
public class ProductLandmarkController {

    @Autowired
    private ProductLandmarkService productLandmarkService;

    @PostMapping("/getList")
    public Map<String,Object> getList(@RequestBody Map searchMap){
        return productLandmarkService.getList(searchMap);
    }

    @GetMapping("/getShanxiMap")
    public List<Map<String,Object>> getShanxiMap(){
        return productLandmarkService.getShanxiMap();
    }
    /*@GetMapping("getIndustryAndType")
    public List<Map<String,Object>> getIndustryAndType(){
        return productLandmarkService.getIndustryAndType();
    }*/
}
