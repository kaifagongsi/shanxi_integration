package com.kfgs.admin.controller;

import com.alibaba.fastjson.JSON;
import com.kfgs.admin.service.AdminTrademarkService;
import com.kfgs.domain.TbGeographicalIndicationTrademark;
import com.kfgs.domain.response.QueryResponseResult;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/admin/trademark")
public class AdminTrademarkController {

    @Autowired
    AdminTrademarkService adminTrademarkService;

    @PostMapping("/getList")
    public QueryResponseResult getList(@RequestBody Map searchMap){
        return  adminTrademarkService.getList(searchMap);
    }

    @GetMapping("/selectOne")
    public QueryResponseResult selectOne(String id){
        return adminTrademarkService.selectOne(id);
    }

    @PostMapping("/saveTrademark")
    public QueryResponseResult saveTrademark(@RequestParam("file") MultipartFile file, @RequestParam("item") String item, HttpServletRequest httpRequest){
        System.out.println("接受到实体：" + item + ", 文件名称：" + file.getOriginalFilename());
        TbGeographicalIndicationTrademark trademark = JSON.parseObject(item, TbGeographicalIndicationTrademark.class);
        return adminTrademarkService.saveTrademark(file,trademark,httpRequest);
    }

    @PostMapping("/saveEntity")
    public QueryResponseResult saveEntity( @RequestBody TbGeographicalIndicationTrademark trademark, HttpServletRequest httpRequest){
        return adminTrademarkService.saveTrademark(null,trademark,httpRequest);
    }


    @DeleteMapping("deleteTrademark")
    public QueryResponseResult deleteTrademark(String id){
        return adminTrademarkService.deleteTrademark(id);
    }
}
