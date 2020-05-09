package com.kfgs.admin.controller;

import com.kfgs.admin.service.AdminRelatedWebsitesService;
import com.kfgs.domain.ext.TbRelatedWebsitesExt;
import com.kfgs.domain.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Date: 2020-05-08-17-08
 * Module:
 * Description:
 *
 * @author:
 */
@RestController
@RequestMapping("/admin/relatedWebsitesController")
public class AdminRelatedWebsitesController {

    @Autowired
    AdminRelatedWebsitesService adminRelatedWebsitesService;


    @PostMapping("/getRelatedWebsitesList")
    public QueryResponseResult getRelatedWebsitesList(@RequestBody Map map){
        return adminRelatedWebsitesService.getRelatedWebsitesList(map);
    }

    @PostMapping("/saveImg")
    public QueryResponseResult saveImg(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        return adminRelatedWebsitesService.saveImg(file,request);
    }

    @PutMapping("/saveRelatedModel")
    public QueryResponseResult c(@RequestBody TbRelatedWebsitesExt tbRelatedWebsitesExt){
        return adminRelatedWebsitesService.saveRelatedModel(tbRelatedWebsitesExt);
    }

    @GetMapping("/selectById")
    public QueryResponseResult selectById(String id){
        return adminRelatedWebsitesService.selectById(id);
    }

    @GetMapping("/loadProductRelatedWebsites")
    public QueryResponseResult loadProductRelatedWebsites(){
        return  adminRelatedWebsitesService.loadProductRelatedWebsites();
    }
    @PutMapping("/saveProductAboutEntAndWeb")
    public  QueryResponseResult saveProductAboutEntAndWeb(@RequestBody TbRelatedWebsitesExt tbRelatedWebsitesExt){
        return  adminRelatedWebsitesService.saveProductAboutEntAndWeb(tbRelatedWebsitesExt);
    }
}
