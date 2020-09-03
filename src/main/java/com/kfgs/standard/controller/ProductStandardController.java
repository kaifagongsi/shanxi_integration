package com.kfgs.standard.controller;

import com.kfgs.standard.service.ProductStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/standard")
public class ProductStandardController {

    @Autowired
    private ProductStandardService productStandardService;

    @PostMapping("/getList")
    public Map<String,Object> getList(@RequestBody Map searchMap){
        return productStandardService.getList(searchMap);
    }

    @GetMapping("getStandardInfo")
    public Map<String,Object> getProductInfo(String standardName){
        return productStandardService.getStandardInfo(standardName);
    }
}
