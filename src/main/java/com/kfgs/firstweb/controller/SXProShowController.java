package com.kfgs.firstweb.controller;

import com.kfgs.firstweb.service.SXProShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sxdbcpzs")
public class SXProShowController {

    @Autowired
    SXProShowService sxProShowService;

    @PostMapping("/getlist")
    public List getList(){
        return sxProShowService.getList();
    }

    @PostMapping("/search")
    public Map<String, Object> search(){
        return sxProShowService.search();
    }

    /*@PostMapping("/search")
    public Map<String, List<String>> searchClass(){
        return sxProShowService.searchClass();
    }*/
}
