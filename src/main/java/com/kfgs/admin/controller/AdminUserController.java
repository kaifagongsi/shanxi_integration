package com.kfgs.admin.controller;

import com.kfgs.admin.service.AdminUserService;
import com.kfgs.domain.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Date: 2020-05-07-10-27
 * Module:
 * Description:
 *
 * @author:
 */
@RestController
@RequestMapping("admin/userController")
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @GetMapping("/getLoginUser")
    public QueryResponseResult getLoginUser(){
       return adminUserService.getLoginUser();
    }

    @PostMapping("/checkOldPassword")
    public QueryResponseResult checkOldPassword(@RequestParam("username") String username, @RequestParam("oldPassword")String oldPassword){
        return adminUserService.checkOldPassword(username,oldPassword);
    }

    @PostMapping("/changePassword")
    public QueryResponseResult changePassword(@RequestParam("username") String username, @RequestParam("newPassword")String newPassword){
        return adminUserService.changePassword(username,newPassword);
    }
}
