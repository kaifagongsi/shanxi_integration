package com.kfgs.standard.controller;

import com.kfgs.standard.service.ProductStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
