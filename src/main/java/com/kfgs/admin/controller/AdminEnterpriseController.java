package com.kfgs.admin.controller;

import com.kfgs.admin.service.AdminEnterpriseService;
import com.kfgs.domain.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/enterpriseController")
public class AdminEnterpriseController {

    @Autowired
    AdminEnterpriseService adminEnterpriseService;

    @PostMapping("/getEnterpriseList")
    public QueryResponseResult getEnterpriseList(@RequestBody Map map){
        return adminEnterpriseService.getEnterpriseList(map);
    }
}
