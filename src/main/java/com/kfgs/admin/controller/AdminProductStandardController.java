package com.kfgs.admin.controller;

import com.kfgs.admin.service.AdminProductStandardService;
import com.kfgs.domain.TbStandard;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.standard.service.ProductStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/productStandardController")
public class AdminProductStandardController {


    @Autowired
    ProductStandardService productStandardService;

    @Autowired
    AdminProductStandardService adminProductStandardService;

    @PostMapping("/getList")
    public QueryResponseResult getList(@RequestBody Map searchMap){
        Map<String, Object> map = productStandardService.getList(searchMap);
        QueryResponseResult queryResponseResult = new QueryResponseResult();
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(map);
        queryResponseResult.setQueryResult(queryResult);
        return  queryResponseResult;
    }

    @GetMapping("/intiProductStandard")
    public QueryResponseResult intiProductStandard(String id){
        return adminProductStandardService.getProductStandardInfo(id);
    }
}
