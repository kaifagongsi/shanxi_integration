package com.kfgs.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 2020-04-13-10-05
 * Module:
 * Description:
 *
 * @author:
 */
@RestController
@RequestMapping("admin")
public class TestController {

    @GetMapping("/test")
    public String getTest(){
        return  "123456789";
    }
}
