package com.kfgs.statistics.controller;

import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.statistics.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Date: 2019-12-04-19-39
 * <p>Module:</p>
 * <p>Description:</p>
 *
 * @author:
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/selectAllApprovalYeat")
    public QueryResponseResult selectAllApprovalYeat(){
        System.out.println("11111111111111111111111");
        return  productService.selectByDistinctApprovalYear();
    }


    @PostMapping("/getList")
    public Map<String,Object> getList(@RequestBody Map searchMap){
        return productService.getList(searchMap);
    }

    @GetMapping("getProductInfo")
    public Map<String,Object> getProductInfo(String productId){
        return productService.getProductInfo(productId);
    }

}
