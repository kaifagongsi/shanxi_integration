package com.kfgs.admin.controller;

import com.kfgs.admin.service.AdminProductService;
import com.kfgs.domain.ext.TbProductExt;
import com.kfgs.domain.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Date: 2020-04-22-21-34
 * Module:
 * Description:
 *
 * @author:
 */
@RestController
@RequestMapping("admin/productController")
public class AdminProductController {


    @Autowired
    AdminProductService adminProductService;

    @PostMapping("/getAdminProductList")
    public QueryResponseResult getAdminProductList(@RequestBody Map map){
        return adminProductService.adminProductListLoad(map);
    }

    @PutMapping("/addProduct")
    public QueryResponseResult addProduct(@RequestBody TbProductExt tbProductExt){
        return adminProductService.addProduct(tbProductExt);
    }

    @GetMapping("/getSelectMap")
    public QueryResponseResult getSelectMap(){
        return adminProductService.getSelectMap();
    }
}
