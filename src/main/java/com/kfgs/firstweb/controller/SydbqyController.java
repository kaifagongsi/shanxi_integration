package com.kfgs.firstweb.controller;

import com.kfgs.firstweb.service.SydbqyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/sydbqy")
public class SydbqyController {

    @Autowired
    private SydbqyService sydbqyService;

    @GetMapping("/text")
    public String text(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content‐type","text/html;charset=utf‐8");
        return sydbqyService.text();
    }

    @PostMapping("/getList")
    public Map<String,Object> getList(@RequestBody Map searchMap){
        return sydbqyService.getList(searchMap);
    }

   /* @RequestMapping("/search")
    public Map<String,Object> search(@RequestBody Map searchMap){
        return sydbqyService.search(searchMap);
    }*/



}
