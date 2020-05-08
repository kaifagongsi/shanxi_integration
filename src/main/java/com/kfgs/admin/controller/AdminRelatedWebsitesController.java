package com.kfgs.admin.controller;

import com.kfgs.admin.service.AdminRelatedWebsitesService;
import com.kfgs.domain.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
